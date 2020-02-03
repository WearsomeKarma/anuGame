package com.mygdx.ui.genericControls;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.spatial.Area;
import com.mygdx.game.spatial.Position;
import com.mygdx.ui.GraphicControl;
import com.mygdx.ui.GraphicView;

public abstract class DragControl extends GraphicControl {
    protected boolean snapX, snapY, returnToOrigin;
    protected float returnRate;

    public DragControl(Texture texture, Area textureRegion, GraphicView graphicViewRef, GraphicControl parentControlRef, boolean snapX, boolean snapY, boolean returnToOrigin) {
        super(texture, textureRegion, graphicViewRef, parentControlRef, false, true);
        this.snapY = snapY;
        this.snapX = snapX;
        this.returnToOrigin = returnToOrigin;
    }

    @Override
    public void onUpdate()
    {
        if (!held) {
            Position deltaPos = Position.localize(parentControlRef.getPosition(), getPosition());
            Position newPos = new Position(
                    (snapX) ? 0 : (deltaPos.getX() * returnRate) / Gdx.graphics.getDeltaTime(),
                    (snapY) ? 0 : (deltaPos.getY() * returnRate) / Gdx.graphics.getDeltaTime()
            );
        }
    }

    @Override
    public void onHold(Position pos)
    {
        if (snapX)
            setPosition(pos.getPosAsX());
        else if (snapY)
            setPosition(pos.getPosAsY());
        else
            setPosition(pos);
    }
}
