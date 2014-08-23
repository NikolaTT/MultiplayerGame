package com.multiplayergame.controls;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Logger;
import com.multiplayergame.staticGameVariables.GameDimensions;

public class Thumbs implements InputProcessor {

	public Circle thumbBounds;
	public Vector2 thumbBottomLeft;
	public Texture thumbTex;
	public boolean touched = false;

	public Thumbs(float x, float y, Texture tex) {
		thumbBounds = new Circle(x, y, GameDimensions.thumbRadius);
		thumbBottomLeft = new Vector2(x - tex.getWidth() / 2.0f, y
				- tex.getHeight() / 2.0f);
		thumbTex = tex;
	}

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub

		screenY = Gdx.app.getGraphics().getHeight() - screenY;

		Gdx.app.log("down", String.format("%d %d %f %f", screenX, screenY,
				thumbBounds.x, thumbBounds.y));
		Gdx.app.log("dst", String.format("%f",
				Vector2.dst(screenX, screenY, thumbBounds.x, thumbBounds.y)));
		Gdx.app.log(
				"tex",
				String.format("%d %d", thumbTex.getWidth(),
						thumbTex.getHeight()));

		if (thumbBounds.contains(screenX, screenY)) {
			thumbBottomLeft.x = screenX - thumbTex.getWidth() / 2.0f;
			thumbBottomLeft.y = screenY - thumbTex.getHeight() / 2.0f;
			touched = true;
			return true;
		}

		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub

		if (touched) {
			thumbBottomLeft.x = thumbBounds.x - thumbTex.getWidth() / 2.0f;
			thumbBottomLeft.y = thumbBounds.y - thumbTex.getHeight() / 2.0f;
			touched = false;

			return true;
		}
		
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub

		if (touched) {

			screenY = Gdx.app.getGraphics().getHeight() - screenY;
			float dstToThumbCenter = Vector2.dst(screenX, screenY,
					thumbBounds.x, thumbBounds.y);

			if (dstToThumbCenter > GameDimensions.thumbRadius) {
				float x = GameDimensions.thumbRadius
						* (screenX - thumbBounds.x) / dstToThumbCenter;
				float y = GameDimensions.thumbRadius
						* (screenY - thumbBounds.y) / dstToThumbCenter;

				thumbBottomLeft.x = x + thumbBounds.x - thumbTex.getWidth()
						/ 2.0f;
				thumbBottomLeft.y = y + thumbBounds.y - thumbTex.getHeight()
						/ 2.0f;
			} else {
				thumbBottomLeft.x = screenX - thumbTex.getWidth() / 2.0f;
				thumbBottomLeft.y = screenY - thumbTex.getHeight() / 2.0f;
			}

			return true;
		}

		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
