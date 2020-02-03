package com.mygdx.game.spatial;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.ui.Graphic;
import com.mygdx.ui.GraphicView;

public class Camera {
    private Position position, offset;
    private World worldRef;
    private GraphicView uiRef;

    public Camera(World worldRef, GraphicView uiRef)
    {
        this.worldRef = worldRef;
        this.uiRef = uiRef;
    }

    /**
     * Draws the full GraphicView UI element, and all entities in view.
     * */
    public void drawView(SpriteBatch batch)
    {
        Entity[] visibleEntities = worldRef.getEntities(BoundsCheckMode.RECTANGULAR, position, offset);

        for(Entity e: visibleEntities) {
            batch.draw(e.getTexture(), e.getPosition().getX(), e.getPosition().getY());
        }

        Graphic[] ui_Elements = uiRef.getDrawables();
        for(Graphic d: ui_Elements) {
            batch.draw(d.getTexture(), d.getPosition().getX(), d.getPosition().getY());
        }
    }
}
