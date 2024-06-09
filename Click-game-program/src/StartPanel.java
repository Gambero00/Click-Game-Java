import javax.swing.*;
import java.awt.*;

public class StartPanel extends JPanel {
    private JLabel titolo;
    int buttonheigth;
    int buttonwidth;
    int rounds;
    public StartPanel(JFrame frame, int height, int width, int gameTime, int buttonheigth, int buttonwidth, int rounds) {

        setLayout(new GridBagLayout());
        Dimension titleSize = new Dimension(1000, 100); // Dimensioni più grandi per il titolo
        Dimension buttonSize = new Dimension(200, 50); // Dimensioni più piccole per i bottoni
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        titolo = new JLabel("Click Game!");
        titolo.setFont(titolo.getFont().deriveFont(Font.BOLD, 100));
        titolo.setHorizontalAlignment(SwingConstants.CENTER);
        titolo.setMaximumSize(buttonSize); // Imposta la dimensione massima per impedire che si estenda oltre questa larghezza
        add(titolo, gbc);

        gbc.gridy = 1;
        JButton playButton = new JButton("GIOCA");
        playButton.addActionListener(e -> {

            frame.setContentPane(new ClickGamePanel(frame, height, width, gameTime, buttonheigth, buttonwidth, rounds));
            frame.revalidate();
            frame.repaint();
        });
        playButton.setPreferredSize(buttonSize);
        add(playButton, gbc);

        gbc.gridy = 2;
        JButton settingsButton = new JButton("IMPOSTAZIONI");
        settingsButton.addActionListener(e -> {
            frame.setContentPane(new SettingsPanel(frame, height, width));
            frame.revalidate();
            frame.repaint();
        });
        settingsButton.setPreferredSize(buttonSize);
        add(settingsButton, gbc);

        gbc.gridy = 3;
        JButton exitButton = new JButton("ESCI");
        exitButton.addActionListener(e -> System.exit(0));
        exitButton.setPreferredSize(buttonSize);
        add(exitButton, gbc);
    }
}
