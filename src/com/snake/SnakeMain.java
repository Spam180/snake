package com.snake;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.lwjgl.opengl.Display;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class SnakeMain extends BasicGame
{	
	private Snake snake;
	
	public SnakeMain(String gamename)
	{
		super(gamename);
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		snake = new Snake(100, 100, gc.getWidth(), gc.getHeight());
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
        Input input = container.getInput();
        if (input.isKeyDown(Input.KEY_UP))
        {
        	snake.setDirection(SnakeDirection.UP);
        }
        else if (input.isKeyDown(Input.KEY_DOWN))
        {
        	snake.setDirection(SnakeDirection.DOWN);
        }
        else if (input.isKeyDown(Input.KEY_LEFT))
        {
        	snake.setDirection(SnakeDirection.LEFT);
        }
        else if (input.isKeyDown(Input.KEY_RIGHT))
        {
        	snake.setDirection(SnakeDirection.RIGHT);
        }       

        // make sure we run at 60 frame per second
        Display.sync(60);

	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException
	{
		snake.update();
	}

	public static void main(String[] args)
	{
		try
		{
			AppGameContainer appgc;
			appgc = new AppGameContainer(new SnakeMain("Snake 0.1"));
			appgc.setDisplayMode(640, 480, false);
			appgc.start();
		}
		catch (SlickException ex)
		{
			Logger.getLogger(SnakeMain.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}