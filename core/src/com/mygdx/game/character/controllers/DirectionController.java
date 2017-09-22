package com.mygdx.game.character.controllers;

import java.lang.Math;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
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

    private float getAngleX(float knobX){
        return ((-knobX * 90) / 150);
    }

    private float reverseAngle(){
        Vector2 v = new Vector2(this.getKnobPercentX(), this.getKnobPercentY());
        return v.angle();    
    }
    
    private void initDirectionControllerListener(){
            float degree;
            this.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                float deltaX = ((Touchpad) actor).getKnobX();
                float deltaY = ((Touchpad) actor).getKnobY();

                degree = mainCharacter.getSprite().getRotation();
                mainCharacter.getSprite().rotate(-degree);
                // mainCharacter.getSprite().rotate(reverseAngle());
                if (deltaX > 15f && deltaY < 150){ // bottom
                    mainCharacter.getSprite().rotate(getAngleX(deltaX));
                }
                else {
                   mainCharacter.getSprite().rotate(-getAngleX(deltaX));
                }
                Gdx.app.log("Kob x ", String.valueOf(getAngleX(deltaX)) + " and y " + String.valueOf(getKnobY()) + " " + mainCharacter.getSprite().getRotation());
            }
        });
    }

    public DirectionController(final MainCharacter mainCharacter) {
        super(GameConstants.DIRECTION_KNOB_DEADZONE_RADIUS, setTouchpadStyle());
        this.setX(Gdx.graphics.getWidth() - this.getWidth());
        this.stage = new Stage();
        inputProcessor = stage;
        initDirectionControllerListener();
    }

    public void renderdirectionController() {
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
