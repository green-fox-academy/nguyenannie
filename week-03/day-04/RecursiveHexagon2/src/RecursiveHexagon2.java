import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class RecursiveHexagon2 {

    public static void mainDraw(Graphics g) {
        recursiveHexagon(g,WIDTH/2,WIDTH/2,300,5);

    }
    public static void recursiveHexagon(Graphics g, int x, int y, int size, int n) {
        if(n == 0) {
            return;
        }
        drawHexagon(g,x,y,size);
        int height = (int)(Math.sqrt(3.0) * size / 2);

        int x0 = x - size/3;
        int y0 = y -2 *height/3;

        int x1 = x - 2 * size/3;
        int y1 = y;

        int x2 = x - size/3;
        int y2 = y + 2 * height/3;

        int x3 = x + size/3;
        int y3 = y + 2 * height/3;

        int x4= x + 2 * size/3;
        int y4 = y;

        int x5 = x + size/3;
        int y5 = y - 2 * height/3;

        int[] xpoints = {x0,x1,x2,x3,x4,x5};
        int[] ypoints = {y0,y1,y2,y3,y4,y5};

        for(int i = 0; i < xpoints.length; i++) {
            recursiveHexagon(g,xpoints[i],ypoints[i],size/3, n - 1);
        }

        /*

        recursiveHexagon(g,x0,y0,size/3, n - 1);
        recursiveHexagon(g,x1,y1,size/3, n - 1);
        recursiveHexagon(g,x2,y2,size/3, n - 1);
        recursiveHexagon(g,x3,y3,size/3, n - 1);
        recursiveHexagon(g,x4,y4,size/3, n - 1);
        recursiveHexagon(g,x5,y5,size/3, n - 1);
        */
    }

    public static void drawHexagon(Graphics g, int x, int y, int size) {
        int height = (int)(Math.sqrt(3.0) * size / 2);
        int x0 = x - size/2;
        int y0 = y - height;

        int x1 = x - size;
        int y1 = y;

        int x2 = x - size/2;
        int y2 = y + height;

        int x3 = x + size/2;
        int y3 = y + height;

        int x4 = x + size;
        int y4 = y;

        int x5 = x  + size/2;
        int y5 = y - height;

        g.drawPolygon(new int[]{x0,x1,x2,x3,x4,x5}, new int[]{y0,y1,y2,y3,y4,y5},6);
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

