import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class PurpleSteps3d {

    public static void mainDraw(Graphics graphics){
        // reproduce this:
        // [https://github.com/greenfox-academy/teaching-materials/blob/master/workshop/drawing/purple-steps-3d/r4.png]
        int step = 10;
        int size = 0;
        int x = 0;
        int y = 0;
        for(int i = 0; i < 7; i++) {
            size = (i + 1)* step;
            x = x + i * step;
            y = y + i * step;
            draw3dSquare(graphics,x,y,size);
        }

    }

    public static void draw3dSquare(Graphics g, int x, int y, int size) {
        g.setColor(new Color(153,50,204));
        g.fillRect(x,x,size,size);
        g.setColor(Color.BLACK);
        g.drawRect(x,x,size,size);
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
