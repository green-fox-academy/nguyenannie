import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class UIControls extends JFrame{
    private JTextField textField;
    private JTextArea showLabel, memoryLabel;
    private String memmory;
    private JButton clearMemory;
    private JPanel panel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new UIControls());
    }

    UIControls() {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();

        setSize(500,600);
        int xPos = (dim.width - this.getWidth()) / 2;
        int yPos = (dim.height - this.getHeight()) / 2;
        setLocation(xPos, yPos);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        display();
    }

    void display() {
        panel = new JPanel();
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

        showLabel = new JTextArea();
        labelDisplay(showLabel);

        memoryLabel = new JTextArea();
        labelDisplay(memoryLabel);

    }

    void labelDisplay(JTextArea textArea) {
        textArea.setAlignmentX(Component.CENTER_ALIGNMENT);
        textArea.setLineWrap(true);
        panel.add(textArea);
        panel.add(Box.createRigidArea(new Dimension(0, 15)));
    }
}
