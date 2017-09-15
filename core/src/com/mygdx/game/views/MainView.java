package com.mygdx.game.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.character.MainCharacter;
import com.mygdx.game.constants.GameConstants;

/**
 * Created by fredy on 08/09/2017.
 */

public class MainView extends Stage {
    private Texture backgroundTexture;
    private SpriteBatch spriteBatch;
    private MainCharacter mainCharacter;
    private Batch batch;

    public MainView() {
        spriteBatch = new SpriteBatch();
        backgroundTexture = new Texture(GameConstants.MAIN_VIEW_BACKGROUND);
        mainCharacter = new MainCharacter(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }

    public void toRender() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        spriteBatch.begin();
        spriteBatch.draw(backgroundTexture, GameConstants.INT_ZERO, GameConstants.INT_ZERO, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        spriteBatch.end();
        mainCharacter.renderCharacter(spriteBatch);
    }

    public void toDispose(){
        spriteBatch.dispose();
        mainCharacter.disposeCharacterObjects();
    }
}
