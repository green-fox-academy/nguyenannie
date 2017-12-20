import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventCounter extends JFrame{
    JPanel panel;
    JButton mouse_Event_Counter, key_Event_Counter, window_Event_Counter;
    JTextField textField;
    JTextArea textArea;
    int counter;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new EventCounter());
    }

    EventCounter() {
        setSize(500,500);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();
        int xPos = (dim.width - getWidth()) / 2;
        int yPos = (dim.height - getHeight()) / 2;
        setLocation(xPos,yPos);

        panel = new JPanel();
        add(panel);

        textField = new JTextField(30);
        panel.add(textField);

        mouse_Event_Counter = new JButton("Mouse Event Counter");
        ButtonListener buttonListener = new ButtonListener();
        mouse_Event_Counter.addActionListener(buttonListener);
        panel.add(mouse_Event_Counter);

    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == mouse_Event_Counter) {
                counter++;
                textField.setText("You have clicked the mouse for " + counter + " time.");
            }
        }
    }

}
