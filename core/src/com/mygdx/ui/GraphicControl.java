package com.mygdx.ui;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.spatial.Area;
import com.mygdx.game.spatial.Position;

/**
 * A Graphic that responds to user input in some way.
 * */
public class GraphicControl extends Graphic {
    protected GraphicView graphicViewRef;
    protected GraphicControl parentControlRef;
    protected boolean clickable, holdable;
    protected boolean held = false;

    public GraphicControl(Texture texture, Area textureRegion, GraphicView graphicViewRef, GraphicControl parentControlRef, boolean clickable, boolean holdable) {
        super(texture, textureRegion);
        this.graphicViewRef = graphicViewRef;
        this.parentControlRef = parentControlRef;
        this.clickable = clickable;
        this.holdable = holdable;
    }

    public void onUpdate()
    {

    }

    public void onClick(Position pos)
    {

    }

    public void onHold(Position pos)
    {

    }

    public synchronized boolean isClickable()
    {
        return clickable;
    }

    public synchronized boolean isHoldable()
    {
        return holdable;
    }

    public synchronized Texture getTexture()
    {
        return texture;
    }
}
