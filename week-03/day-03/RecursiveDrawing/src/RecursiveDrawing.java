import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class RecursiveDrawing {
    public static void mainDraw(Graphics graphics){
        graphics.setColor(Color.yellow);
        graphics.fillRect(0,0,600,600);
        graphics.setColor(Color.BLACK);
        recursiveDraw(graphics,300,300,600,5);

    }

    public static void recursiveDraw(Graphics g, int x, int y, int size, int n){
        if(n == 0){
            return;
        }
        drawhash(g,x,y,size);

        int x0 = x + size/3;
        int y0 = y + size/3;
        int x1 = x - size/3;
        int y1 = y - size/3;

        recursiveDraw(g,x,y0,size/3,n -1);
        recursiveDraw(g,x,y1,size/3,n -1);
        recursiveDraw(g,x0,y,size/3,n -1);
        recursiveDraw(g,x1,y,size/3,n -1);
    }

    public static void drawhash(Graphics g, int x, int y, int size) {

        g.drawLine(x + size/6, y + size/2, x + size/6, y - size/2);
        g.drawLine(x - size/6, y + size/2, x - size/6, y - size/2);
        g.drawLine(x - size/2, y + size/6, x + size/2, y + size/6);
        g.drawLine(x - size/2, y - size/6, x + size/2, y - size/6);
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


