package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.mygdx.game.views.MainView;


public class MyGdxGame extends Game {
    private MainView mainView;
    private BitmapFont bitmapFont;
    private SpriteBatch spriteBatch;

    private void renderBitMap(){
        spriteBatch.begin();
        bitmapFont.setColor(Color.YELLOW);
        bitmapFont.draw(spriteBatch, String.valueOf(Gdx.graphics.getFramesPerSecond()), 0, Gdx.graphics.getHeight());
        bitmapFont.getData().setScale(10);
        spriteBatch.end();
    }



    @Override
    public void create() {
        mainView = new MainView();
        spriteBatch = new SpriteBatch();
        bitmapFont = new BitmapFont();
    }

    @Override
    public void render() {
        mainView.toRender();
        renderBitMap();
    }

    @Override
    public void dispose() {
        mainView.toDispose();

    }
}
