package com.mygdx.game.spatial;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.ui.Graphic;

public class Entity extends Graphic {
    private World worldRef;

    public Entity(Texture texture, Area textureRegion, World worldRef) {
        super(texture, textureRegion);
        this.worldRef = worldRef;
    }
}
