package com.mygdx.game.spatial;

public class Position {
    private final float x, y;
    private boolean isLocalized = false;

    public Position(float x, float y)
    {
        this.x = x;
        this.y = y;
    }

    public Position(Position pos)
    {
        this.x = pos.x;
        this.y = pos.y;
        this.isLocalized = pos.isLocalized;
    }

    public Position()
    {
        this.x = 0;
        this.y = 0;
    }

    public boolean Equals(Position pos)
    {
        return (x == pos.x && y == pos.y);
    }

    public float getX()
    {
        return x;
    }

    public float getY()
    {
        return y;
    }

    public Position getPosAsX()
    {
        return new Position(x, 0);
    }

    public Position getPosAsY()
    {
        return new Position(0, y);
    }

    public static float getDistance(Position pos1, Position pos2)
    {
        Position localizedPosition = localize(pos1, pos2);

        return (float)Math.sqrt((float)Math.pow(localizedPosition.x, 2) + (float)Math.pow(localizedPosition.y, 2));
    }

    public static Position compareTo(Position pos1, Position pos2)
    {
        Position localizedPosition = localize(pos1, pos2);

        Position ret = new Position(Math.signum(localizedPosition.x), Math.signum(localizedPosition.y));

        return ret;
    }

    /**
     * Returns a new position that is localized in respect to the given origin.
     * */
    public static Position localize(Position origin, Position worldPosition)
    {
        if (worldPosition.isLocalized)
        {
            return new Position(worldPosition);
        }

        Position ret = new Position(origin.x - worldPosition.x, origin.y - worldPosition.y);
        ret.isLocalized = true;
        return ret;
    }
}
