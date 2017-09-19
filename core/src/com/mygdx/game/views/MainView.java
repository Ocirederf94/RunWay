package com.mygdx.game.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.character.MainCharacter;
import com.mygdx.game.character.controllers.MovementController;
import com.mygdx.game.character.controllers.DirectionController;
import com.mygdx.game.constants.GameConstants;

/**
 * Created by fredy on 08/09/2017.
 */

public class MainView extends Stage {
    private Texture backgroundTexture;
    private SpriteBatch backgroundSpriteBatch;
    private MainCharacter mainCharacter;
    private MovementController movementController;
    private DirectionController directionController;

    public MainView() {
        backgroundSpriteBatch = new SpriteBatch();
        backgroundTexture = new Texture(GameConstants.MAIN_VIEW_BACKGROUND);
        mainCharacter = new MainCharacter(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        movementController = new MovementController();
        directionController = new DirectionController();
        this.addActor(movementController);
        Gdx.input.setInputProcessor(this);
    }

    public void toRender() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        backgroundSpriteBatch.begin();
        backgroundSpriteBatch.draw(backgroundTexture, GameConstants.INT_ZERO, GameConstants.INT_ZERO, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        backgroundSpriteBatch.end();
        mainCharacter.renderCharacter();
        movementController.renderMovementController(this);
        directionController.renderdirectionController();
        movementController.moveMainCharacter(mainCharacter);
        renderdirectionController.directMainCharacter(mainCharacter);
    }

    public void toDispose(){
        backgroundSpriteBatch.dispose();
        mainCharacter.disposeCharacterObjects();
        this.dispose();
    }
}
