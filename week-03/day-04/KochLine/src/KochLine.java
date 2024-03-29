import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;


public class KochLine{

    public static void mainDraw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0,0,WIDTH,HEIGHT);
        g.setColor(Color.BLACK);
        recursiveKochLines(g,150,300,300,0,3);
        //kochLine(g,200,200,300,Math.PI/5);
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
            //g.setColor(Color.BLACK);
            g.drawLine((int)x,(int)y,(int)x4,(int)y4);
            return;
        }

        recursiveKochLines(g,x,y,size/3,angle,n-1);
        recursiveKochLines(g,x1,y1,size/3,angle - Math.PI/3,n-1);
        recursiveKochLines(g,x2,y2,size/3,angle +  Math.PI/3,n-1);
        recursiveKochLines(g,x3,y3,size/3,angle,n-1);


    }

    /*
    public static void kochLine(Graphics g, int x, int y, int size, double angle) {

        int x1 = x + (int)(Math.cos(angle) * size/3);
        int y1 = y + (int)(Math.sin(angle) * size/3);

        int x2 = x1 + (int)(Math.cos(angle - Math.PI/3) * size / 3);
        int y2= y1 + (int)(Math.sin(angle - Math.PI/3) * size/3);

        int x3 = x2 + (int)(Math.cos(angle + Math.PI/3) * size/3);
        int y3 = y2 + (int)(Math.sin(angle + Math.PI/3) * size/3);

        int x4 = x + (int)(Math.cos(angle) * size);
        int y4 = y + (int)(Math.sin(angle) * size);


        g.drawLine((int)x,y,x1,y1);
        g.drawLine(x1,y1,x2,y2);
        g.drawLine(x2,y2,x3,y3);
        g.drawLine(x3,y3,x4,y4);
    }
    */
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

    //All Failed attemps below :)
     /*
    public static void koch(int n, double size) {
        Turtle kochTurtle = new Turtle();
        if( n == 0) {
            kochTurtle.goForward(size);
        }
        else {
            koch( n - 1, size);
            kochTurtle.turn(Math.PI/3);
            koch(n - 1, size);
            kochTurtle.turn(-2 * Math.PI/3);
            koch(n -1, size);
            kochTurtle.turn(Math.PI/3);
            koch(n -1,size);
            }
        }
    }


    public static void recursiveKochLine(Graphics g, int x, int y, int size, int n) {
        if(n == 0) {
            return;
        }
        int height = (int)(Math.sqrt(3.0)/6* size);

        double[] angles = {-Math.PI/2, -5/6 * Math.PI,-1/6 * Math.PI, -Math.PI/2};

        double x0 = x- 7 * size/18 + height/3 * Math.cos(angles[0]);
        double y0 = y + 2 * height/3 + height/3 * Math.sin(angles[0]);

        double x1 = x - size/6 + height/3 * Math.cos(angles[1]);
        double y1 = y + height/3 + height/3 * Math.sin(angles[1]);

        double x2 = x + size/6 + height/3 * Math.cos(angles[2]);
        double y2 = y + height/3 + height/3 * Math.sin(angles[2]);

        double x3 = x + 7 * size/18 + height/3*Math.cos(angles[3]);
        double y3 = y + 2 * height/3 + height/3 * Math.sin(angles[3]);

        recursiveKochLine(g,(int)x0,(int)y0,size/3, n -1 );
        recursiveKochLine(g,(int)x1,(int)y1,size/3, n -1 );
        recursiveKochLine(g,(int)x2,(int)y2,size/3, n -1 );
        recursiveKochLine(g,(int)x3,(int)y3,size/3, n -1 );

        drawKochLine(g,x,y,size);
    }


    public static void drawKochLine(Graphics g, int x, int y, int size) {
        int height = (int)(Math.sqrt(3.0)/6* size);

        int x0 = x - size/2;
        int y0 = y + height;

        int x1 = x - size/6;
        int y1 = y + height;


        int x2 = x + size/6;
        int y2 = y + height;

        int x3 = x + size/2;
        int y3 = y + height;

        g.drawLine(x0,y0,x1,y1);
        g.drawLine(x1,y1,x,y);
        g.drawLine(x,y,x2,y2);
        g.drawLine(x2,y2,x3,y3);

    }

    */

}
