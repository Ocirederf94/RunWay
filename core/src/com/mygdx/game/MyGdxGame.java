package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.FPSLogger;
import com.mygdx.game.views.MainView;


public class MyGdxGame extends Game {
    private MainView mainView;
    private FPSLogger fpsLogger = new FPSLogger();

    @Override
    public void create() {
        mainView = new MainView();

    }

    @Override
    public void render() {
        mainView.toRender();
        //fpsLogger.log();
    }

    @Override
    public void dispose() {
        mainView.toDispose();
    }
}
