import javax.swing.*;
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

        showLabel = new JLabel();
        panel.add(showLabel);

        memoryLabel = new JLabel();
        panel.add(memoryLabel);

        textField = new JTextField(15);
        memmory = "";

        textField.addActionListener(e -> {
            String input = textField.getText();
            showLabel.setText(input);
            memmory += input;
            System.out.println(memmory);
            memoryLabel.setText(memmory.substring(0, memmory.length() - input.length()));
            textField.setText("");

        });
        panel.add(textField);
    }


}
