package com.mygdx.game.player.character.controllers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad;
import com.mygdx.game.player.character.MainCharacter;
import com.mygdx.game.player.character.wepons.LaserPointer;
import com.mygdx.game.utils.GameConstants;

/**
 * Created by fredy on 18/09/2017.
 */

public class DirectionController extends Touchpad {
    private Stage stage;
    private static Skin touchPadSkin;
    private static TouchpadStyle touchpadStyle;
    private InputProcessor inputProcessor;
    private LaserPointer laserPointer;
    private MainCharacter mainCharacter;

    public DirectionController(final MainCharacter mainCharacter, LaserPointer laserPointer) {
        super(GameConstants.DIRECTION_KNOB_DEADZONE_RADIUS, setTouchpadStyle());
        this.setResetOnTouchUp(false);
        this.laserPointer = laserPointer;
        this.setX(Gdx.graphics.getWidth() - (this.getWidth() + GameConstants.BORDER_SPACING));
        this.stage = new Stage();
        inputProcessor = stage;
        stage.addActor(this);
        stage.act(Gdx.graphics.getDeltaTime());
        this.mainCharacter = mainCharacter;
    }

    public void renderDirectionController() {
        stage.draw();
        mainCharacter.getSprite().setRotation(getVector().angle());
        pointLaserPointer();
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
        touchPadSkin.add(GameConstants.TOUCHPAD_DIRECTION__BACKGROUND, new Texture(GameConstants.TOUCHPAD_DIRECTION_BACKGROUND_IMAGE));
        touchPadSkin.add(GameConstants.TOUCHPAD_DIRECTION__KNOB_BACKGROUND, new Texture(GameConstants.TOUCHPAD_DIRECTION__KNOB_BACKGROUND_IMAGE));

        touchpadStyle = new TouchpadStyle();
        touchpadStyle.background = touchPadSkin.getDrawable(GameConstants.TOUCHPAD_DIRECTION__BACKGROUND);
        touchpadStyle.knob = touchPadSkin.getDrawable(GameConstants.TOUCHPAD_DIRECTION__KNOB_BACKGROUND);
        return touchpadStyle;
    }

    private Vector2 getVector() {
        return new Vector2(this.getKnobPercentX(), this.getKnobPercentY());
    }

    private void pointLaserPointer(){
        laserPointer.renderCircle();
        laserPointer.renderLaserPointer(mainCharacter.getSprite().getU(), mainCharacter.getSprite().getU2());
    }
}
