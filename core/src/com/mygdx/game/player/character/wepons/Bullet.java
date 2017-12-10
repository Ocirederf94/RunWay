package com.mygdx.game.player.character.wepons;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import static com.mygdx.game.utils.GameConstants.BULLET_IMAGE;

/**
 * Created by fredy on 22/09/2017.
 */

public class Bullet {
    private Texture texture;
    private SpriteBatch spriteBatch;
    private Sprite sprite;
    private float initialX = Gdx.graphics.getWidth() / 2;
    private float initialY = Gdx.graphics.getHeight() / 2;

    public Bullet(){
        this.texture = new Texture(BULLET_IMAGE);
        this.sprite = new Sprite(texture);
        this.spriteBatch = new SpriteBatch();
        sprite.setPosition(initialX - (texture.getWidth() / 2), initialY - (texture.getHeight() / 2));

    }

    public void renderBullet(){
        this.spriteBatch.begin();
        this.sprite.draw(spriteBatch);
        this.spriteBatch.end();
    }

    public void disposeBullet(){
        texture.dispose();
        spriteBatch.dispose();
    }
}
