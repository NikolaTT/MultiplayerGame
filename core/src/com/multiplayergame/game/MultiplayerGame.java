package com.multiplayergame.game;

import com.badlogic.gdx.Game;
import com.multiplayergame.screens.MainMenuScreen;

public class MultiplayerGame extends Game {
	
	@Override
	public void create () {
		setScreen(new MainMenuScreen(this));
	}

}
