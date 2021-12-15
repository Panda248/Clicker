package core;

import org.newdawn.slick.Graphics;

public class Cat {
    private float x;
    private float y;
    private float size;
    private int anim;
    private int timer;

    public Cat(int score)
    {
        this.size = 100;
        this.x = Main.getScreenWidth()/2 - this.size/2;
        this.y = Main.getScreenHeight();
        this.anim = score;
        this.timer = 0;
    }

    public void update()
    {
        if(this.y > Main.getScreenHeight()/2 && timer == 0)
        {
            this.y-=4;

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
    }

}
