package com.mygdx.game.player.character.controllers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad;
import com.mygdx.game.player.character.MainCharacter;
import com.mygdx.game.player.character.MainCharacterCamera;
import com.mygdx.game.utils.GameConstants;

/**
 * Created by fredy on 10/09/2017.
 */

public class MovementController extends Touchpad {
    private Stage stage;
    private static Skin touchPadSkin;
    private static TouchpadStyle touchpadStyle;
    private InputProcessor inputProcessor;
    private MainCharacter mainCharacter;
    private MainCharacterCamera mainCharacterCamera;

    public MovementController(MainCharacter mainCharacter) {
        super(GameConstants.MOVEMENT_TOUCHPAD_DEADZONE_RADIUS, setTouchpadStyle());
        this.setX(GameConstants.BORDER_SPACING);
        this.mainCharacter = mainCharacter;
        this.mainCharacterCamera = this.mainCharacter.getMainCharacterCamera();
        stage = new Stage();
        inputProcessor = stage;
        stage.addActor(this);
        stage.act(Gdx.graphics.getDeltaTime());
    }

    public void renderMovementController() {
        stage.draw();
    }

    public void moveMainCharacter() {
/*        mainCharacter.getMainCharacterCamera().translate(this.getKnobPercentX() * GameConstants.CHARACTER_VELOCITY,
                this.getKnobPercentY() * GameConstants.CHARACTER_VELOCITY);
        mainCharacter.getMainCharacterCamera().update();*/
        mainCharacter.getSprite().translate(this.getKnobPercentX() * GameConstants.CHARACTER_VELOCITY,
                this.getKnobPercentY() * GameConstants.CHARACTER_VELOCITY);
       // mainCharacter.getMainCharacterCamera().updateCameraOnPlayer();
        mainCharacter.getMainCharacterCamera().update();
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
        touchPadSkin.add(GameConstants.TOUCHPAD_BACKGROUND, new Texture(GameConstants.TOUCHPAD_BACKGROUND_IMAGE));
        touchPadSkin.add(GameConstants.TOUCHPAD_KNOB_BACKGROUND, new Texture(GameConstants.TOUCHPAD_KNOB_BACKGROUND_IMAGE));

        touchpadStyle = new TouchpadStyle();
        touchpadStyle.background = touchPadSkin.getDrawable(GameConstants.TOUCHPAD_BACKGROUND);
        touchpadStyle.knob = touchPadSkin.getDrawable(GameConstants.TOUCHPAD_KNOB_BACKGROUND);
        return touchpadStyle;
    }

    private Vector2 getVector2() {
        return new Vector2(this.getKnobPercentX(), this.getKnobPercentY());
    }
}
