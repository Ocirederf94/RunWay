package com.mygdx.game.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.player.PlayerInitializer;
import com.mygdx.game.utils.GameConstants;

/**
 * Created by fredy on 08/09/2017.
 */

public class MainView {
    private SpriteBatch backgroundSpriteBatch;
    private Texture texture;
    private PlayerInitializer playerInitializer;



    /**
     * Setting background image and projection matrix,
     * so default sprite camera changes to MainCharacterCamera
     */
    private void setBackgroundTexture() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        backgroundSpriteBatch.setProjectionMatrix(playerInitializer.getCamera().combined);
        backgroundSpriteBatch.begin();
        backgroundSpriteBatch.draw(texture, GameConstants.INT_ZERO, GameConstants.INT_ZERO, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        backgroundSpriteBatch.end();
    }



    public MainView() {
        backgroundSpriteBatch = new SpriteBatch();
        texture = new Texture(GameConstants.MAIN_VIEW_BACKGROUND);
        playerInitializer = new PlayerInitializer();

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
