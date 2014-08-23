package com.multiplayergame.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.multiplayergame.controller.World;
import com.multiplayergame.model.Player;
import com.multiplayergame.staticGameVariables.GameDimensions;

public class WorldRenderer {

	public World world;
	public SpriteBatch batch;
	public OrthographicCamera orthCam;

	public WorldRenderer(World world) {
		orthCam = new OrthographicCamera(GameDimensions.WIDTH,
				GameDimensions.HEIGHT);
		orthCam.position.set(GameDimensions.WIDTH / 2,
				GameDimensions.HEIGHT / 2, 0);
		orthCam.update();
		this.world = world;
		batch = new SpriteBatch(5460);
	}

	public void update(float deltaTime) {

		Vector3 orthAdd = new Vector3(world.players[0].direction, 0);
		if (orthAdd.x != 0) {
			Gdx.app.log("Orth",
					String.format("%f %f %f", orthAdd.x, orthAdd.y, orthAdd.z));
		}
		orthCam.position.y += orthAdd.y;
		if(orthCam.position.y < 300)
			orthCam.position.y = 300;
		if(orthCam.position.y > 900)
			orthCam.position.y = 900;
		
		orthCam.update();

		batch.setProjectionMatrix(orthCam.combined);
	}

	public void render(float deltaTime) {
		batch.begin();

		renderLevel();
		renderPlayers();
		renderEnemies();
		renderUI();

		batch.end();
	}

	public void renderUI() {
		batch.draw(world.leftThumb.thumbTex, world.leftThumb.thumbBottomLeft.x + orthCam.position.x - 400,
				world.leftThumb.thumbBottomLeft.y + orthCam.position.y - 300);
		batch.draw(world.rightThumb.thumbTex,
				world.rightThumb.thumbBottomLeft.x,
				world.rightThumb.thumbBottomLeft.y);
	}

	public void renderLevel() {
		batch.draw(world.levelTex, 0, 0);
	}

	public void renderPlayers() {
		for (int i = 0; i < world.players.length; i++) {
			Player currentPlayer = world.players[i];
			batch.draw(currentPlayer.playerTexture, currentPlayer.position.x,
					currentPlayer.position.y);
		}
	}

	public void renderEnemies() {

	}
}
