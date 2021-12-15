package core;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.sql.Array;
import java.util.ArrayList;

public class GameState extends BasicGameState
{	
	private int id;
	private StateBasedGame sbg;
	public GameState(int id)
	{
		this.id = id;
	}
	public static int score;
	private int time;
	private int timeInSec;
	private Player plr;
	private ArrayList  <Goose> Geese;
	private int geeseAmt;
	private boolean canClick;
	public int getID() 
	{
		return id;		
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException 
	{
		score = 0;
		geeseAmt = 10;
		this.sbg = sbg;
		// This code happens when you enter a game state for the *first time.*
		time = 60*30;
		timeInSec = 30;
		plr = new Player();
		Geese = new ArrayList<Goose>();
		for(int i = 0; i < geeseAmt; i++)
		{
			Geese.add(new Goose((float)Math.random()*Main.getScreenWidth(),
								 Main.getScreenHeight() - 10,
								(float)(Math.random()*5 - 5),
								(float)(Math.random()*12+4),
								(float)Math.random()*2 + 1));
		}
		canClick = true;
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
	{	
		// This is updates your game's logic every frame.  NO DRAWING.
		if(Geese.size()>0)
		{
			time--;
			if(time%60 == 0)
			{
				timeInSec = time/60;
			}
			for(Goose i: Geese)
			{
				i.update();
			}
		}
		else
		{

			for(int i = 0; i < 10; i++)
			{
				time--;
				if(time%60 == 0)
				{
					timeInSec = time/60;
					score++;
				}
			}

		}
		if(time < 0)
		{
			sbg.enterState(Main.END_ID);
		}
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException 
	{
		g.drawString(String.valueOf(timeInSec), 0,0);
		g.drawString(String.valueOf(plr.getAmmo()), 0, Main.getScreenHeight()*0.9f);
		for(Goose i: Geese)
		{
			i.render(g);
		}
		// This code renders shapes and images every frame.
	}
	
	public void enter(GameContainer gc, StateBasedGame sbg) throws SlickException 
	{
		// This code happens when you enter a gameState.
		time = 60*30;
		timeInSec = 30;
		for(int i = 0; i < geeseAmt; i++)
		{
			Geese.add(new Goose((float)Math.random()*Main.getScreenWidth(),
					(float)Math.random()*Main.getScreenHeight() + (Main.getScreenHeight()*0.8f),
					(float)Math.random()*10 - 20,
					(float)Math.random()*10,
					(float)Math.random()*2 + 1));
		}
		plr = new Player();
		canClick = true;
	}

	public void leave(GameContainer gc, StateBasedGame sbg) 
	{
		for(int i = Geese.size() - 1; i > 0; i--)
		{
			Geese.remove(Geese.get(i));
		}
		// This code happens when you leave a gameState. 
	}

	public void keyPressed(int key, char c)
	{
		// This code happens every time the user presses a key
	}
	
	public void mousePressed(int button, int x, int y)
	{
		if(button == Input.MOUSE_LEFT_BUTTON)
		{
			if (canClick && plr.getAmmo() > 0) {

				plr.shoot();
				for (int i = Geese.size() - 1; i >= 0; i--) {
					if (Geese.get(i).isShot(x, y)) {
						score++;
						Geese.remove(i);
						break;
					}
				}
			}
		}

		// This code happens every time the user presses the mouse
	}
	public void mouseReleased(int button, int x, int y)
	{
		if(!canClick)
		{
			canClick = true;
		}
	}
	
	


}
