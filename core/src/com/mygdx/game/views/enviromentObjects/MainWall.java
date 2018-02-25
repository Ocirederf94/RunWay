package com.mygdx.game.views.enviromentObjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import static com.mygdx.game.utils.GameConstants.WALL_IMAGE;
import static com.mygdx.game.utils.GameConstants.WALL_SIZR;

/**
 * Created by fredy on 25/02/2018.
 */

public class MainWall {
    private Texture texture;
    private SpriteBatch spriteBatch;
    private Sprite sprite;

    public MainWall(float x, float y) {
        this.texture = new Texture(WALL_IMAGE);
        this.sprite = new Sprite(texture);
        this.spriteBatch = new SpriteBatch();
        this.sprite.setBounds(x, y, WALL_SIZR, WALL_SIZR);
    }

    private void drawWall() {
        spriteBatch.begin();
        sprite.draw(spriteBatch);
        spriteBatch.end();
    }

    private MainWall() {
        this.spriteBatch.dispose();
    }
}
