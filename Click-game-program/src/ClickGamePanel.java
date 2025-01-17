import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClickGamePanel extends JPanel{
    private JButton clickButton;
    private JLabel tempo;
    private JLabel punti;
    private Random random;
    private int secondi;
    private int points;
    private int nonpoints;

    public ClickGamePanel (JFrame frame, int height, int width, int gameTime, int buttonheigth, int buttonwidth, int rounds) {

        setLayout(null); // mettiamo il layout null apposta per la generazione della posizione in modo che il pulsante non vada in posizioni indesiderate

        random = new Random();

        clickButton = new JButton("Click");

        clickButton.setBounds(width / 2 - 50, height / 2 - 50, buttonwidth, buttonheigth);

        secondi = gameTime-1; //il tempo finisce a zero quindi va calcolato un numero in meno qui ad esempio in timer e di 2 secondi

        JButton esci = new JButton("ESCI");
        esci.setBounds(width - width,0, 100, 30);
        add(esci);

        tempo = new JLabel("time: " + secondi);
        tempo.setBounds(width - (width - 100),0, 100, 30);
        add(tempo);

        points = 0;
        punti = new JLabel("punti: " + points);
        punti.setBounds(width - 70,0,100,30);
        add(punti);



        // Questo e il timer che permette al bottne di cambiare posizione quando scade simulando un limite di tempo
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                secondi--;
                tempo.setText("time: " + secondi);

                if (secondi <= 0) {
                    nonpoints++;
                    if((nonpoints + points) == rounds ) {
                        ((Timer) e.getSource()).stop();
                        if ((nonpoints + points) == rounds) {
                            ((Timer) e.getSource()).stop();
                            String[] options = {"Ricomincia", "Esci"};
                            int risultati = JOptionPane.showOptionDialog(
                                    frame,
                                    "Il tuo punteggio " + points + " su " + rounds,
                                    "Successo",
                                    JOptionPane.DEFAULT_OPTION,
                                    JOptionPane.WARNING_MESSAGE,
                                    null,
                                    options,
                                    options[0]
                            );

                            if (risultati == JOptionPane.YES_OPTION) {
                                frame.setContentPane(new ClickGamePanel(frame, height, width, gameTime, buttonheigth, buttonwidth, rounds));
                                frame.revalidate();
                                frame.repaint();
                            } else {
                                frame.setContentPane(new StartPanel(frame, height, width, gameTime, buttonheigth, buttonwidth, rounds));
                                frame.revalidate();
                                frame.repaint();
                            }

                        }
                    }
                    int randX = random.nextInt(width - 50);
                    int randY = random.nextInt(height - 50);
                    clickButton.setBounds(randX, randY, buttonwidth, buttonheigth);
                    secondi = gameTime; // utile per far ripartire il timer da dove vogliamo

                }
            }
        });

        //in questo listener andiamo a posizionare il pulsante in una posizione randomica
        clickButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                points++;
                if((nonpoints + points) == rounds ) {
                    timer.stop();

                        String[] options = {"Ricomincia", "Esci"};
                        int risultati = JOptionPane.showOptionDialog(
                                frame,
                                "Il tuo punteggio " + points + " su " + rounds,
                                "Successo",
                                JOptionPane.DEFAULT_OPTION,
                                JOptionPane.WARNING_MESSAGE,
                                null,
                                options,
                                options[0]
                        );

                        if (risultati == JOptionPane.YES_OPTION) {
                            frame.setContentPane(new ClickGamePanel(frame, height, width, gameTime, buttonheigth, buttonwidth, rounds));
                            frame.revalidate();
                            frame.repaint();
                        } else {
                            frame.setContentPane(new StartPanel(frame, height, width, gameTime, buttonheigth, buttonwidth, rounds));
                            frame.revalidate();
                            frame.repaint();
                        }

                    }

                punti.setText("punti: " + points); //semplice sistema di punti
                secondi = gameTime ;
                timer.start(); // con questa + il comando prima andiamo a reimpostare il timer al tempo predefinito
                int randX = random.nextInt(width - 50);
                int randY = random.nextInt(height - 50);

                clickButton.setBounds(randX, randY, buttonwidth, buttonheigth);
            }
        });
        esci.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.stop();
                frame.setContentPane(new StartPanel(frame, height, width, gameTime, buttonheigth, buttonwidth, rounds));
                frame.revalidate();
                frame.repaint();
            }
        });

        add(clickButton);
    }
}
