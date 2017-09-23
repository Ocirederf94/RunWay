package com.mygdx.game.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.mygdx.game.player.character.MainCharacter;
import com.mygdx.game.player.character.MainCharacterCamera;
import com.mygdx.game.player.character.controllers.DirectionController;
import com.mygdx.game.player.character.controllers.MovementController;
import com.mygdx.game.player.character.controllers.ShootingController;

/**
 * Created by fredy on 23/09/2017.
 */

public class PlayerInitializer {
    private MainCharacter mainCharacter;
    private MovementController movementController;
    private DirectionController directionController;
    private ShootingController shootingController;
    private InputMultiplexer inputMultiplexer;

    private void addInputProcessorsToInputMultiplexer(InputProcessor inputProcessor) {
        inputMultiplexer.addProcessor(inputProcessor);
    }

    private void setMainCharacter() {
        mainCharacter.renderCharacter();
        movementController.renderMovementController();
        directionController.renderDirectionController();
        shootingController.renderShootingController();
        movementController.moveMainCharacter(mainCharacter);
    }

    public  PlayerInitializer(int x, int y){
        mainCharacter = new MainCharacter(x, y);
        movementController = new MovementController();
        directionController = new DirectionController(mainCharacter);
        shootingController = new ShootingController(movementController, directionController);
        inputMultiplexer = new InputMultiplexer();
        addInputProcessorsToInputMultiplexer(directionController.getInputProcessor());
        addInputProcessorsToInputMultiplexer(movementController.getInputProcessor());
        addInputProcessorsToInputMultiplexer(shootingController.getInputProcessor());
    }

    public void renderCharacterObjects(){
        setMainCharacter();
        Gdx.input.setInputProcessor(inputMultiplexer);
    }

    public void disposeCharacterObjects() {
        mainCharacter.disposeCharacterObjects();
        movementController.disposeStage();
        directionController.disposeStage();
        shootingController.disposeStage();
    }

    public MainCharacterCamera getCamera(){
        return mainCharacter.getMainCharacterCamera();
    }
}
