import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class RainbowBoxFunction {
    public static void mainDraw(Graphics graphics){
        // create a square drawing function that takes 2 parameters:
        // the square size, and the fill color,
        // and draws a square of that size and color to the center of the canvas.
        // create a loop that fills the canvas with rainbow colored squares.
        int x = WIDTH;
        int r = 0;
        int g = 0;
        int b = 0;
        while(x > 0){

            r = (int)(Math.random()*255);
            g = (int)(Math.random()*255);
            b = (int)(Math.random()*255);

            drawaSquare(graphics,x,new Color(r ,g, b));
            x = x - 10;
        }


    }
    public static void drawaSquare(Graphics g, int x, Color z) {
        g.setColor(z);
        g.fillRect(WIDTH/2 - x/2, (HEIGHT - 23)/2 - x/2, x, x);
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

