import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EventCounter extends JFrame{
    private JButton button;
    private JLabel button_Event_Text, key_Event_Display_Text, key_Event_Counter_Text, window_Event_Text, mouse_Event_Text1, mouse_Event_Text2, mouse_Event_Text3,mouse_Event_Text4;
    private int mouseCounter, keyCounter;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new EventCounter());
    }

    private EventCounter() {
        setSize(300,500);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();
        int xPos = (dim.width - getWidth()) / 2;
        int yPos = (dim.height - getHeight()) / 2;
        setLocation(xPos,yPos);

        JPanel panel = new JPanel();
        add(panel);
        panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));

        button_Event_Text = new JLabel("Button event is displayed here :)");
        panel.add(button_Event_Text);
        panel.add(Box.createRigidArea(new Dimension(0, 15)));

        key_Event_Display_Text = new JLabel("Here is key event.");
        panel.add(key_Event_Display_Text);
        panel.add(Box.createRigidArea(new Dimension(0, 15)));

        key_Event_Counter_Text = new JLabel("Gonna show you key counter.");
        panel.add(key_Event_Counter_Text);
        panel.add(Box.createRigidArea(new Dimension(0, 15)));

        window_Event_Text = new JLabel("Window event.");
        panel.add(window_Event_Text);
        panel.add(Box.createRigidArea(new Dimension(0, 15)));

        ListenForWindow listenForWindow = new ListenForWindow();
        this.addWindowListener(listenForWindow);

        mouse_Event_Text1 = new JLabel("Mouse Panel Event is displayed here");
        panel.add(mouse_Event_Text1);
        panel.add(Box.createRigidArea(new Dimension(0, 15)));

        mouse_Event_Text2 = new JLabel("Mouse Screen Event is displayed here");
        panel.add(mouse_Event_Text2);
        panel.add(Box.createRigidArea(new Dimension(0, 15)));

        mouse_Event_Text3 = new JLabel("Mouse Button Event is displayed here");
        panel.add(mouse_Event_Text3);
        panel.add(Box.createRigidArea(new Dimension(0, 15)));

        mouse_Event_Text4 = new JLabel("Mouse Click Event is displayed here");
        panel.add(mouse_Event_Text4);
        panel.add(Box.createRigidArea(new Dimension(0, 15)));

        ListenForMouse listenForMouse = new ListenForMouse();
        panel.addMouseListener(listenForMouse);

        button = new JButton("Click your mouse here!!!");
        ListenForButton listenForButton = new ListenForButton();
        button.addActionListener(listenForButton);
        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(0, 15)));

        JTextField textField = new JTextField(30);
        ListenForKeyDisplay listenForKeyDisplay = new ListenForKeyDisplay();
        textField.addKeyListener(listenForKeyDisplay);
        ListenForKeyCounter listenForKeyCounter = new ListenForKeyCounter();
        textField.addKeyListener(listenForKeyCounter);
        panel.add(textField);
        panel.add(Box.createRigidArea(new Dimension(0, 15)));
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
            window_Event_Text.setText("Window is active!");
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
            //window_Event_Text.append("Window is in Normal state.");
        }

        @Override
        public void windowActivated(WindowEvent e) {
            //window_Event_Text.append("Window is active.");
        }

        @Override
        public void windowDeactivated(WindowEvent e) {
            //window_Event_Text.append("Window is not active.");
        }
    }


    private class ListenForMouse implements MouseListener{
        @Override
        public void mouseClicked(MouseEvent e) {
            mouse_Event_Text1.setText("Mouse Panel is at " + e.getX() + ", " + e.getY() + " coordinate.");
            mouse_Event_Text2.setText("Mouse Screen is at " + e.getXOnScreen() + ", " + e.getYOnScreen() + " coordinate.");
            mouse_Event_Text3.setText("Mouse Button is " + e.getButton());
            mouse_Event_Text4.setText("Mouse is clicked " + e.getClickCount() + " times.");
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}
