package com.multiplayergame.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Player extends Entity{
	
	public Vector2 direction;
	public Vector2 acceleration;
	public float speed;
	
	public Texture playerTexture;
	
	public Player(){
		super();
		direction = new Vector2(0,0);
		speed = 3.0f;
	}
	
	public Player(Vector2 pos){
		super(pos);
		direction = new Vector2(0,0);
		speed = 3.0f;
	}
	
	public Player(float x, float y){
		super(x, y);
		direction = new Vector2(0,0);
		speed = 3.0f;
	}
}
