import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class UIControls extends JFrame{
    private JTextField textField;
    private JLabel showLabel, memoryLabel;
    private String memmory;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new UIControls());
    }

    UIControls() {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();

        setSize(400,200);
        int xPos = (dim.width - this.getWidth()) / 2;
        int yPos = (dim.height - this.getHeight()) / 2;
        setLocation(xPos, yPos);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        display();
    }

    void display() {
        JPanel panel = new JPanel();
        add(panel);
        panel.setBorder(new EmptyBorder(2, 3, 2, 3));
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));

        textField = new JTextField(15);
        memmory = "";

        textField.addActionListener(e -> {
            String input = textField.getText();
            showLabel.setText(input);
            memmory += " " + input;
            memoryLabel.setText(memmory.substring(0, memmory.length() - input.length()));
            textField.setText("");

        });
        textField.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(textField);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));

        showLabel = new JLabel();
        showLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(showLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 15)));

        memoryLabel = new JLabel();
        memoryLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(memoryLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 15)));

    }


}
