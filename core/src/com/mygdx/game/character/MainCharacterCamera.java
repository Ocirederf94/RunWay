package com.mygdx.game.character;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;

/**
 * Created by fredy on 09/09/2017.
 */

public class MainCharacterCamera extends OrthographicCamera {
    public MainCharacterCamera() {
        super();
        this.setToOrtho(true);
    }

    public void setCameraOnPlayer(float x, float y) {
        this.position.x = x;
        this.position.y = y;
        this.update();
    }

    public void updateCameraOnPlayer(float x, float y) {
        this.position.x += x;
        this.position.y += y;
        this.update();
    }
}
