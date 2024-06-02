import javax.swing.*;
import java.awt.*;
public class ClickGameWindow {
    private JFrame frame;
    private Container c;
    private JPanel panel;
    private JButton clickButton;


    public ClickGameWindow () {

        frame = new JFrame("Click-game");
        c = new Container();
        c = frame.getContentPane();
        c.setLayout(null); // mettiamo il layout null apposta per la generazione della posizione in modo che il pulsante non vada in posizioni indesiderate


        clickButton = new JButton("Click");
        //polo superiore piu alto
        //clickButton.setBounds(0,0,100,50);
        //polo inferiore piu basso
        //clickButton.setBounds(700,513,100,50);
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

