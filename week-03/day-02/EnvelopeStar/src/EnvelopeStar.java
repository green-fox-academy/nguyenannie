import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class EnvelopeStar {

    public static void mainDraw(Graphics graphics){
        // reproduce this:
        // [https://github.com/greenfox-academy/teaching-materials/blob/master/workshop/drawing/envelope-star/r2.png]
        int space = 10;
        for(int i = 0; i < WIDTH/space/2; i ++){

            graphics.setColor(Color.GREEN);

            graphics.drawLine(i * space,WIDTH/2,WIDTH/2, WIDTH/2 - i *space);
            graphics.drawLine(i * space,WIDTH/2,WIDTH/2, WIDTH/2 + i *space);
            graphics.drawLine(WIDTH -i *space,WIDTH/2, WIDTH/2,WIDTH/2 - i * space);
            graphics.drawLine(WIDTH - i * space,WIDTH/2,WIDTH/2,WIDTH/2 + i * space);

        }
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

