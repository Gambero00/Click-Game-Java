import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class SettingsPanel extends JPanel {
    private JLabel titolo;
    int gametime;
    int buttonheight;
    int buttonwidth;
    int rounds;

    public SettingsPanel(JFrame frame, int height, int width) {
        Dimension titleSize = new Dimension(700, 100);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5); // Spaziatura tra i componenti

        // Titolo
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; // La larghezza del titolo occuperà due colonne
        titolo = new JLabel("Impostazioni");
        titolo.setPreferredSize(titleSize);
        titolo.setFont(titolo.getFont().deriveFont(Font.BOLD, 100));
        titolo.setHorizontalAlignment(SwingConstants.CENTER);
        add(titolo, gbc);


        gbc.gridwidth = 1;

        // Label e ComboBox per Difficoltà
        gbc.gridy = 1;
        gbc.gridx = 0;
        JLabel diffLabel = new JLabel("Difficoltà:");
        add(diffLabel, gbc);

        gbc.gridx = 1;
        String[] difficolta = {"Facile", "Media", "Difficile", "Personalizzata"};
        JComboBox<String> diffComboBox = new JComboBox<>(difficolta);
        add(diffComboBox, gbc);

        // Label e ComboBox per Grandezza
        gbc.gridy = 2;
        gbc.gridx = 0;
        JLabel grandezzaLabel = new JLabel("Grandezza:");
        add(grandezzaLabel, gbc);


        gbc.gridx = 1;
        String[] grandezza = {"Extreme", "Piccolo", "Medio", "Grande"};
        JComboBox<String> grandezzaComboBox = new JComboBox<>(grandezza);
        grandezzaComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(grandezzaComboBox.getSelectedItem() == "Extreme") {
                    buttonheight = 1;
                    buttonwidth = 1;
                }
                if(grandezzaComboBox.getSelectedItem() == "Piccolo") {
                    buttonheight = 1;
                    buttonwidth = 1;
                }
                if(grandezzaComboBox.getSelectedItem() == "Medio") {
                    buttonheight = 100;
                    buttonwidth = 50;
                }
                if(grandezzaComboBox.getSelectedItem() == "Grande") {
                    buttonheight = 200;
                    buttonwidth = 100;
                }
            }
        });
        add(grandezzaComboBox, gbc);


        // Label e ComboBox per Tempo
        gbc.gridy = 3;
        gbc.gridx = 0;
        JLabel tempoLabel = new JLabel("Tempo per round:");
        add(tempoLabel, gbc);

            gbc.gridx = 1;

                String[]tempo = {"1 s", "2 s", "3 s", "4 s"};
        JComboBox<String> tempoComboBox = new JComboBox<>(tempo);
        tempoComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tempoComboBox.getSelectedItem() == "1 s") {
                    gametime = 2;
                }
                if (tempoComboBox.getSelectedItem() == "2 s") {
                    gametime = 3;
                }
                if (tempoComboBox.getSelectedItem() == "3 s") {
                    gametime = 4;
                }
                if (tempoComboBox.getSelectedItem() == "4 s") {
                    gametime = 5;
                }
            }
        });


            add(tempoComboBox, gbc);

        // Label e ComboBox per Numero di Round
        gbc.gridy = 4;
        gbc.gridx = 0;
        JLabel roundLabel = new JLabel("Numero di round:");
        add(roundLabel, gbc);

        gbc.gridx = 1;
        String[] round = {"5", "10", "20", "50"};
        JComboBox<String> roundComboBox = new JComboBox<>(round);

        if(grandezzaComboBox.getSelectedItem() == "5") {
            rounds = 5;
        }
        if(grandezzaComboBox.getSelectedItem() == "10") {
            rounds = 10;
        }
        if(grandezzaComboBox.getSelectedItem() == "20") {
            rounds = 20;
        }
        if(grandezzaComboBox.getSelectedItem() == "50") {
            rounds = 50;
        }

        add(roundComboBox, gbc);


        gbc.gridy = 5;
        JButton esci = new JButton("ESCI");
        add(esci, gbc);
        esci.addActionListener(e -> {
            frame.setContentPane(new StartPanel(frame, height, width, gametime, buttonwidth, buttonheight, rounds));
            frame.revalidate();
            frame.repaint();
        });

    }
}