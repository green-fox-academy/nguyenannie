import javax.swing.*;
import java.awt.*;

class Counter extends JFrame {
    private int clicks = 0;
    private JLabel label;
    private JButton counterButton, resetButton;

    Counter() {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();

        this.setSize(400,70);
        this.setVisible(true);
        int xPos = (dim.width - this.getWidth()) / 2;
        int yPos = (dim.height - this.getHeight()) / 2;
        this.setLocation(xPos, yPos);
        this.setTitle("Counter App");
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        display();
    }

    void display() {
        JPanel panel = new JPanel();
        add(panel);
        label = new JLabel();
        panel.add(label);
        updateCounter();

        counterButton = new JButton("Click me");
        counterButton.addActionListener(e -> {
            clicks++;
            updateCounter();
        });
        panel.add(counterButton);

        resetButton = new JButton("Reset");
        resetButton.addActionListener(e -> {
            clicks = 0;
            updateCounter();
        });
        panel.add(resetButton);
    }

    private void updateCounter() {
        label.setText("Numbers of clicks: " + clicks);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Counter());
    }
}
