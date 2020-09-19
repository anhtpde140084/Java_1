/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computer_master_bullets;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author tranp
 */
public class Bullet
{

    private int x;
    private int y;
    private int speed;

    public Bullet(int x, int y)
    {
        this.x = x;
        this.y = y;
        speed = 30;
    }

    public void tick()
    {
        y = y - speed;
    }

    public int getY()
    {
        return y;
    }

    public int getX()
    {
        return x;
    }

    public void render(Graphics g)
    {
        g.setColor(Color.RED);
        g.fillOval(x, y, 10, 10);
        g.setColor(Color.BLACK);
    }
}
