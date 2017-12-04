import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class SierpinskyCarpet {
    public static void mainDraw(Graphics g) {
        //drawSquare(g,0,0,100);
        //g.fillRect(0,0,100,100);
        drawCarpet(g,WIDTH/2, WIDTH/2,200, 5);

    }

    public static void drawCarpet(Graphics g, int x, int y, int size, int n) {
        if(n == 0){
            return;
        }
        drawSquare(g,x,y,size);

        int x0 = x;
        int y0 = y - size;

        int x1= x -size;
        int y1 = y - size;

        int x2 = x - size;
        int y2 = y;

        int x3 = x - size;
        int y3 = y + size;

        int x4 = x;
        int y4 = y + size;

        int x5 = x + size;
        int y5 = y + size;

        int x6 = x + size;
        int y6 =y;

        int x7 = x + size;
        int y7 = y - size;

        int[] xpoints = {x0,x1,x2,x3,x4,x5,x6,x7};
        int[] ypoints = {y0, y1,y2,y3,y4,y5,y6,y7};

        for(int i = 0; i < xpoints.length; i ++) {
            drawCarpet(g,xpoints[i], ypoints[i],size/3,n-1);
        }
    }
    public static void drawSquare(Graphics g, int x, int y, int size) {
        int x0 = x - size/2;
        int y0 = y - size/2;

        g.fillRect(x0,y0,size,size);
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
