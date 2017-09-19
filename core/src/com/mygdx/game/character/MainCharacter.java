package com.mygdx.game.character;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Shape;
import com.mygdx.game.constants.GameConstants;



/**
 * Created by fredy on 08/09/2017.
 */

public class MainCharacter extends Shape {
    private ShapeRenderer shapeRenderer;
    private MainCharacterCamera mainCharacterCamera;
    private int widthPosition, heightPosition;

    public MainCharacter(int width, int height ) {
        shapeRenderer = new ShapeRenderer();
        mainCharacterCamera = new MainCharacterCamera(this);
        widthPosition = width / GameConstants.INT_TWO;
        heightPosition = height / GameConstants.INT_TWO;
    }

    public void renderCharacter(){
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.RED);
        shapeRenderer.circle(widthPosition, heightPosition, GameConstants.CHARACTER_RADIUS);
        this.setCharacterPositionOnCamera(widthPosition, heightPosition);
        shapeRenderer.end();
    }

    public void disposeCharacterObjects(){
        this.dispose();
    }
    
    
    public void setCharacterPositionOnCamera(int x, int y){
        mainCharacterCamera.setCameraOnPlayer(x, y);
    }

    @Override
    public Type getType() {
        return null;
    }

    public ShapeRenderer getShape(){
        return shapeRenderer;
    }
}
