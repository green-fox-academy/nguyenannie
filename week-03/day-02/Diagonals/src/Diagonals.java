import javax.swing.*;
import java.awt.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Diagonals {

    public static void mainDraw(Graphics graphics){
        // draw the canvas' diagonals in green.
        graphics.setColor(Color.GREEN);
        graphics.drawLine(0,0,WIDTH,HEIGHT -23);

        graphics.setColor(Color.GREEN);
        graphics.drawLine(WIDTH,0,0, HEIGHT - 23);

        //the height given is not the right height of the drawable area but the height of the window which include the top bar!!
    }

    //    Don't touch the code below
    static int WIDTH = 320;
    static int HEIGHT = 343;

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Drawing");
        jFrame.setSize(new Dimension(WIDTH, HEIGHT));
        jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jFrame.add(new ImagePanel());
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }
    static class ImagePanel extends JPanel{
        @Override
        protected void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);
            mainDraw(graphics);

        }
    }
}
