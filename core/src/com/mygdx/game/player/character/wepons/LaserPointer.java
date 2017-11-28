package com.mygdx.game.player.character.wepons;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import static com.mygdx.game.utils.GameConstants.LASER_LENGTH;

/**
 * Created by fredy on 23/09/2017.
 */

public class LaserPointer extends ShapeRenderer {
    private float initialX = Gdx.graphics.getWidth() / 2;
    private float initialY = Gdx.graphics.getHeight() / 2;
    private ShapeRenderer myCircle;

    public LaserPointer(){
        super();

    }

    public void renderLaserPointer(float x2, float y2){
        this.begin(ShapeType.Line);
        this.setColor(Color.RED);
        this.line(initialX, initialY , x2, y2, Color.YELLOW, Color.GREEN);
        this.end();
        Gdx.gl.glLineWidth(5);
    }

    public void renderCircle(){
        this.begin(ShapeType.Line);
        this.setColor(Color.RED);
        this.circle(initialX, initialY , LASER_LENGTH);
        this.end();
        Gdx.gl.glLineWidth(1);
    }


}
