package spel;

import javax.swing.JFrame;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        System.out.println("!");

        JFrame frame = new JFrame("Spel");

        frame.setSize(800, 600);

        frame.setVisible(true);

        frame.setResizable(false);
    }
}
