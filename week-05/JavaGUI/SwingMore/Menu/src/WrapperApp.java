import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WrapperApp extends JFrame implements ActionListener{
    JFrame frame1 = new JFrame();
    JMenuItem helloWorld_menuItem, UIControls_menuItem,  counterApp_menuItem, eventCounter_menuItem, drawToImage_menuItem;

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

        JMenu menu1 = new JMenu("All Apps");
        JMenu menu2 = new JMenu("Exit");

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.add(menu1);
        menuBar.add(menu2);

        menu2.addActionListener(e -> System.exit(0));

        helloWorld_menuItem = new JMenuItem("Hello to all the world");
        menu1.add(helloWorld_menuItem);
        helloWorld_menuItem.addActionListener(this);

        UIControls_menuItem = new JMenuItem("UIConstrols");
        menu1.add(UIControls_menuItem);
        UIControls_menuItem.addActionListener(this);

        counterApp_menuItem = new JMenuItem("Counter App");
        menu1.add(counterApp_menuItem);
        counterApp_menuItem.addActionListener(this);

        eventCounter_menuItem = new JMenuItem("Event Counter");
        menu1.add(eventCounter_menuItem);
        eventCounter_menuItem.addActionListener(this);

        drawToImage_menuItem = new JMenuItem("Draw to Image");
        menu1.add(drawToImage_menuItem);
        drawToImage_menuItem.addActionListener(this);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == UIControls_menuItem) {
           new UIControls().setVisible(true);
        }

        if (e.getSource() == eventCounter_menuItem) {
            new EventCounter().setVisible(true);
        }

        if (e.getSource() == helloWorld_menuItem) {
            new HelloWorld().setVisible(true);
        }

        if (e.getSource() == drawToImage_menuItem) {
            new ImageApp().setVisible(true);
        }

        if (e.getSource() == counterApp_menuItem) {
            new Counter().setVisible(true);
        }
    }
}
