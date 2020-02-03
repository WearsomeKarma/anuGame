package com.mygdx.ui.implemented.controls;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.spatial.Area;
import com.mygdx.ui.GraphicControl;
import com.mygdx.ui.GraphicView;

public class MovementControl extends GraphicControl {
    public MovementControl(Texture texture, Area textureRegion, GraphicView graphicViewRef, GraphicControl parentControlRef, boolean clickable, boolean holdable) {
        super(texture, textureRegion, graphicViewRef, parentControlRef, clickable, holdable);
    }

    private class JoystickControl extends GraphicControl
    {
        public JoystickControl(Texture texture, Area textureRegion, GraphicView graphicViewRef, GraphicControl parentControlRef, boolean clickable, boolean holdable) {
            super(texture, textureRegion, graphicViewRef, parentControlRef, clickable, holdable);
        }
    }
}
