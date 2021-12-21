package core;

import org.newdawn.slick.*;
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
        gc.setMouseCursor("res/imgs/cursor.png", 10, 0);
        this.sbg = sbg;
        start = new Button(Main.getScreenWidth()*0.4f,
                            Main.getScreenHeight()/2f,
                            Main.getScreenWidth()/5f,
                            Main.getScreenHeight()/10f,
                            "Start", new Color(0,225, 0),
                            0.3f,
                            0.4f);
        exit = new Button(Main.getScreenWidth()*0.4f,
                        Main.getScreenHeight()*.7f,
                        Main.getScreenWidth()/5f,
                        Main.getScreenHeight()/10f,
                        "Exit", new Color(225,0, 0),
                        0.33f,
                        0.4f);
        input = new Input(Main.getScreenHeight());
        // This code happens when you enter a game state for the *first time.*
        gc.setShowFPS(false);
    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
    {
        start.update(input);
        exit.update(input);
        // This is updates your game's logic every frame.  NO DRAWING.
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
    {
        g.setFont(new TrueTypeFont(Main.font, false));
        g.drawString("Goose Chase", Main.getScreenWidth()*0.42f, Main.getScreenHeight()*0.4f);
        g.setBackground(Color.blue);
        start.render(g);
        exit.render(g);

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
        if(start.clicked())
        {
            sbg.enterState(Main.WAIT_ID);
        }
        else if(exit.clicked())
        {
            System.exit(0);
        }
        // This code happens every time the user presses the mouse
    }




}
