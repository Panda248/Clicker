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
    private Button replay;
    public static SpriteSheet win;
    public static SpriteSheet lose;
    public int getID()
    {
        return id;
    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException
    {
        this.sbg = sbg;
        win = new SpriteSheet("res/imgs/win.png", 200, 200);
        lose = new SpriteSheet("res/imgs/lose.png", 200, 200);
        replay = new Button(Main.getScreenWidth()*0.4f,
                            Main.getScreenHeight()*0.3f,
                            Main.getScreenWidth()*0.2f,
                            Main.getScreenHeight()*0.1f,
                            "Play Again?", Color.green,
                            0.1f, 0.3f);
        // This code happens when you enter a game state for the *first time.*
    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
    {
        // This is updates your game's logic every frame.  NO DRAWING.
        cat.update();
        if(cat.done)
        {
            replay.update(TitleState.input);
        }
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
    {
        g.setFont(new TrueTypeFont(Main.font, false));
        g.drawImage(GameState.bg, 0, 0);
        cat.render(g);
        g.drawImage(GameState.grass, 0, Main.getScreenHeight()-300);
        if(cat.done)
        {
            replay.render(g);
        }
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
        if(cat.done)
        {
            if (replay.clicked()) {
                sbg.enterState(Main.TITLE_ID);
            }
        }
        // This code happens every time the user presses the mouse
    }

}

