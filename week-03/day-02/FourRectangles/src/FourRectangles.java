import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class FourRectangles {
    public static void mainDraw(Graphics graphics){
        // draw four different size and color rectangles.

        drawaRect(graphics,10,30,50,70,Color.YELLOW);
        drawaRect(graphics,100,30,60,90,Color.GREEN);
        drawaRect(graphics,50,150,250,120,Color.BLUE);
        drawaRect(graphics,90,40,50,90,Color.RED);


    }

    public static void drawaRect(Graphics g, int x1, int y1, int x2, int y2, Color z) {
        g.setColor(z);
        g.fillRect(x1,y1,x2,y2);
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

