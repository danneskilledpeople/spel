package spel;

import javax.swing.JPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class BlockBreakerPanel extends JPanel implements KeyListener {
    BlockBreakerPanel (){
        addKeyListener(this);
        setFocusable(true);
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
