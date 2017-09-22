package com.mygdx.game.character.controllers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
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


    private float getAngle() {
        Vector2 v = new Vector2(this.getKnobPercentX(), this.getKnobPercentY());
        return v.angle();
    }

    private void initDirectionControllerListener(final MainCharacter mainCharacter) {
        this.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                mainCharacter.getSprite().setRotation(getAngle());
            }
        });
    }

    public DirectionController(final MainCharacter mainCharacter) {
        super(GameConstants.DIRECTION_KNOB_DEADZONE_RADIUS, setTouchpadStyle());
        this.setX(Gdx.graphics.getWidth() - this.getWidth());
        this.stage = new Stage();
        inputProcessor = stage;
        initDirectionControllerListener(mainCharacter);
    }

    public void renderDirectionController() {
        stage.addActor(this);
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
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
