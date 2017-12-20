import javax.swing.*;
import java.awt.*;

public class ComplexLayout extends JFrame {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ComplexLayout());
    }

    ComplexLayout() {
        setSize(500,500);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Complex Layout");

        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();
        int xPos = (dim.width - getWidth()) / 2;
        int yPos = (dim.height - getHeight()) / 2;
        setLocation(xPos, yPos);

        JPanel left = new JPanel();
        add(left);
        JPanel right = new JPanel();
        add(right);
        left.setLayout(new GridLayout(3, 1, 5, 5));
        right.setLayout(new BorderLayout(10, 10));

        JButton buttonLeft = new JButton("Click me!");
        left.add(buttonLeft);

        JButton buttonRight = new JButton("Click me too!");
        right.add(buttonRight);

        getContentPane().setLayout(new FlowLayout());
    }
}
