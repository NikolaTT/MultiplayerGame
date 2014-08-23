package com.multiplayergame.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.multiplayergame.staticGameVariables.GameDimensions;

public class MainMenuScreen extends MultiplayerGameScreen{
	
	public Texture menuTex;
	public SpriteBatch batch;
	public OrthographicCamera orthCam;

	
	public MainMenuScreen(Game game) {
		super(game);
		// TODO Auto-generated constructor stub
		
		orthCam = new OrthographicCamera(GameDimensions.WIDTH,
				GameDimensions.HEIGHT);
		orthCam.position.set(GameDimensions.WIDTH / 2,
				GameDimensions.HEIGHT / 2, 0);
		orthCam.update();
		
		menuTex = new Texture(Gdx.files.internal("MainMenu.png"));
		batch = new SpriteBatch(10);
		batch.setProjectionMatrix(orthCam.combined);
	}

	@Override
	public void update(float delta) {
		// TODO Auto-generated method stub
		
		int currentX = Gdx.input.getX();
		int currentY = Gdx.input.getY();
		
		if(Gdx.input.isTouched() && currentX > 280 && currentX < 490 && currentY > 60 && currentY < 144){
			game.setScreen(new MultiplayerGameLoop(game));
		}
	}

	@Override
	public void draw(float delta) {
		// TODO Auto-generated method stub
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(menuTex, 0, 0);
		batch.end();
	}

}


//find game 280, 60 to 490, 144