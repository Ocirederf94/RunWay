package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.mygdx.game.views.MainView;


public class MyGdxGame extends Game {
	private MainView mainView;
	
	@Override
	public void create () {
		mainView = new MainView();

	}

	@Override
	public void render () {
		mainView.toRender();
	}
	
	@Override
	public void dispose () {
		mainView.toDispose();
	}
}
