package core;

        import org.newdawn.slick.*;
        import org.newdawn.slick.state.BasicGameState;
        import org.newdawn.slick.state.StateBasedGame;

public class EndState extends BasicGameState
{
    private int id;
    private StateBasedGame sbg;
    public EndState(int id)
    {
        this.id = id;
    }
    private Cat cat;
    public int getID()
    {
        return id;
    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException
    {
        this.sbg = sbg;
        // This code happens when you enter a game state for the *first time.*
    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
    {
        // This is updates your game's logic every frame.  NO DRAWING.
        cat.update();
        if(cat.done)
        {
            sbg.enterState(Main.TITLE_ID);
        }
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
    {
        g.setFont(new TrueTypeFont(Main.font, false));
        g.setBackground(Color.black);
        cat.render(g);
        // This code renders shapes and images every frame.
    }

    public void enter(GameContainer gc, StateBasedGame sbg) throws SlickException
    {
        // This code happens when you enter a gameState.
        this.cat = new Cat(GameState.score);
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

