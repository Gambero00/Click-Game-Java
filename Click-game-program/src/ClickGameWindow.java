import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClickGameWindow {
    private JFrame frame;
    private Container c;
    private JPanel panel;
    private JButton clickButton;
    private JLabel tempo;
    private JLabel punti;
    private Random random;
    private int secondi;
    private int points;


    public ClickGameWindow () {

        frame = new JFrame("Click-game");
        c = frame.getContentPane();
        c.setLayout(null); // mettiamo il layout null apposta per la generazione della posizione in modo che il pulsante non vada in posizioni indesiderate

        random = new Random();

        clickButton = new JButton("Click");
        //polo superiore piu alto
        //clickButton.setBounds(0,0,100,50);
        //polo inferiore piu basso
        //clickButton.setBounds(700,513,100,50);

        clickButton.setBounds(350, 251, 100, 50);

        secondi = 2; //il tempo finisce a zero quindi va calcolato un numero in meno qui ad esempio in timer e di 2 secondi

        tempo = new JLabel("time: " + secondi);
        tempo.setBounds(0,0,100,30);
        c.add(tempo);

        points = 0;
        punti = new JLabel("punti: " + points);
        punti.setBounds(730,0,100,30);
        c.add(punti);



        // Questo e il timer che permette al bottne di cambiare posizione quando scade simulando un limite di tempo
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                secondi--;
                tempo.setText("time: " + secondi);

                if (secondi <= 0) {
                    int randX = random.nextInt(700);
                    int randY = random.nextInt(513);
                    clickButton.setBounds(randX, randY, 100, 50);
                    secondi = 3; // utile per far ripartire il timer da dove vogliamo

                }
            }
        });

            //in questo listener andiamo a posizionare il pulsante in una posizione randomica
        clickButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    points++;
                    punti.setText("punti: " + points); //semplice sistema di punti
                    secondi = 3;
                    timer.restart(); // con questa + il comando prima andiamo a reimpostare il timer al tempo predefinito
                    int randX = random.nextInt(700);
                    int randY = random.nextInt(513);

                    clickButton.setBounds(randX, randY, 100, 50);
                }
            });
        c.add(clickButton);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(800,600);
        frame.setVisible(true);
    }
    public static void main (String[] args) {
        new ClickGameWindow();
    }
}

