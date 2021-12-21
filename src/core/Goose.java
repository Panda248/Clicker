package core;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SpriteSheet;

public class Goose {
    private float x;
    private float y;
    private float xSpeed;
    private float ySpeed;
    private float width;
    private float height;
    private boolean alive;
    private SpriteSheet fly;
    private SpriteSheet die;
    private Image frame;
    private int frames;
    private int time;

    public void kill()
    {
        this.alive = false;
    }
    public boolean dead()
    {
        return !alive;
    }
    public boolean outOfBounds()
    {
        return (this.x + this.width< 0 || this.x > Main.getScreenWidth()) || (this.y + height < 0 || this.y > Main.getScreenHeight());
    }


    public Goose(float x, float y, float xSpeed, float ySpeed){
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.width = 100;
        this.height = 100;
        this.alive = true;
        this.fly = GameState.gooseFly;
        this.die = GameState.gooseDie;
        this.frame = fly.getSprite((int)(Math.random()*12),0);
        this.frames = 11;
        this.time = 0;
    }

    public void update()
    {
        time++;
        if(time > frames)
        {
            time = 0;
        }
        if(!alive)
        {
            this.y += 10;
            this.frame = die.getSprite(time, 0);
        }
        else
        {

            this.frame = fly.getSprite(time,0);

            this.x+=this.xSpeed;
            this.y-=this.ySpeed;
            if(outOfBounds())
            {
                this.xSpeed = (float)(Math.random()*5 - 5);
                this.ySpeed = (float)(Math.random()*12 + 4);
                this.y = Main.getScreenHeight() - this.height;
                this.x = (float)Math.random()*(Main.getScreenWidth()-width)+width;
            }
        }


    }
    public boolean isShot(int x, int y)
    {
        return((x > this.x && x < this.x + this.width)&&(y > this.y && y < this.y + this.height));
    }

    public void render(Graphics g)
    {

        g.drawImage(frame, this.x, this.y);
    }

}
