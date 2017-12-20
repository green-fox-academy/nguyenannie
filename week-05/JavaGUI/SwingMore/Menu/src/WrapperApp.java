import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WrapperApp extends JFrame {
    JMenuBar menuBar;
    JMenu menu;

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

        menu = new JMenu("I am menu");
        add(menu);

        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.add(menu);

        JMenuItem menuItem1 = new JMenuItem("I am an Item");
        menu.add(menuItem1);

        JMenuItem menuItem2 = new JMenuItem("I am also an Item");
        menu.add(menuItem2);
        menuItem2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

}
