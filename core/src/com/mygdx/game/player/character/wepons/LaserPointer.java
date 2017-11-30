package com.mygdx.game.player.character.wepons;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.utils.GameConstants;

/**
 * Created by fredy on 23/09/2017.
 */

public class LaserPointer {
    private Sprite sprite;
    private SpriteBatch spriteBatch;
    private Texture texture;
    private float initialX = Gdx.graphics.getWidth() / 2;
    private float initialY = Gdx.graphics.getHeight() / 2;

    public LaserPointer(){
        this.texture = new Texture(GameConstants.LASER_IMAGE);
        sprite = new Sprite(texture);
        spriteBatch = new SpriteBatch();
        sprite.setPosition(initialX - (texture.getWidth() / 2), initialY - (texture.getHeight() / 2));

    }

    public void renderLaserPointer(){
        spriteBatch.begin();
        sprite.draw(spriteBatch);
        spriteBatch.end();
    }

    public void disposeLaserPointer() {
        spriteBatch.dispose();
    }

    public Sprite getSprite() {
        return sprite;
    }
}
