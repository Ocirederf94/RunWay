package com.mygdx.game.player.character.wepons;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Created by fredy on 23/09/2017.
 */

public class LaserPointer extends ShapeRenderer {

    public LaserPointer(){
        super();

    }

    public void renderLaserPointer(float x2, float y2){
        this.begin(ShapeType.Line);
        this.setColor(Color.RED);
        this.line(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2 , x2, y2, Color.YELLOW, Color.GREEN);
        this.end();
        Gdx.gl.glLineWidth(1);
    }


}
