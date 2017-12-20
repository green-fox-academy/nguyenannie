import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WrapperApp extends JFrame {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new WrapperApp());
    }

    private WrapperApp() {
        setSize(500, 500);
        setVisible(true);
        setResizable(false);
        setTitle("WrapperApp");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();
        int xPos = (dim.width - getWidth()) / 2;
        int yPos = (dim.height - getHeight()) / 2;
        setLocation(xPos, yPos);

        createImage();

        JMenu menu1 = new JMenu("Welcome");
        JMenu menu2 = new JMenu("More details");

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.add(menu1);
        menuBar.add(menu2);

        JMenuItem menuItem1 = new JMenuItem("I am an Item");
        menu1.add(menuItem1);

        JMenuItem menuItem2 = new JMenuItem("Here to exit");
        menu1.add(menuItem2);
        menuItem2.addActionListener(e -> System.exit(0));

        JMenuItem menuItem3 = new JMenuItem("Detail 1");
        menu2.add(menuItem3);
    }

    private void createImage() {
        add(new ImagePanel(){@Override
        public void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);
            requestFocus();
            graphics.drawImage(image, 0, 25, this);

            graphics.setColor(Color.RED);
            graphics.setFont(new Font("Courier", Font.BOLD, 35));
            graphics.drawString("MERRY CHRISTMAS", 160, 330);

            graphics.setColor(Color.WHITE);
            graphics.fillOval(230,130,30,30);

            graphics.setColor(Color.WHITE);
            graphics.fillOval(320,130,30,30);

            graphics.setColor(Color.RED.WHITE);
            graphics.fillRect(250,180,85,15);
        }});
    }

}
