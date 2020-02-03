package com.mygdx.game.spatial;

public class RectangularArea extends Area {

    private static final float[][] QUADRANT_PAIRS = new float[][]
            {
                    { 1f, -1f },
                    { -1f, -1f },
                    { -1f, 1f },
                    { 1f, 1f }
            };

    private final float width, height;

    public RectangularArea(Position centerOfVolume, World worldRef, float width, float height)
    {
        super(
                new Position[]
                        {
                                new Position(width/2, -height/2),
                                new Position(-width/2, -height/2),
                                new Position(-width/2, height/2),
                                new Position(width/2, height/2)
                        }
                , centerOfVolume, worldRef);
        this.width = width;
        this.height = height;
    }

    public float getWidth(){return width;}
    public float getHeight(){return height;}

    @Override
    public synchronized boolean withinArea(Position pos)
    {
        Position localizedPos = Position.localize(centerOfVolume, pos);
        Position comp;

        boolean ret = true;

        for(int i=0;i<QUADRANT_PAIRS.length;i++)
        {
            comp = Position.compareTo(significantPoints[i], localizedPos);
            ret = ret && comp.getX() == QUADRANT_PAIRS[i][0] && comp.getY() == QUADRANT_PAIRS[i][1];
        }

        return ret;
    }

    public boolean isOverlapingOn(CircularArea a)
    {
        return a.isOverlapingOn(this);
    }

    public boolean isOverlapingOn(RectangularArea a)
    {
        float ah2 = a.height/2;
        float aw2 = a.width/2;
        float h2 = height/2;
        float w2 = width/2;
        float dist = Position.getDistance(centerOfVolume, a.centerOfVolume);

        boolean ret1 = ah2 + h2 <= dist;
        boolean ret2 = aw2 + w2 <= dist;

        return ret1 || ret2;
    }
}
