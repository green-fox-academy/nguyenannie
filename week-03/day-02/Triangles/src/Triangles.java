import javax.swing.*;

import java.awt.*;

import static java.awt.Frame.MAXIMIZED_BOTH;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Triangles {

    public static void mainDraw(Graphics graphics){
        // reproduce this:
        // [https://github.com/greenfox-academy/teaching-materials/blob/master/workshop/drawing/triangles/r5.png]
        int side =  WIDTH/20;
        //int height = (int)(Math.sqrt(Math.pow(side,2) + Math.pow(side/2,2)));
        int height =  WIDTH/20;
        int k = 21;
        int z = 0;
        //draw from the bottom
        for(int j = 20; j > 0; j --) {
            //draw triangles on each lines, move triangles to the left each level up and reduce the height
            for (int i = 1; i < k; i++) {
                drawTriangle(graphics, i * side + z * side/2, j * height);
            }
            k = k - 1;
            z = z + 1;
        }

    }

    public static void drawTriangle(Graphics g,int x, int y){
        int side = WIDTH/20;
        //int height = (int)(Math.sqrt(Math.pow(side,2) + Math.pow(side/2,2)));
        int height = WIDTH/20;
        g.drawPolygon(new int[]{x - side/2, x, x + side/2}, new int[]{y, y - height, y}, 3);

    }

    //    Don't touch the code below
    static int WIDTH = 320;
    static int HEIGHT = 343;

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
