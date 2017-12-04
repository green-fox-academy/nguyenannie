import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class SquareGrid {

    public static void mainDraw(Graphics g) {
        squareGrid(g,WIDTH/2, WIDTH/2, 200,20, 4);
    }

    public static void squareGrid(Graphics g, int x, int y, int size, int thickness, int n) {
        if(n== 0){
            return;
        }
        drawSquare(g,x,y,size,thickness);

        int x0 = x -size/2;
        int y0 = y - size/2;

        int x1 = x -size/2;
        int y1 = y + size/2;

        int x2 = x +  size/2;
        int y2 = y + size/2;

        int x3 = x + size/2;
        int y3 = y - size/2;

        int[] xpoints = {x0,x1,x2,x3};
        int[] ypoints = {y0,y1,y2,y3};

        for(int i = 0; i < xpoints.length; i++) {
            squareGrid(g,xpoints[i], ypoints[i], size/2, thickness/2,n -1);
        }
    }

    public static void drawSquare(Graphics g, int x, int y, int size, int thickness) {
        Graphics2D g2 = (Graphics2D) g;
        BasicStroke strokeThick = new BasicStroke(thickness);
        g2.setStroke(strokeThick);
        g2.drawRect(x - size/2,y- size/2,size,size);

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
