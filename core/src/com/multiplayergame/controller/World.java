package com.multiplayergame.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.multiplayergame.controls.Thumbs;
import com.multiplayergame.model.Player;

public class World {

	public Player[] players;
	public boolean isSinglePlayerLevel;
	public Texture levelTex;
	public Thumbs leftThumb = new Thumbs(100, 100, new Texture(
			Gdx.files.internal("shadedDark01.png")));
	public Thumbs rightThumb = new Thumbs(700, 100, new Texture(
			Gdx.files.internal("shadedDark01.png")));
	InputMultiplexer inputMulti;

	public World(Player[] players, boolean isSinglePlayerLevel, String levelFile) {
		this.players = players;
		this.isSinglePlayerLevel = isSinglePlayerLevel;
		levelTex = new Texture(Gdx.files.internal(levelFile));

		inputMulti = new InputMultiplexer();
		inputMulti.addProcessor(leftThumb);
		inputMulti.addProcessor(rightThumb);

		Gdx.input.setInputProcessor(inputMulti);
	}

	public void update(float deltaTime) {

		Vector2 leftThumbCenter = new Vector2(leftThumb.thumbBottomLeft);
		leftThumbCenter.add(leftThumb.thumbTex.getWidth() / 2.0f,
				leftThumb.thumbTex.getHeight() / 2.0f);
		players[0].direction = leftThumbCenter.sub(leftThumb.thumbBounds.x,
				leftThumb.thumbBounds.y).nor();
		if (players[0].direction.x != 0) {
			Gdx.app.log("Play", String.format("%f %f", players[0].direction.x,
					players[0].direction.y));
		}

		players[0].position.add(players[0].direction.scl(players[0].speed));
	}

}
