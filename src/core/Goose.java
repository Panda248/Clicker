package core;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class Goose {
    private float x;
    private float y;
    private float xSpeed;
    private float ySpeed;
    private float width;
    private float height;
    private boolean alive;
    private Image frame;
    private int frames;
    private int time;
    private int timePerFrame;

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
        return (this.x < 0 || this.x > Main.getScreenWidth()) || (this.y < 0 || this.y > Main.getScreenHeight());
    }


    public Goose(float x, float y, float xSpeed, float ySpeed, float size){
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.width = 100*size;
        this.height = 80*size;
        this.alive = true;
    }

    public void update()
    {
        if(!alive)
        {
            this.y += 10;
        }
        else
        {
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
        g.drawRect(this.x, this.y, this.width, this.height);
    }

}
