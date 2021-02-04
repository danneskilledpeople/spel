package spel;

import javax.swing.JPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Graphics;


public class BlockBreakerPanel extends JPanel implements KeyListener {

    Color blue = new Color(0, 0, 255);
    Color green = new Color(0, 255, 0);
    Color red = new Color(255, 0, 0);

    Block paddle = new Block(175, 480, 150, 20, green);
    Block ball = new Block(273, 435, 25, 25, blue);

    ArrayList<Block> blocks = new ArrayList<Block>();



    BlockBreakerPanel (){
        addKeyListener(this);
        setFocusable(true);
    }
    
    public void paintComponent(Graphics g){
        paddle.draw(g, this);
    }

    
    public void update(){

    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode()==KeyEvent.VK_ENTER){
            new Thread(()->{
                while (true){
                    update();
                    try {
                        Thread.sleep(10);
                    } catch(InterruptedException err){
                        err.printStackTrace();
                    }
                }
            }).start();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

    }
}
