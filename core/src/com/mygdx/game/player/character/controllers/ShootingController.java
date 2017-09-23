package com.mygdx.game.player.character.controllers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.game.constants.GameConstants;

/**
 * Created by fredy on 10/09/2017.
 */

public class ShootingController extends ImageButton {
    private Stage stage;
    private InputProcessor inputProcessor;
    private static Drawable drawable;

    private static Drawable initButtonSkin() {
        return drawable = new TextureRegionDrawable(new TextureRegion(new Texture(GameConstants.SHOOTING_CONTROLLER_BACKGROUND_IMAGE)));
    }

    private void initShootingControllerListener() {
        setProgrammaticChangeEvents(true);
        this.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if (isPressed()) {
                 
                }
            }
        });
    }

    public ShootingController(MovementController movementController, DirectionController directionController) {
        super(initButtonSkin());
        this.setX(movementController.getWidth() + GameConstants.GENERAL_SPACING);
        this.setY(movementController.getHeight() - (this.getHeight() * GameConstants.FLOAT_ONE_FIVE));
        this.setWidth(Gdx.graphics.getWidth() - ((GameConstants.GENERAL_SPACING
                * GameConstants.INT_TWO) + movementController.getWidth()
                + directionController.getWidth()));
        stage = new Stage();
        inputProcessor = stage;
        initShootingControllerListener();
    }

    public void renderShootingController() {
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
}
