package core;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.sql.Array;
import java.util.ArrayList;

public class GameState extends BasicGameState
{	
	private int id;
	public static SpriteSheet gooseFly;
	public static SpriteSheet gooseDie;
	public static Image bg;
	public static Image grass;
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
	public static Input input;
	public int getID() 
	{
		return id;		
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException 
	{
		bg = new Image("res/imgs/background.png");
		gooseFly = new SpriteSheet(new Image("res/imgs/fly.png"), 100, 100);
		gooseDie = new SpriteSheet(new Image("res/imgs/die.png"), 100, 100);
		grass = new Image("res/imgs/grass.png");
		input = new Input(Main.getScreenHeight());
		score = 0;
		geeseAmt = 10;
		this.sbg = sbg;
		// This code happens when you enter a game state for the *first time.*
		time = 60*30;
		timeInSec = 30;
		plr = new Player();
		Geese = new ArrayList <Goose>();
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
				if(i.outOfBounds() && i.dead())
				{
					Geese.remove(i);
					break;
				}
				else
				{
					i.update();
				}
			}
		}
		else
		{

			for(int i = 0; i < 20; i++)
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
		g.setFont(new TrueTypeFont(Main.font, false));
		g.drawImage(bg, 0, 0);
		g.drawString(String.valueOf(timeInSec), 0,0);

		for(Goose i: Geese)
		{
			i.render(g);
		}
		g.drawImage(grass, 0, Main.getScreenHeight()-300);
		g.drawString(String.valueOf(plr.getAmmo()), 0, Main.getScreenHeight()*0.9f);
		plr.render(g);
		// This code renders shapes and images every frame.
	}
	
	public void enter(GameContainer gc, StateBasedGame sbg) throws SlickException 
	{
		// This code happens when you enter a gameState.
		gc.setMouseCursor(plr.crosshair, 21, 21);
		time = 60*30;
		timeInSec = 30;
		for(int i = 0; i < geeseAmt; i++)
		{
			Geese.add(new Goose((float)Math.random()*Main.getScreenWidth(),
					(float)Math.random()*Main.getScreenHeight() + (Main.getScreenHeight()*0.8f),
					(float)Math.random()*10 - 20,
					(float)Math.random()*10));
		}
		plr = new Player();
		canClick = true;
	}

	public void leave(GameContainer gc, StateBasedGame sbg) throws SlickException
	{
		for(int i = Geese.size() - 1; i > 0; i--)
		{
			Geese.remove(Geese.get(i));
		}
		gc.setMouseCursor("res/imgs/cursor.png", 10, 0);
		// This code happens when you leave a gameState. 
	}

	public void keyPressed(int key, char c)
	{
		if(key == Input.KEY_SPACE)
		{
			score = 0;
			sbg.enterState(Main.END_ID);
		}
		// This code happens every time the user presses a key
	}
	
	public void mousePressed(int button, int x, int y)
	{
		if(button == Input.MOUSE_LEFT_BUTTON)
		{
			if (canClick && plr.getAmmo() > 0) {

				plr.shoot(input);
				for (int i = Geese.size() - 1; i >= 0; i--) {
					if (Geese.get(i).isShot(x, y)) {
						score++;
						Geese.get(i).kill();
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
