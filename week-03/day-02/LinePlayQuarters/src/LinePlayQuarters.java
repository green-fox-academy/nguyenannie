import org.omg.CORBA.CODESET_INCOMPATIBLE;

import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class LinePlayQuarters {

    public static void mainDraw(Graphics graphics){
        // divide the canvas into 4 parts
        // and repeat this pattern in each quarter:
        // [https://github.com/greenfox-academy/teaching-materials/blob/master/workshop/drawing/line-play/r1.png]
        int space = 20;
        for (int i = 0; i <= WIDTH/space/2; i++) {
            graphics.setColor(Color.GREEN);
            graphics.drawLine(i * space,0,0,WIDTH/2 - i* space );
            graphics.setColor(Color.PINK);
            graphics.drawLine(0, WIDTH/2 + i* space,i * space,WIDTH );
            graphics.setColor(Color.CYAN);
            graphics.drawLine(WIDTH/2 + i * space,0,WIDTH,i* space );
            graphics.setColor(Color.BLUE);
            graphics.drawLine(WIDTH/2 + i * space,WIDTH,WIDTH, WIDTH - i *space);
        }


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

    class Point {
        public int x, y;
        Point(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }
}

