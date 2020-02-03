package com.mygdx.game.spatial;

public abstract class Area {
    protected final Position[] significantPoints;
    protected Position centerOfVolume;
    private World worldRef;

    /**
     * @param significantPoints These are localized points around the centerOfVolume.
     * */
    public Area(Position[] significantPoints, Position centerOfVolume, World worldRef)
    {
        this.significantPoints = significantPoints;
        this.centerOfVolume = centerOfVolume;
        this.worldRef = worldRef;
    }

    public Position[] getSignificantPoints(){ return significantPoints;}
    public Position getCenterOfVolume(){ return centerOfVolume;}
    public World getWorldRef(){ return worldRef;}

    public synchronized void setCenterOfVolume(Position pos){ centerOfVolume = pos; }

    public abstract boolean withinArea(Position pos);
    public boolean isOverlapingOn(Area a)
    {
        return centerOfVolume.equals(a.centerOfVolume);
    }

    public boolean equals(Area a)
    {
        boolean ret = true;

        ret = ret && a.centerOfVolume.equals(centerOfVolume);
        ret = ret && a.worldRef == worldRef;
        ret = ret && a.significantPoints.length == significantPoints.length;

        if (ret)
        {
            for(int i=0;ret && i < significantPoints.length;i++)
            {
                ret = significantPoints[i].equals(a.significantPoints[i]);
            }
        }

        return ret;
    }
}
