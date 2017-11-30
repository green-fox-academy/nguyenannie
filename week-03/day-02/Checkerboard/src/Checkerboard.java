import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Checkerboard {

    public static void mainDraw(Graphics graphics){
        // fill the canvas with a checkerboard pattern.
        int tileSize = 20;
        int realh = HEIGHT -23;
        for(int i = 0; i < WIDTH/tileSize; i ++) {
            for(int j = 0; j < realh/tileSize; j ++) {
                if (i % 2 != j % 2){
                    graphics.setColor(Color.BLACK);
                } else {
                    graphics.setColor(Color.WHITE);
                }
                drawSquare(graphics, i * tileSize, j *tileSize, tileSize);
            }
        }
        /*
        int y = 0;
        int x = 0;
        while(y <=HEIGHT) {
            for (x = 0; x <= WIDTH; x += 2 * s) {
                drawSquare(graphics, x, y, s);
            }
            y = y + 2 * s;
        }

        x = 20;
        y = 20;
        while(x <=WIDTH-20) {
            for (y = 20; y <= HEIGHT-20; y += 2 * s) {
                drawSquare(graphics, x, y, s);
            }
            x = x + 2 * s;
        }
        */


    }

    public static void drawSquare(Graphics g, int x, int y, int s) {
        g.fillRect(x,y,s,s);
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

