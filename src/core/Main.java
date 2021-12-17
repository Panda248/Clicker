package core;

import org.newdawn.slick.AppGameContainer;

import java.awt.*;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main extends StateBasedGame 
{
	public final static int FRAMES_PER_SECOND = 60;
	private static AppGameContainer appgc;
	public static boolean debug;
	public static Font font;
	public static Image background;

	public static final int TITLE_ID = 0;
	public static final int GAME_ID  = 1;
	public static final int END_ID = 2;
	public static final int WAIT_ID = 3;
    
    private BasicGameState title;
	private BasicGameState game;
	private BasicGameState end;
	private BasicGameState wait;
    
	public Main(String name) 
	{
		super(name);
		title = new TitleState(TITLE_ID);
		game = new GameState(GAME_ID);
		end = new EndState(END_ID);
		wait = new WaitState(WAIT_ID);

	}

	public static int getScreenWidth()
	{
		return appgc.getScreenWidth();
	}
	
	public static int getScreenHeight()
	{
		return appgc.getScreenHeight();
	}
	

	public void initStatesList(GameContainer gc) throws SlickException 
	{
		addState(title);
		addState(game);
		addState(end);
		addState(wait);

	}

	public static void main(String[] args) throws IOException, FontFormatException {
		font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("res/fonts/PressStart.ttf")).deriveFont(Font.PLAIN, 30);
		debug = false;
		try 
		{
			appgc = new AppGameContainer(new Main("Goose Chase"));
			System.setProperty("org.lwjgl.opengl.Window.undecorated", "true");
		
			appgc.setDisplayMode(appgc.getScreenWidth(), appgc.getScreenHeight(), false);
			appgc.setTargetFrameRate(FRAMES_PER_SECOND);
			appgc.start();
			appgc.setVSync(true);

		} 
		catch (SlickException e) 
		{
			e.printStackTrace();
		}

	}
}