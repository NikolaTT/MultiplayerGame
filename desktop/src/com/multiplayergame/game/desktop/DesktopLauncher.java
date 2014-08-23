package com.multiplayergame.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.multiplayergame.game.MultiplayerGame;
import com.multiplayergame.staticGameVariables.GameDimensions;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = GameDimensions.WIDTH;
		config.height = GameDimensions.HEIGHT;
		new LwjglApplication(new MultiplayerGame(), config);
	}
}
