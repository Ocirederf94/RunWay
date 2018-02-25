package com.mygdx.game.player.character.controllers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad;
import com.mygdx.game.player.character.MainCharacter;

import static com.mygdx.game.utils.GameConstants.BORDER_SPACING;
import static com.mygdx.game.utils.GameConstants.DIRECTION_CONTROLLER_SIZE;
import static com.mygdx.game.utils.GameConstants.DIRECTION_KNOB_DEADZONE_RADIUS;
import static com.mygdx.game.utils.GameConstants.TOUCHPAD_DIRECTION_BACKGROUND_IMAGE;
import static com.mygdx.game.utils.GameConstants.TOUCHPAD_DIRECTION__BACKGROUND;
import static com.mygdx.game.utils.GameConstants.TOUCHPAD_DIRECTION__KNOB_BACKGROUND;
import static com.mygdx.game.utils.GameConstants.TOUCHPAD_DIRECTION__KNOB_BACKGROUND_IMAGE;


/**
 * Created by fredy on 18/09/2017.
 */

public class DirectionController extends Touchpad {
    private Stage stage;
    private static Skin touchPadSkin;
    private static TouchpadStyle touchpadStyle;
    private InputProcessor inputProcessor;
    private MainCharacter mainCharacter;
    private float initialX = Gdx.graphics.getWidth() / 2;
    private float initialY = Gdx.graphics.getHeight() / 2;

    public DirectionController(final MainCharacter mainCharacter) {
        super(DIRECTION_KNOB_DEADZONE_RADIUS, setTouchpadStyle());
        this.setResetOnTouchUp(false);
        this.setSize(DIRECTION_CONTROLLER_SIZE, DIRECTION_CONTROLLER_SIZE);
        this.setPosition(Gdx.graphics.getWidth() - (this.getWidth() + BORDER_SPACING), BORDER_SPACING * 4);
        this.setDeadzone((this.getWidth() / 2) - 1);
        this.stage = new Stage();
        inputProcessor = stage;
        stage.addActor(this);
        stage.act(Gdx.graphics.getDeltaTime());
        this.mainCharacter = mainCharacter;

    }

    public void renderDirectionController() {
        stage.draw();
        mainCharacter.getSprite().setRotation(getVector().angle());
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

    private static TouchpadStyle setTouchpadStyle() {
        touchPadSkin = new Skin();
        touchPadSkin.add(TOUCHPAD_DIRECTION__BACKGROUND, new Texture(TOUCHPAD_DIRECTION_BACKGROUND_IMAGE));
        touchPadSkin.add(TOUCHPAD_DIRECTION__KNOB_BACKGROUND, new Texture(TOUCHPAD_DIRECTION__KNOB_BACKGROUND_IMAGE));

        touchpadStyle = new TouchpadStyle();
        touchpadStyle.background = touchPadSkin.getDrawable(TOUCHPAD_DIRECTION__BACKGROUND);
        touchpadStyle.knob = touchPadSkin.getDrawable(TOUCHPAD_DIRECTION__KNOB_BACKGROUND);
        return touchpadStyle;
    }

    public Vector2 getVector() {
        return new Vector2(this.getKnobPercentX(), this.getKnobPercentY());
    }
}
