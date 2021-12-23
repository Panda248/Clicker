package core;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SpriteSheet;

public class Cat {
    private float x;
    private float y;
    private float size;
    private int anim;
    private SpriteSheet spriteSheet;
    private Image sprite;
    private int frame;
    private int timer;
    public boolean done;
    public Cat(int score)
    {
        this.size = 200;
        this.x = Main.getScreenWidth()/2f - this.size/2;
        this.y = Main.getScreenHeight();
        if(score > 10)
        {
            this.spriteSheet = EndState.win;
        }
        else
        {
            this.spriteSheet = EndState.lose;
        }
        this.timer = 0;
        this.frame = 0;
        this.done = false;
    }

    public void update()
    {

        if(this.y + size > Main.getScreenHeight() - 255  && timer == 0)
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
                frame++;
                if(frame > 17)
                {
                    frame = 0;
                }
            }
        }
        if(this.y > Main.getScreenHeight())
        {
            done = true;
        }
        this.sprite = spriteSheet.getSprite(frame, 0);
    }
    public void render(Graphics g)
    {
        g.drawImage(this.sprite, this.x, this.y);
        if(timer > 0)
        {
            g.drawString(String.valueOf(GameState.score), Main.getScreenWidth()*0.48f, Main.getScreenHeight()/2f);
        }
    }

}
