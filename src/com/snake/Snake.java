package com.snake;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;



public class Snake {
	int x, y, maxX, maxY;
	int speed;
	SnakeDirection direction;
	
	Animation anim;
	
	public Snake(int x, int y, int maxX, int maxY) throws SlickException {
		this.x = x;
		this.y = y;
		this.maxX = maxX;
		this.maxY = maxY;
		
		this.direction = SnakeDirection.RIGHT;
		this.speed = 2;
		
		Image [] snakeImages = {new Image("img/ball.png"), new Image("img/ball.png")};
		int [] duration = {300, 300};
		this.anim = new Animation(snakeImages, duration);
	}
	
	public void draw() {
		this.anim.draw(this.x, this.y);
	}
	
	public void update() {
		int xdelta = 0;
		int ydelta = 0;
		
		switch (direction) {
		case RIGHT:
			xdelta = speed;
			break;
		case LEFT:
			xdelta = -speed;
			break;
		case DOWN: 
			ydelta = speed;
			break;
		case UP:
			ydelta = -speed;
			break;
		}
		
		moveDelta(xdelta, ydelta);
		draw();
	};
	
	public void moveDelta(int x, int y) {
		this.x += x;
		this.y += y;
		
		// wrap around if we go out of bounds
		if (this.x < 0) this.x = this.maxX;
		if (this.y < 0) this.y = this.maxY;
		if (this.y > this.maxY) this.y = 0;
		if (this.x > this.maxX) this.x = 0;
	}
	
	public void setDirection(SnakeDirection dir) {
		this.direction = dir;
	}
}
