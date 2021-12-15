package core;

import org.newdawn.slick.Graphics;

public class Goose {
    private float x;
    private float y;
    private float xSpeed;
    private float ySpeed;
    private float width;
    private float height;
    private boolean alive;

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
        this.x+=this.xSpeed;
        this.y-=this.ySpeed;
        if(this.y + this.height < 0 || (this.x + width < 0 || this.x > Main.getScreenWidth()))
        {
            this.xSpeed = (float)(Math.random()*5 - 5);
            this.ySpeed = (float)(Math.random()*12 + 4);
            this.y = Main.getScreenHeight() - this.height;
            this.x = (float)Math.random()*(Main.getScreenWidth()-width)+width;
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
