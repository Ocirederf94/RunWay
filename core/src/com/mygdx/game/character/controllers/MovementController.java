package com.mygdx.game.character.controllers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad;
import com.mygdx.game.character.MainCharacter;
import com.mygdx.game.constants.GameConstants;

/**
 * Created by fredy on 10/09/2017.
 */

public class MovementController extends Touchpad {
    private static Skin touchPadSkin;
    private static TouchpadStyle touchpadStyle;

    private static TouchpadStyle setTouchpadStyle() {
        touchPadSkin = new Skin();
        touchPadSkin.add(GameConstants.TOUCHPAD_BACKGROUDN, new Texture(GameConstants.TOUCHPAD_BACKGROUND_IMAGE));
        touchPadSkin.add(GameConstants.TOUCHPAD_KNOB_BACKGROUDN, new Texture(GameConstants.TOUCHPAD_KNOB_BACKGROUND_IMAGE));

        touchpadStyle = new TouchpadStyle();
        touchpadStyle.background = touchPadSkin.getDrawable(GameConstants.TOUCHPAD_BACKGROUND);
        touchpadStyle.knob = touchPadSkin.getDrawable(GameConstants.TOUCHPAD_KNOB_BACKGROUND);
        return touchpadStyle;
    }


    public MovementController() {
        super(GameConstants.MOVEMENT_TOUCHPAD_DEADZONE_RADIUS, setTouchpadStyle());
    }

    public void renderMovementController(Stage stage){
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }

    public void moveMainCharacter(MainCharacter mainCharacter){

    }

    @Override
    public void act(float delta) {
        super.act(delta);


    }
}
