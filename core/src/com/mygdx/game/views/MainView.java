package com.mygdx.game.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.character.MainCharacter;
import com.mygdx.game.character.controllers.MovementController;
import com.mygdx.game.character.controllers.DirectionController;
import com.mygdx.game.character.controllers.ShootingController;
import com.mygdx.game.constants.GameConstants;

/**
 * Created by fredy on 08/09/2017.
 */

public class MainView {
    private Texture backgroundTexture;
    private SpriteBatch backgroundSpriteBatch;
    private MainCharacter mainCharacter;
    private MovementController movementController;
    private DirectionController directionController;
    private ShootingController shootingController;
    private InputMultiplexer inputMultiplexer;

    private void addInputProcessorsToInputMultiplexer(InputProcessor inputProcessor) {
        inputMultiplexer.addProcessor(inputProcessor);
    }
    
    /**
    * Setting background image and projection matrix, 
    * so default sprite camera changes to MainCharacterCamera
    */
    private void setBackgroundTexture() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        backgroundSpriteBatch.setProjectionMatrix(mainCharacter.getMainCharacterCamera().combined);
        backgroundSpriteBatch.begin();
        backgroundSpriteBatch.draw(backgroundTexture, GameConstants.INT_ZERO, GameConstants.INT_ZERO, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        backgroundSpriteBatch.end();
    }

    private void setMainCharacter() {
        mainCharacter.renderCharacter();
        movementController.renderMovementController();
        directionController.renderDirectionController();
        shootingController.renderShootingController();
        movementController.moveMainCharacter(mainCharacter);
    }

    public MainView() {
        backgroundSpriteBatch = new SpriteBatch();
        backgroundTexture = new Texture(GameConstants.MAIN_VIEW_BACKGROUND);
        mainCharacter = new MainCharacter(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        movementController = new MovementController();
        directionController = new DirectionController(mainCharacter);
        shootingController = new ShootingController(movementController, directionController);
        inputMultiplexer = new InputMultiplexer();
        addInputProcessorsToInputMultiplexer(directionController.getInputProcessor());
        addInputProcessorsToInputMultiplexer(movementController.getInputProcessor());
        addInputProcessorsToInputMultiplexer(shootingController.getInputProcessor());
    }

    public void toRender() {
        setBackgroundTexture();
        setMainCharacter();
        Gdx.input.setInputProcessor(inputMultiplexer);
    }

    public void toDispose() {
        backgroundSpriteBatch.dispose();
        mainCharacter.disposeCharacterObjects();
        movementController.disposeStage();
        directionController.disposeStage();
        shootingController.disposeStage();
    }


}
