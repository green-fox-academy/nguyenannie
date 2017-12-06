import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class KochSnowflake {
    public static void mainDraw(Graphics g) {
        KnockSnowFlake(g,50,150,500,0,3);

    }
    public static void KnockSnowFlake(Graphics g, int x, int y, int size, double angle, int n) {
        int height = (int)(Math.sqrt(3.0) * size/2);
        recursiveKochLines(g,x,y,size,angle,n);
        recursiveKochLines(g,x + size,y,size,angle+ 2 * Math.PI/3,n);
        recursiveKochLines(g,x + size/2,y + height,size,angle - 2 * Math.PI/3,n);
    }

    public static void recursiveKochLines(Graphics g, double x, double y, int size, double angle, int n) {

        double x1 = x + (Math.cos(angle) * size/3);
        double y1 = y + (Math.sin(angle) * size/3);

        double x2 = x1 + (Math.cos(angle - Math.PI/3) * size / 3);
        double y2= y1 + (Math.sin(angle - Math.PI/3) * size/3);

        double x3 = x2 + (Math.cos(angle + Math.PI/3) * size/3);
        double y3 = y2 + (Math.sin(angle + Math.PI/3) * size/3);

        double x4 = x + (Math.cos(angle) * size);
        double y4 = y + (Math.sin(angle) * size);

        if(n == 0) {
            g.drawLine((int)x,(int)y,(int)x4,(int)y4);
            return;
        }

        recursiveKochLines(g,x,y,size/3,angle,n-1);
        //g.setColor(new Color((int)(200/n * Math.random()),(int)(150/n * Math.random()),(int)(250/n * Math.random())));
        recursiveKochLines(g,x1,y1,size/3,angle - Math.PI/3,n-1);
        //g.setColor(new Color((int)(150/n * Math.random()),(int)(250/n * Math.random()),(int)(200/n * Math.random())));
        recursiveKochLines(g,x2,y2,size/3,angle +  Math.PI/3,n-1);
        //g.setColor(new Color((int)(50/n * Math.random()),(int)(200/n * Math.random()),(int)(250/n * Math.random())));
        recursiveKochLines(g,x3,y3,size/3,angle,n-1);

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
