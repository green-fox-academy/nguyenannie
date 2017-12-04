import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class RecursiveCircle {
    public static void mainDraw(Graphics g) {
        //recursiveCircle2(g,WIDTH/2,WIDTH/2,200,3);
        recursiveCircle(g,WIDTH/2,WIDTH/2,300,5);


    }
    // draw recursive circle with unit vector
    public static void recursiveCircle2(Graphics g,int x, int y,int size, int n) {
        if(n == 0) {
            return;
        }

        drawCircle(g, x,y,size);

        double[] angles = {-Math.PI/2, -Math.PI *7/6, -Math.PI * 11/6};
        double[] pointx = new double[3];
        double[] pointy = new double[3];

        for(int i = 0; i < angles.length; i++) {
            pointx[i] = x + size / 4 * Math.cos(angles[i]);
            pointy[i] = y + size / 4 * Math.sin(angles[i]);
        }
        recursiveCircle2(g,(int)pointx[0],(int)pointy[0],size/2,n-1);
        recursiveCircle2(g,(int)pointx[1],(int)pointy[1],size/2,n-1);
        recursiveCircle2(g,(int)pointx[2],(int)pointy[2],size/2,n-1);

    }
    // draw recursive function with calculated coordinate
    public static void recursiveCircle(Graphics g,int x, int y, int size, int n)  {
        if(n == 0){
            return;
        }
        drawCircle(g,x,y,size);

        int x0 = x;
        int y0 = y - size/4;

        int x1 = x - (int)(size/(Math.sqrt(2.0)*4));
        int y1 = y + (int)(size/(Math.sqrt(2.0)*4));

        int x2 = x + (int)(size/(Math.sqrt(2.0)*4));
        int y2 = y + (int)(size/(Math.sqrt(2.0)*4));

        g.setColor(Color.RED);
        recursiveCircle(g,x0,y0,size/2,n-1);
        g.setColor(Color.BLUE);
        recursiveCircle(g,x1 ,y1 ,size/2,n-1);
        g.setColor(Color.GREEN);
        recursiveCircle(g,x2 ,y2 ,size/2,n-1);
    }


    public static void drawCircle(Graphics g, int x, int y, int size) {
        g.drawOval(x - size/2, y - size/2,size,size);
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
