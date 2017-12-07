import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class SuperHexagon {
    public static void mainDraw(Graphics g){
        int size = 20;
        double height = Math.sqrt(3.0) * size ;

        int colNum = 7; //number of hex that stack on each other
        int shift = 0;

        for(int j = 0; j < colNum ; j ++) { // loop for drawing hex horizontally
            for (int i = colNum; i > 0; i--) { //loop for drawing hex vertically
                drawHex(g, WIDTH/2 + j * size + shift * size/2, i* height + shift * height/2, size);
                drawHex(g, WIDTH/2 - j * size - shift * size/2, i* height + shift * height/2, size);
            }
            colNum -= 1;
            shift += 1;
        }
    }

    public static void drawHex(Graphics g, double x, double y, int size){
        double[] angles ={-Math.PI/3, -2 *  Math.PI/3,- Math.PI, 2 * Math.PI/3, Math.PI/3,0};
        double[] xpoints = new double[6];
        double[] ypoints = new double[6];
        int[] xPoints = new int[6];
        int[] yPoints = new int[6];

        for(int i= 0; i < 6; i ++){
            xpoints[i] = x + size * Math.cos(angles[i]);
            ypoints[i] = y + size * Math.sin(angles[i]);
            xPoints[i] =(int) xpoints[i];
            yPoints[i] = (int) ypoints[i];
        }

        g.drawPolygon(xPoints,yPoints,6);

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
