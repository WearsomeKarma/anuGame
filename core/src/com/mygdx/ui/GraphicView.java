package com.mygdx.ui;

import com.mygdx.game.spatial.Position;

import java.util.ArrayList;

/**
 * A collection of GraphicControls which the user can interface with. This is mainly used for UI elements only.
 * */
public class GraphicView {
    private ArrayList<GraphicControl> controls = new ArrayList<GraphicControl>();

    /**
     * Returns all controls to be drawn by the sprite batch.
     * */
    public Graphic[] getDrawables()
    {
        Graphic[] draws = new Graphic[controls.size()];

        for(int i=0;i<controls.size();i++)
        {
            draws[i] = (Graphic) controls.get(i);
        }

        return draws;
    }

    public void update()
    {
        for(GraphicControl c : controls)
        {
            c.onUpdate();
        }
    }

    public void handleClick(Position pos)
    {
        for(GraphicControl c : controls)
        {
            if(c.isClickable() && c.isOnGraphic(pos))
            {
                c.onClick(pos);
            }
        }
    }

    public void handleHold(Position pos)
    {
        for(GraphicControl c : controls)
        {
            if (c.isHoldable() && c.isOnGraphic(pos))
            {
                c.onHold(pos);
            }
        }
    }
}
