import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EventCounter extends JFrame{
    private JPanel panel;
    private JButton button;
    private JLabel button_Event_Text, key_Event_Display_Text, key_Event_Counter_Text;
    private JTextField textField;
    private JTextArea window_Event_Text;
    private int mouseCounter, keyCounter;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new EventCounter());
    }

    EventCounter() {
        setSize(500,300);
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
        panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));

        button_Event_Text = new JLabel();
        panel.add(button_Event_Text);
        panel.add(Box.createRigidArea(new Dimension(0, 15)));

        key_Event_Display_Text = new JLabel();
        panel.add(key_Event_Display_Text);
        panel.add(Box.createRigidArea(new Dimension(0, 15)));

        key_Event_Counter_Text = new JLabel();
        panel.add(key_Event_Counter_Text);
        panel.add(Box.createRigidArea(new Dimension(0, 15)));

        window_Event_Text = new JTextArea();
        panel.add(window_Event_Text);
        window_Event_Text.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(Box.createRigidArea(new Dimension(0, 15)));

        button = new JButton("Click your mouse here!!!");
        ListenForButton listenForButton = new ListenForButton();
        button.addActionListener(listenForButton);
        panel.add(button);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(Box.createRigidArea(new Dimension(0, 15)));

        textField = new JTextField(30);
        ListenForKeyDisplay listenForKeyDisplay = new ListenForKeyDisplay();
        textField.addKeyListener(listenForKeyDisplay);
        ListenForKeyCounter listenForKeyCounter = new ListenForKeyCounter();
        textField.addKeyListener(listenForKeyCounter);
        panel.add(textField);

        ListenForWindow listenForWindow = new ListenForWindow();
        this.addWindowListener(listenForWindow);

    }

    private class ListenForButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == button) {
                mouseCounter++;
                button_Event_Text.setText("You have clicked me for " + mouseCounter + " time.");
            }
        }
    }

    private class ListenForKeyDisplay extends KeyAdapter {
        @Override
        public void keyTyped(KeyEvent e) {
            key_Event_Display_Text.setText("You typed " + e.getKeyChar());

        }
    }

    private class ListenForKeyCounter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            keyCounter++;
            key_Event_Counter_Text.setText("You pressed " + keyCounter + " times.");

        }
    }

    private class ListenForWindow implements WindowListener {

        @Override
        public void windowOpened(WindowEvent e) {
            window_Event_Text.append("Window is active!");
        }

        @Override
        public void windowClosing(WindowEvent e) {
            //window_Event_Text.append();
        }

        @Override
        public void windowClosed(WindowEvent e) {

        }

        @Override
        public void windowIconified(WindowEvent e) {

        }

        @Override
        public void windowDeiconified(WindowEvent e) {
            window_Event_Text.append("Window is in Normal state.");
        }

        @Override
        public void windowActivated(WindowEvent e) {
            window_Event_Text.append("Window is active.");
        }

        @Override
        public void windowDeactivated(WindowEvent e) {
            window_Event_Text.append("Window is not active.");
        }
    }
}
