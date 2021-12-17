package core;

import org.newdawn.slick.Game;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Player {
    private int ammo;
    public Image crosshair;
    public Player() throws SlickException
    {
        crosshair = new Image("res/imgs/crosshair.png");
        ammo = 100;
    }
    public int getAmmo()
    {
        return ammo;
    }
    public void shoot()
    {
        ammo--;
    }
    public void render(Graphics g)
    {
        g.drawString(String.valueOf(ammo), Main.getScreenWidth()-100, 50);
    }
}
