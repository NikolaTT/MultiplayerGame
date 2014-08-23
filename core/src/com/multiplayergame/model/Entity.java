package com.multiplayergame.model;

import com.badlogic.gdx.math.Vector2;

public class Entity {
	
	public Vector2 position;
	
	public Entity(){
		position = new Vector2(0, 0);
	}
	
	public Entity(Vector2 pos){
		position = pos;
	}
	
	public Entity(float x, float y){
		position = new Vector2();
		position.x = x;
		position.y = y;
	}
	
	void setPosition(Vector2 pos){
		position = pos;
	}
	
	void setPosition(float x, float y){
		position.x = x;
		position.y = y;
	}
	
}
