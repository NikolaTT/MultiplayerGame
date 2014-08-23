package com.multiplayergame.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

public abstract class MultiplayerGameScreen implements Screen{
	
	Game game;

	public MultiplayerGameScreen (Game game) {
		this.game = game;
	}
	
	
	public abstract void update (float delta);

	/** Called when a screen should render itself */
	public abstract void draw (float delta);

	
	
	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		update(delta);
		draw(delta);
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
