package core;

import org.newdawn.slick.*;

public class Player {
    private int ammo;
    public Image crosshair;
    private Image gunshot;
    private float x;
    private float y;
    private int timer;
    public Player() throws SlickException
    {
        timer = 100;
        gunshot = new Image("res/imgs/gunshot.png");
        crosshair = new Image("res/imgs/crosshair.png");
        ammo = 100;
    }
    public int getAmmo()
    {
        return ammo;
    }
    public void shoot(Input input)
    {
        timer = 0;
        ammo--;
        x = input.getMouseX();
        y = input.getMouseY();
    }
    public void render(Graphics g)
    {
        timer++;
        if(timer < 10)
        {
            g.drawImage(gunshot, this.x-20, this.y-20);
        }
    }
}
