package com.mygdx.game.spatial;

public class CircularArea extends Area {
    private float radius;

    public CircularArea(Position centerOfVolume, World worldRef, float radius) {
        super(null, centerOfVolume, worldRef);
        this.radius = radius;
    }

    @Override
    public boolean withinArea(Position pos) {
        return Position.getDistance(centerOfVolume, pos) <= radius;
    }

    public boolean isOverlapingOn(CircularArea a) {
        return a.radius + radius <= Position.getDistance(a.centerOfVolume, centerOfVolume);
    }

    public boolean isOverlapingOn(RectangularArea a) {
        float h2 = a.getHeight() / 2;
        float w2 = a.getWidth() / 2;
        float dist = Position.getDistance(centerOfVolume, a.centerOfVolume);

        boolean ret1 = h2 + radius <= dist;
        boolean ret2 = w2 + radius <= dist;

        return ret1 || ret2;
    }
}
