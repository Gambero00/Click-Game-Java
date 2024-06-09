import javax.swing.*;
import java.awt.*;

public class ClickGameWindow extends JFrame {
    public ClickGameWindow() {
        int height, width;
        int gameTime = 4;
        int buttonheight = 100;
        int buttonwidth = 200;
        int rounds = 5;

        GraphicsDevice device = GraphicsEnvironment
                .getLocalGraphicsEnvironment().getDefaultScreenDevice();

        if (device.isFullScreenSupported()) {
            setUndecorated(true);  // Rimuove i bordi e la barra del titolo
            device.setFullScreenWindow(this);  // Imposta il frame a schermo intero
        } else {
            setSize(800, 600);  // Se il full screen non è supportato, imposta una dimensione predefinita
            setVisible(true);   // Rendi visibile il frame
        }

        height = device.getDisplayMode().getHeight();
        width = device.getDisplayMode().getWidth();


        setTitle("Click-Game");

        // Imposta il pannello iniziale come contenuto del frame
        setContentPane(new StartPanel(this, height, width, gameTime, buttonheight, buttonwidth, rounds));

        setVisible(true);
    }

    public static void main(String[] args) {
         new ClickGameWindow();
    }
}
