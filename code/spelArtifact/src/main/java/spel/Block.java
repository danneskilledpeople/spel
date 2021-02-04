package spel;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Component;

public class Block extends Rectangle {

Color color;
boolean destroyed;

    Block (int x, int y, int w, int h, Color c){
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
        this.color = c;
    }

    public void draw (Graphics g, Component c){
        if (!destroyed){
            g.setColor(color);
        }
    }
}
