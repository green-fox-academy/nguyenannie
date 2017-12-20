import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.Graphics;

public class ImageApp extends JFrame {
    private Image image = new ImageIcon("floral-bunny.png").getImage();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ImageApp());
    }

    ImageApp() {
        setSize(600, 750);
        setTitle("ImageApp");
        setResizable(false);
        setVisible(true);

        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();
        int xPos = (dim.width - this.getWidth()) / 2;
        int yPos = (dim.height - this.getHeight()) / 2;
        setLocation(xPos, yPos);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                requestFocus();
                g.drawImage(image, 50,30, null);
            }
        };
        add(panel);

    }


}
