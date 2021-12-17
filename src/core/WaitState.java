package core;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class WaitState extends BasicGameState
{
    private int id;
    private StateBasedGame sbg;
    private int timer;
    private int timerInSec;
    private Input input;
    public WaitState(int id)
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
        timer = 60*3;
        timerInSec = 3;
        // This code happens when you enter a game state for the *first time.*
    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
    {
        timer--;
        if(timer < 0)
        {
            sbg.enterState(Main.GAME_ID);
        }
        // This is updates your game's logic every frame.  NO DRAWING.
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
    {
        g.setFont(new TrueTypeFont(Main.font, false));
        if(timer%60 == 0 && timer != 0)
        {
            timerInSec = timer/60;
        }
        g.drawString(String.valueOf(timerInSec), Main.getScreenWidth()/2, Main.getScreenHeight()/2);
        // This code renders shapes and images every frame.
    }

    public void enter(GameContainer gc, StateBasedGame sbg) throws SlickException
    {
        timer = 60*3;
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
