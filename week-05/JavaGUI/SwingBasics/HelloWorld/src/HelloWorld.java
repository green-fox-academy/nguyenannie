import javax.swing.*;
import java.awt.*;

public class HelloWorld extends JFrame {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new HelloWorld());
    }

    public HelloWorld() {
        this.setSize(1000,500);
        this.setTitle("Hello World");
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();

        int xPos = (dim.width - this.getWidth()) / 2;
        int yPos = (dim.height - this.getHeight()) / 2;

        this.setLocation(xPos,yPos);


        JPanel panel = new JPanel();
        add(panel);

        JLabel label = new JLabel("Hello World");
        panel.add(label);

        customHello(panel);
    }

    public void customHello(JPanel panel) {
        String[] hellos = {"Mirëdita", "Ahalan", "Parev", "Zdravei", "Nei Ho", "Dobrý den", "Ahoj", "Goddag", "Goede dag, Hallo", "Hello", "Saluton", "Hei", "Bonjour",
                "Guten Tag", "Gia'sou", "Aloha", "Shalom", "Namaste", "Namaste", "Jó napot", "Halló", "Helló", "Góðan daginn", "Halo", "Aksunai", "Qanuipit", "Dia dhuit",
                "Salve", "Ciao", "Kon-nichiwa", "An-nyong Ha-se-yo", "Salvëte", "Ni hao", "Dzien' dobry", "Olá", "Bunã ziua", "Zdravstvuyte", "Hola", "Jambo", "Hujambo", "Hej",
                "Sa-wat-dee", "Merhaba", "Selam", "Vitayu", "Xin chào", "Hylo", "Sut Mae", "Sholem Aleychem", "Sawubona"};

        for(String hello : hellos) {
            JLabel customLabel = new JLabel();
            customLabel.setText(" - " + hello);
            panel.add(customLabel);
        }
    }
}
