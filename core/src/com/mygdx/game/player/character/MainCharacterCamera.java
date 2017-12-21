package com.mygdx.game.player.character;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;

/**
 * Created by fredy on 09/09/2017.
 */

public class MainCharacterCamera extends OrthographicCamera {
    private MainCharacter mainCharacter;
    private float totalWidth, totalHeight, charSpriteHalfWidth, charSpriteHalfHeight;

    public MainCharacterCamera(MainCharacter mainCharacter) {
        super();
        this.mainCharacter = mainCharacter;
        this.setToOrtho(false);
        this.totalWidth = Gdx.graphics.getWidth();
        this.totalHeight = Gdx.graphics.getHeight();
        this.charSpriteHalfWidth = mainCharacter.getSprite().getWidth() / 2;
        this.charSpriteHalfHeight = mainCharacter.getSprite().getHeight() / 2;
    }

    public void setCameraOnPlayer(float x, float y) {
        this.position.x = x;
        this.position.y = y;
        this.update();
    }

    public void updateCameraOnPlayer() {
        float palayetXToMiddle = mainCharacter.getSprite().getX() + charSpriteHalfWidth;
        float palayetYToMiddle = mainCharacter.getSprite().getY() + charSpriteHalfHeight;
        this.position.x = palayetXToMiddle - totalWidth ;
        this.position.y = palayetYToMiddle - totalHeight;
        this.update();
    }


}
