import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class RecursiveHexagon {

    public static void mainDraw(Graphics g) {
        recursiveHexagon(g,WIDTH/2, WIDTH/2,200,5);
    }

    public static void recursiveHexagon(Graphics g, double x, double y, int size, int n) {
        if(n == 0) {
            return;
        }

        drawHexagon(g,(int)x,(int)y,size);

        double x0 = x - size/4 ;
        double y0 = y + (Math.sqrt(3.0)*size/4);

        double x1 = x - size/4;
        double y1 = y - (Math.sqrt(3.0)*size/4);

        double x2 = x + size/2;
        double y2 = y;

        g.setColor(Color.GREEN);
        recursiveHexagon(g,x0,y0,size/2,n - 1);
        g.setColor(Color.BLUE);
        recursiveHexagon(g, x1,y1,size/2,n - 1);
        g.setColor(Color.RED);
        recursiveHexagon(g,x2,y2,size/2,n-1);


    }


    public static void drawHexagon(Graphics g, double x,double y, int size) {
        int[] xCoordinates = {(int)(x + size / 2), (int)(x - size / 2), (int)(x - size), (int)(x - size / 2), (int)(x + size / 2), (int)(x + size)};
        int[] yCoordinate = {(int)(y + (Math.sqrt(3.0) / 2 * size)), (int)(y + (Math.sqrt(3.0) / 2 * size)), (int) y, (int)(y - (Math.sqrt(3.0) / 2 * size)), (int)(y - (Math.sqrt(3.0) / 2 * size)), (int) y};
        g.drawPolygon(xCoordinates, yCoordinate, 6);
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