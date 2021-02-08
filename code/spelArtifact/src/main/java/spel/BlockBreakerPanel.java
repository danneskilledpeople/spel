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

    Block paddle;
    Block ball;

    ArrayList<Block> blocks;

    BlockBreakerPanel() {
        reset();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        paddle.draw(g, this);
        ball.draw(g, this);
        blocks.forEach(Block->{Block.draw(g, this);});

    }

    public void reset() {
        ball = new Block(273, 435, 25, 25, blue);
        paddle = new Block(175, 480, 150, 20, green);
        blocks = new ArrayList<Block>();

        for(int i=0; i < 8; i++){
            Block b = new Block(90*i, 0, 70, 20, red);
            blocks.add(b);
        }
        addKeyListener(this);
        setFocusable(true);
        
    }

    public void update() {
         ball.x+=ball.moveX;
         if (getWidth()<= ball.x + ball.width || ball.x<0){
             ball.moveX *= -1;
         }
        if (ball.y<0 || ball.intersects(paddle)){
            ball.moveY *= -1;
        }
        ball.y+=ball.moveY;
        if(getHeight()<ball.y){
            //Spealre förlorar
        }
        blocks.forEach(Block ->{
           if(ball.intersects(Block) && !Block.destroyed){
               Block.destroyed = true;
               ball.moveY *=-1;

           }
        });

        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            new Thread(() -> {
                while (true) {
                    update();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException err) {
                        err.printStackTrace();
                    }
                }
            }).start();
        }

        if (e.getKeyCode() == KeyEvent.VK_RIGHT && paddle.width + paddle.x <= getWidth()) {
            paddle.x += 15;

        }

        if (e.getKeyCode() == KeyEvent.VK_LEFT && paddle.x > 0) {
            paddle.x -= 15;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

    }
}
