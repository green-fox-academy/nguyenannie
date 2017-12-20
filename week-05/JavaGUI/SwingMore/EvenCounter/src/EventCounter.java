import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EventCounter extends JFrame{
    JPanel panel;
    JButton mouse_Event_Counter, key_Event_Counter, window_Event_Counter;
    JTextField mouse_Event_Text, key_Event_Text, window_Event_Text;
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

        textArea = new JTextArea(15,30);
        panel.add(textArea);

        mouse_Event_Text = new JTextField(30);
        panel.add(mouse_Event_Text);

        mouse_Event_Counter = new JButton("Mouse Event Counter");
        ListenForButton listenForButton = new ListenForButton();
        mouse_Event_Counter.addActionListener(listenForButton);
        panel.add(mouse_Event_Counter);

        key_Event_Text = new JTextField(30);
        ListenForKey listenForKey = new ListenForKey();
        key_Event_Text.addKeyListener(listenForKey);
        panel.add(key_Event_Text);

    }

    private class ListenForButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == mouse_Event_Counter) {
                counter++;
                mouse_Event_Text.setText("You have clicked the mouse for " + counter + " time.");
            }
        }
    }

    private class ListenForKey extends KeyAdapter {
        @Override
        public void keyTyped(KeyEvent e) {
            textArea.append("You hits " + e.getKeyChar() + " ");
        }
    }
}
