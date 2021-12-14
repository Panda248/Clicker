package core;

import org.newdawn.slick.Graphics;

public class Player {
    private int ammo;

    public Player()
    {
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
