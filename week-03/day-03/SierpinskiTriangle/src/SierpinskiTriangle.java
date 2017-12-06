import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class SierpinskiTriangle {
    public static void mainDraw(Graphics g){
        triangleRecursive(g,WIDTH/2,WIDTH/2,600,7);

    }

    public static void triangleRecursive(Graphics g, double x, double y, int size, int n) {
        if(n == 0) {
            return;
        }
        triangleDraw(g,(int)x,(int)y,size);

        double height = (Math.sqrt(3.0)/2 * size);

        double x0 = x + size/4;
        double y0 = y - height/4;

        double x1 = x - size/4;
        double y1 = y - height/4;

        double x2 = x;
        double y2 = y + height/4;

        g.setColor(new Color(100,255,240));
        triangleRecursive(g,x0,y0,size/2,n-1);
        g.setColor(new Color(255,150,100));
        triangleRecursive(g,x1,y1,size/2,n-1);
        g.setColor(new Color(150,240,100));
        triangleRecursive(g,x2,y2,size/2,n-1);

    }

    public static void triangleDraw(Graphics g, double x, double y, int size){
        double height = (int)(Math.sqrt(3.0)/2 * size);
        double x0 = x + size/2;
        double y0 = y - height/2;

        double x1 = x - size/2;
        double y1 = y - height/2;

        double y2 = y + height/2;

        g.drawPolygon(new int[]{(int)x0,(int)x1,(int)x},new int[]{(int)y0,(int)y1,(int)y2},3);
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
