package com.mygdx.game.character;

import com.badlogic.gdx.graphics.OrthographicCamera;

/**
 * Created by fredy on 09/09/2017.
 */

public class MainCharacterCamera extends OrthographicCamera {
    private MainCharacter mainCharacter;

    public MainCharacterCamera(MainCharacter mainCharacter){
        super();
        this.mainCharacter = mainCharacter;
    }

    public void setCameraOnPlayer(){
        this.position.x = mainCharacter.getMainCharacterPosition().getxPosition();
        this.position.y = mainCharacter.getMainCharacterPosition().getyPosition();
        this.update();
    }
}
