package com.mygdx.game.character.controllers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad;
import com.mygdx.game.constants.GameConstants;

/**
 * Created by fredy on 10/09/2017.
 */

public class MovementController extends Touchpad {
    private static Skin touchPadSkin;
    private static TouchpadStyle touchpadStyle;

    public MovementController(float deadzoneRadius, TouchpadStyle style) {
        super(deadzoneRadius, setTouchpadStyle());
    }


    private static TouchpadStyle setTouchpadStyle() {
        touchPadSkin = new Skin();
        touchPadSkin.add(GameConstants.TOUCHPAD_BACKGROUDN, new Texture(GameConstants.TOUCHPAD_BACKGROUDN_IMAGE));
        touchPadSkin.add(GameConstants.TOUCHPAD_KNOB_BACKGROUDN, new Texture(GameConstants.TOUCHPAD_KNOB_BACKGROUDN_IMAGE));

        touchpadStyle = new TouchpadStyle();
        touchpadStyle.background = touchPadSkin.getDrawable(GameConstants.TOUCHPAD_BACKGROUDN);
        touchpadStyle.knob = touchPadSkin.getDrawable(GameConstants.TOUCHPAD_KNOB_BACKGROUDN);
        return touchpadStyle;
    }

    @Override
    public void act(float delta) {
        super.act(delta);


    }
}
