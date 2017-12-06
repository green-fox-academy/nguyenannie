import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class RecursiveHexagon2 {

    public static void mainDraw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0,0,WIDTH,WIDTH);
        g.setColor(Color.GREEN);
        drawHexagon(g,WIDTH/2,WIDTH/2,200);
        recursiveHexagon(g,WIDTH/2,WIDTH/2,200,4);

    }
    public static void recursiveHexagon(Graphics g, double x, double y, int size, int n) {
        if(n == 0) {
            return;
        }
        drawHexagon(g,x,y,size);

        double height = Math.sqrt(3.0) * size / 2;

        double x0 = x - size/3;
        double y0 = y -2 *height/3;

        double x1 = x - 2 * size/3;
        double y1 = y;

        double x2 = x - size/3;
        double y2 = y + 2 * height/3;

        double x3 = x + size/3;
        double y3 = y + 2 * height/3;

        double x4= x + 2 * size/3;
        double y4 = y;

        double x5 = x + size/3;
        double y5 = y - 2 * height/3;

        int[] xpoints = {(int)x0,(int)x1,(int)x2,(int)x3,(int)x4,(int)x5};
        int[] ypoints = {(int)y0,(int)y1,(int)y2,(int)y3,(int)y4,(int)y5};

        /*for(int i = 0; i < xpoints.length; i++) {
            recursiveHexagon(g,xpoints[i],ypoints[i],size/3, n - 1);
        }
        */
        g.setColor(Color.RED);
        recursiveHexagon(g,x0,y0,size/3, n - 1);
        g.setColor(Color.GREEN);
        recursiveHexagon(g,x1,y1,size/3, n - 1);
        g.setColor(Color.BLUE);
        recursiveHexagon(g,x2,y2,size/3, n - 1);
        g.setColor(Color.CYAN);
        recursiveHexagon(g,x3,y3,size/3, n - 1);
        g.setColor(Color.YELLOW);
        recursiveHexagon(g,x4,y4,size/3, n - 1);
        g.setColor(Color.MAGENTA);
        recursiveHexagon(g,x5,y5,size/3, n - 1);

    }

    public static void drawHexagon(Graphics g, double x, double y, int size) {
        double height = (int)(Math.sqrt(3.0) * size / 2);
        double x0 = x - size/2;
        double y0 = y - height;

        double x1 = x - size;
        double y1 = y;

        double x2 = x - size/2;
        double y2 = y + height;

        double x3 = x + size/2;
        double y3 = y + height;

        double x4 = x + size;
        double y4 = y;

        double x5 = x  + size/2;
        double y5 = y - height;

        g.drawPolygon(new int[]{(int)x0,(int)x1,(int)x2,(int)x3,(int)x4,(int)x5}, new int[]{(int)y0,(int)y1,(int)y2,(int)y3,(int)y4,(int)y5},6);
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

