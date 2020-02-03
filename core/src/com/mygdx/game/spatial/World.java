package com.mygdx.game.spatial;

import java.util.ArrayList;

public class World {
    public static final Position ABSOLUTE_ORIGIN = new Position(0,0);

    private ArrayList<Entity> entities = new ArrayList<Entity>();
    private final Position origin;

    public World(Position origin)
    {
        this.origin = origin;
    }

    public World()
    {
        this.origin = new Position(ABSOLUTE_ORIGIN);
    }

    public void addEntity(Entity e)
    {
        if (!entities.contains(e))
            entities.add(e);
    }

    public Position getOrigin()
    {
        synchronized (origin)
        {
            return origin;
        }
    }

    /**
     * Returns entities based on a selection scheme.
     * @pos the center point of selection.
     * @offset the region in reference to the selection. X,Y pair is top left. X only is for radius.
     * */
    public Entity[] getEntities(BoundsCheckMode mode, Position pos, Position offset)
    {
        ArrayList<Entity> ret = new ArrayList<Entity>();

        for(Entity e : entities)
        {
            if (e.inBoundsExternalRegion(mode, pos, offset))
            {
                ret.add(e);
            }
        }

        return (Entity[]) ret.toArray();
    }
}
