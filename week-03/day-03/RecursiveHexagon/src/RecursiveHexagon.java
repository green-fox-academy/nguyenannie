import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class RecursiveHexagon {

    public static void mainDraw(Graphics g) {
        recursiveHexagon(g,WIDTH/2, WIDTH/2,200,5);
    }

    public static void recursiveHexagon(Graphics g, int x, int y, int size, int n) {
        if(n == 0) {
            return;
        }
        drawHexagon(g,x,y,size);

        int x0 = x - size/4 ;
        int y0 = y + (int)(Math.sqrt(3.0)*size/4);

        int x1 = x - size/4;
        int y1 = y - (int)(Math.sqrt(3.0)*size/4);

        int x2 = x + size/2;
        int y2 = y;

        recursiveHexagon(g,x0,y0,size/2,n - 1);
        recursiveHexagon(g, x1,y1,size/2,n - 1);
        recursiveHexagon(g,x2,y2,size/2,n-1);

    }
    public static void drawHexagon(Graphics g, int x,int y, int size) {
        int[] xCoordinates = {x + size/2, x - size/2, x - size, x - size/2, x + size/2,x + size};
        int[] yCoordinate = {y + (int)(Math.sqrt(3.0)/2*size),y + (int)(Math.sqrt(3.0)/2*size), y,y - (int)(Math.sqrt(3.0)/2*size),y - (int)(Math.sqrt(3.0)/2*size),y};
        g.drawPolygon(xCoordinates,yCoordinate,6);
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