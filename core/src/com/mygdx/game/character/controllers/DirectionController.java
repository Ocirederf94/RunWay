package com.mygdx.game.character.controllers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad;
import com.mygdx.game.character.MainCharacter;
import com.mygdx.game.constants.GameConstants;

/**
 * Created by fredy on 18/09/2017.
 */

public class DirectionController extends Touchpad {
    private Stage stage;
    private static Skin touchPadSkin;
    private static TouchpadStyle touchpadStyle;
    private InputProcessor inputProcessor;

    private static TouchpadStyle setTouchpadStyle() {
        touchPadSkin = new Skin();
        touchPadSkin.add(GameConstants.TOUCHPAD_DIRECTION__BACKGROUND, new Texture(GameConstants.TOUCHPAD_DIRECTION_BACKGROUND_IMAGE));
        touchPadSkin.add(GameConstants.TOUCHPAD_DIRECTION__KNOB_BACKGROUND, new Texture(GameConstants.TOUCHPAD_DIRECTION__KNOB_BACKGROUND_IMAGE));

        touchpadStyle = new TouchpadStyle();
        touchpadStyle.background = touchPadSkin.getDrawable(GameConstants.TOUCHPAD_DIRECTION__BACKGROUND);
        touchpadStyle.knob = touchPadSkin.getDrawable(GameConstants.TOUCHPAD_DIRECTION__KNOB_BACKGROUND);
        return touchpadStyle;
    }


    public DirectionController() {
        super(GameConstants.DIRECTION_KNOB_DEADZONE_RADIUS, setTouchpadStyle());
        this.setX(Gdx.graphics.getWidth() - this.getWidth());
        this.stage = new Stage();
        inputProcessor = stage;
    }

    public void renderdirectionController() {
        stage.addActor(this);
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }

    public void directMainCharacter(MainCharacter mainCharacter) {
        Vector2 vector2 = new Vector2(this.getKnobPercentX(), this.getKnobPercentY());
        float angle = vector2.angle();
        mainCharacter.getSprite().rotate(angle);
    }

    public InputProcessor getInputProcessor() {
        return inputProcessor;
    }

    public void disposeStage() {
        stage.dispose();
    }

    @Override
    public void act(float delta) {
        super.act(delta);


    }
}
