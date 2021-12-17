package core;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.TrueTypeFont;

public class Button {
    private float x;
    private float y;
    private float xDisplace;
    private float yDisplace;
    private float width;
    private float height;
    private String text;
    private Color color;
    private boolean over;

    public Button(float x, float y, float width, float height, String text, Color color, float xDisplace, float yDisplace)
    {
        this.x = x;
        this.y = y;
        this.xDisplace = xDisplace;
        this.yDisplace = yDisplace;
        this.width = width;
        this.height = height;
        this.text = text;
        this.color = color;
    }
    public void update(Input input)
    {
        over = (input.getAbsoluteMouseX() > this.x && input.getAbsoluteMouseX() < this.x + this.width)&&
                (input.getAbsoluteMouseY() > this.y && input.getAbsoluteMouseY() < this.y + this.height);
    }
    public boolean clicked()
    {
        return over;
    }
    public void render(Graphics g)
    {

        if(over)
        {
            g.setColor(color.darker());
        }
        else
        {
            g.setColor(color);
        }
        g.fillRect(this.x, this.y, this.width, this.height);
        g.drawRect(this.x, this.y, this.width, this.height);
        g.setColor(Color.white);
        g.drawString(this.text, this.x + this.width*this.xDisplace, this.y + this.height*this.yDisplace);
    }


}
