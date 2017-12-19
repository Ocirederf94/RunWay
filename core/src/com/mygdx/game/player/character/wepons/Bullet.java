package com.mygdx.game.player.character.wepons;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.mygdx.game.player.character.controllers.DirectionController;

/**
 * Created by fredy on 22/09/2017.
 */

public class Bullet {
    private SpriteBatch spriteBatch;
    private Sprite sprite;
    private float initialX = Gdx.graphics.getWidth() / 2;
    private float initialY = Gdx.graphics.getHeight() / 2;
    private DirectionController directionController;
    float dx, dy , knobX, knobY;

    public Bullet(Texture texture, DirectionController directionController){
        this.sprite = new Sprite(texture);
        this.spriteBatch = new SpriteBatch();
        this.directionController = directionController;
        sprite.setPosition(initialX - (texture.getWidth() / 2), initialY - (texture.getHeight() / 2));
        this.knobX = directionController.getKnobPercentX();
        this.knobY = directionController.getKnobPercentY();
        this.dx = MathUtils.cos(3.1415f / 4);
        this.dy = MathUtils.sin(3.1415f / 4);
        Gdx.app.log("knobX" , String.valueOf(knobX));
        Gdx.app.log("knobY" , String.valueOf(knobY));
    }

    public void renderBullet(){
        this.sprite.translate(dx * (knobX ),dy * (knobY ));
        this.spriteBatch.begin();
        this.sprite.draw(spriteBatch);
        this.spriteBatch.end();
    }

    public void disposeBullet(){
        spriteBatch.dispose();
    }
}
