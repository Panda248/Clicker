package core;

import org.newdawn.slick.Graphics;

public class Cat {
    private float x;
    private float y;
    private float size;
    private int anim;
    private int timer;
    public boolean done;
    public Cat(int score)
    {
        this.size = 100;
        this.x = Main.getScreenWidth()/2 - this.size/2;
        this.y = Main.getScreenHeight();
        this.anim = score;
        this.timer = 0;
        this.done = false;
    }

    public void update()
    {
        if(this.y > Main.getScreenHeight()/2 && timer == 0)
        {
            this.y-=4;
            if(this.y > Main.getScreenHeight())
            {
                done = true;
            }
        }
        else
        {
            if(timer > 120)
            {
                this.y+=4;
            }
            else
            {
                timer++;
            }
        }
    }
    public void render(Graphics g)
    {
        g.drawRect(this.x, this.y, this. size, this.size);
        if(timer > 0)
        {
            g.drawString(String.valueOf(GameState.score), Main.getScreenWidth()*0.49f, Main.getScreenHeight()/2f);
        }
    }

}
