package com.multiplayergame.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.multiplayergame.controller.World;
import com.multiplayergame.controls.Thumbs;
import com.multiplayergame.model.Player;
import com.multiplayergame.view.WorldRenderer;

public class MultiplayerGameLoop extends MultiplayerGameScreen {

	
	World world;
	WorldRenderer worldRenderer;
	Player[] players;
	
	
	public MultiplayerGameLoop(Game game) {
		super(game);
		// TODO Auto-generated constructor stub
		
		players = new Player[1];
		players[0] = new Player(400-16, 50);
		players[0].playerTexture = new Texture(Gdx.files.internal("PlayerPlaceholder.png"));
		world = new World(players, false, "LevelVariant1-1.png");
		worldRenderer = new WorldRenderer(world);		
	}

	@Override
	public void update(float delta) {
		// TODO Auto-generated method stub
		world.update(0);
		worldRenderer.update(0);
	}

	@Override
	public void draw(float delta) {
		// TODO Auto-generated method stub
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		worldRenderer.render(0);
	}

}
