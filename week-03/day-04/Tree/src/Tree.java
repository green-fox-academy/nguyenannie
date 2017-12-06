import javax.swing.*;

import java.awt.*;
import java.util.concurrent.TimeUnit;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Tree {
    static Turtle t;

    public static void mainDraw(Graphics g) {
        t = new Turtle(g,300,600);
        g.setColor(new Color(0,49,62));
        g.fillRect(0,0,WIDTH,WIDTH);
        g.setColor(new Color(255,215,47));
        drawTree(9,40);
    }
    public static void drawTree(int n,double size) {
        double a = 0.90;
        double p = 0.11;
        if(n == 0) {
            return;
        } else {
           t.moveForward(size);
           t.turn(- Math.PI * p);
           drawTree(n -1,size * a);
           t.turn(Math.PI * p);
           drawTree(n-1,size * a * 1.1);
           t.turn( Math.PI * p);
           drawTree(n - 1, size * a);
           t.turn(-Math.PI * p);
           t.penUp();
           t.moveForward(-size);
           t.penDown();
        }
    }

    static int WIDTH = 600;
    static int HEIGHT = 623;

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
