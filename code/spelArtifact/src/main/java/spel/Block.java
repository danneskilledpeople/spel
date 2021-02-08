package spel;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Component;

public class Block extends Rectangle {
int moveX;
int moveY;
Color color;
boolean destroyed;

    Block (int x, int y, int w, int h, Color c){
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
        this.color = c;
        this.moveX = 3;
        this.moveY = 3;
    }

    public void draw (Graphics g, Component c){
        if (!destroyed){
            g.setColor(color);
            g.fillRect(x, y, width, height);
        }
    }
}
