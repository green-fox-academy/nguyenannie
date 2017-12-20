import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

class UIControls extends JFrame{
    private JTextField textField;
    private JTextArea showText, showMemory;
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
        setPanel();

        textField = new JTextField(15);
        textFieldAction();
        textFieldDisplay();

        showText = new JTextArea();
        textDisplay(showText);

        showMemory = new JTextArea();
        textDisplay(showMemory);

        clearButton();
    }

    private void setPanel() {
        panel = new JPanel();
        add(panel);
        panel.setBorder(new EmptyBorder(2, 3, 2, 3));
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
    }

    private void textDisplay(JTextArea textArea) {
        textArea.setAlignmentX(Component.CENTER_ALIGNMENT);
        textArea.setLineWrap(true);
        panel.add(textArea);
        panel.add(Box.createRigidArea(new Dimension(0, 15)));
    }

    private void textFieldDisplay() {
        textField.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(textField);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
    }

    private void textFieldAction() {
        textField.addActionListener(e -> {
            String input = textField.getText();
            showText.setText(input);
            memmory += " " + input;
            showMemory.setText(memmory.substring(0, memmory.length() - input.length()));
            textField.setText("");

        });
    }

    private void clearButton() {
        clearMemory = new JButton();
        clearMemory.setText("Clear");
        clearMemory.setAlignmentX(Component.CENTER_ALIGNMENT);
        clear();
        panel.add(clearMemory);
    }

    private void clear() {
        clearMemory.addActionListener(e -> {
            memmory = "";
            showMemory.setText(memmory);
        });
    }
}
