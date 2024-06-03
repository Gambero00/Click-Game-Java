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
    private Random random;
    private int secondi;


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

        // Questo e il timer che permette al bottne di cambiare posizione quando scade simulando un limite di tempo
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                secondi--;
                System.out.println("Tempo rimanente: " + secondi+ " secondi"); // temporanee per monitorare il tempo
                if (secondi <= 0) {
                    int randX = random.nextInt(700);
                    int randY = random.nextInt(513);

                    clickButton.setBounds(randX, randY, 100, 50);

                    ((Timer) e.getSource()).stop();

                    System.out.println("GAME OVER!"); // temporanee per monitorare il tempo  
                    secondi = 2; // utile per far ripartire il timer da dove vogliamo
                    ((Timer) e.getSource()).start();

                }
            }
        });

            //in questo listener andiamo a posizionare il pulsante in una posizione randomica
        clickButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    secondi = 2;
                    timer.start(); // con questa + il comando prima andiamo a reimpostare il timer al tempo predefinito
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

