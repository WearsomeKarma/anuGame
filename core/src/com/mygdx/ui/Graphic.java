package com.mygdx.ui;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.spatial.Area;
import com.mygdx.game.spatial.Position;
import com.sun.corba.se.impl.orb.ParserTable;

/**
 * An object that is drawn to the screen.
 * */
public class Graphic {
    protected Texture texture;
    private Area textureRegion;

    public Texture getTexture() {return texture;}

    public boolean overlapingGraphic(Graphic g)
    {
        return textureRegion.isOverlapingOn(g.textureRegion);
    }

    public boolean isOnGraphic(Position pos)
    {
        return textureRegion.withinArea(pos);
    }

    public  void setPosition(Position pos)
    {
        textureRegion.setCenterOfVolume(pos);
    }

    public Position getPosition(){return textureRegion.getCenterOfVolume();}

    public Graphic(Texture texture, Area textureRegion)
    {
        this.texture = texture;
        this.textureRegion = textureRegion;
    }
}
