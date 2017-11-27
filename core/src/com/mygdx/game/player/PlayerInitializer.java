package com.mygdx.game.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.mygdx.game.player.character.MainCharacter;
import com.mygdx.game.player.character.MainCharacterCamera;
import com.mygdx.game.player.character.controllers.DirectionController;
import com.mygdx.game.player.character.controllers.MovementController;
import com.mygdx.game.player.character.controllers.ShootingController;
import com.mygdx.game.player.character.wepons.LaserPointer;

/**
 * Created by fredy on 23/09/2017.
 */

public class PlayerInitializer {
    private MainCharacter mainCharacter;
    private MovementController movementController;
    private DirectionController directionController;
    private ShootingController shootingController;
    private InputMultiplexer inputMultiplexer;
    private LaserPointer laserPointer;

    public  PlayerInitializer(int x, int y){
        mainCharacter = new MainCharacter(x, y);
        laserPointer = new LaserPointer();
        movementController = new MovementController(laserPointer);
        directionController = new DirectionController(mainCharacter, laserPointer);
        shootingController = new ShootingController(movementController, directionController);
        inputMultiplexer = new InputMultiplexer();
        addInputProcessorsToInputMultiplexer(directionController.getInputProcessor(), movementController.getInputProcessor(), shootingController.getInputProcessor());
        Gdx.input.setInputProcessor(inputMultiplexer);
    }

    public void renderCharacterObjects(){
        setMainCharacter();
    }

    public void disposeCharacterObjects() {
        mainCharacter.disposeCharacterObjects();
        movementController.disposeStage();
        directionController.disposeStage();
        shootingController.disposeStage();
        laserPointer.dispose();
    }

    public MainCharacterCamera getCamera(){
        return mainCharacter.getMainCharacterCamera();
    }

    private void addInputProcessorsToInputMultiplexer(InputProcessor... inputProcessor) {
        for (InputProcessor processor: inputProcessor) {
            inputMultiplexer.addProcessor(processor);
        }
    }

    private void setMainCharacter() {
        mainCharacter.renderCharacter();
        movementController.renderMovementController();
        directionController.renderDirectionController();
        shootingController.renderShootingController();
        movementController.moveMainCharacter(mainCharacter);
    }
}
