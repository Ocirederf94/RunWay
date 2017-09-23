package com.mygdx.game.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.player.PlayerInitializer;
import com.mygdx.game.player.character.MainCharacter;
import com.mygdx.game.player.character.controllers.MovementController;
import com.mygdx.game.player.character.controllers.DirectionController;
import com.mygdx.game.player.character.controllers.ShootingController;
import com.mygdx.game.constants.GameConstants;

/**
 * Created by fredy on 08/09/2017.
 */

public class MainView {
    private SpriteBatch backgroundSpriteBatch;
    private PlayerInitializer playerInitializer;


    
    /**
    * Setting background image and projection matrix, 
    * so default sprite camera changes to MainCharacterCamera
    */
    private void setBackgroundTexture() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        backgroundSpriteBatch.setProjectionMatrix(playerInitializer.getCamera().combined);
        backgroundSpriteBatch.begin();
        backgroundSpriteBatch.draw(new Texture(GameConstants.MAIN_VIEW_BACKGROUND), GameConstants.INT_ZERO, GameConstants.INT_ZERO, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        backgroundSpriteBatch.end();
    }



    public MainView() {
        backgroundSpriteBatch = new SpriteBatch();
        playerInitializer = new PlayerInitializer(Gdx.graphics.getWidth() / GameConstants.INT_TWO, Gdx.graphics.getHeight() / GameConstants.INT_TWO);

    }

    public void toRender() {
        setBackgroundTexture();
        playerInitializer.renderCharacterObjects();
    }

    public void toDispose() {
        backgroundSpriteBatch.dispose();
        playerInitializer.disposeCharacterObjects();
    }


}
