package core;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class TitleState extends BasicGameState
{
    private int id;
    private StateBasedGame sbg;
    private Button about;
    private Button start;
    private Button exit;
    private Input input;
    public TitleState(int id)
    {
        this.id = id;
    }

    public int getID()
    {
        return id;
    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException
    {
        this.sbg = sbg;
        about = new Button(Main.getScreenWidth()/3, Main.getScreenHeight()/2, Main.getScreenWidth()/3, Main.getScreenHeight()/10, "About", Color.black);
        input = new Input(Main.getScreenHeight());
        // This code happens when you enter a game state for the *first time.*
        //gc.setShowFPS(Main.debug);
    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
    {
        about.update(input);
        // This is updates your game's logic every frame.  NO DRAWING.
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
    {
        about.render(g);
        // This code renders shapes and images every frame.
    }

    public void enter(GameContainer gc, StateBasedGame sbg) throws SlickException
    {
        // This code happens when you enter a gameState.
    }

    public void leave(GameContainer gc, StateBasedGame sbg)
    {
        // This code happens when you leave a gameState.
    }

    public void keyPressed(int key, char c)
    {
        // This code happens every time the user presses a key
    }

    public void mousePressed(int button, int x, int y)
    {
        // This code happens every time the user presses the mouse
    }




}
