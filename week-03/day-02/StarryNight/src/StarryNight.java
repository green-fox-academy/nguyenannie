import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

import java.util.*;

public class StarryNight {

    public static void mainDraw(Graphics graphics){
        // draw the night sky:
        // - The background should be black
        // - The stars can be small squares
        // - The stars should have random positions on the canvas
        // - The stars should have random color (some shade of grey)
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0,0,WIDTH,HEIGHT);

        int r = 0;
        /*
        int g = 0;
        int b = 0;
        */
        for(int i = 0; i < 30; i ++){

            r = (int)(Math.random()*255);
            /*
            g = (int)(Math.random()*255);
            b = (int)(Math.random()*255);
            */

            drawaSquare(graphics,new Color(r ,r, r));
        }
    }

    public static void drawaSquare(Graphics g, Color z) {
        g.setColor(z);
        g.fillRect((int) (Math.random() * WIDTH), (int)(Math.random() * WIDTH), 10,10);
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