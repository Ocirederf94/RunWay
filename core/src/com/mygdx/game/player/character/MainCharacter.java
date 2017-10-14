package com.mygdx.game.player.character;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.utils.GameConstants;


/**
 * Created by fredy on 08/09/2017.
 */

public class MainCharacter {
    private Texture mainCharacterTexture;
    private SpriteBatch spriteBatch;
    private Sprite sprite;
    private MainCharacterCamera mainCharacterCamera;

    private void setSpriteBatchAndSprite() {
        spriteBatch.begin();
        sprite.draw(spriteBatch);
        spriteBatch.end();
    }

    public MainCharacter(int width, int height) {
        mainCharacterTexture = new Texture(GameConstants.MAIN_CHARACTER_BACKGROUND);
        sprite = new Sprite(mainCharacterTexture);
        spriteBatch = new SpriteBatch();
        mainCharacterCamera = new MainCharacterCamera();
        sprite.setPosition(width, height);
        mainCharacterCamera.setCameraOnPlayer(width, height);
    }

    public void renderCharacter() {
        setSpriteBatchAndSprite();
    }

    public void disposeCharacterObjects() {
        spriteBatch.dispose();
    }

    public Sprite getSprite() {
        return sprite;
    }

    public MainCharacterCamera getMainCharacterCamera() {
        return mainCharacterCamera;
    }

}
