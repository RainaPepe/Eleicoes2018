package fibpong;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
public class GameFrame extends JFrame{
    private GamePanel gamePanel;
    public GameFrame(){
        gamePanel = new GamePanel();
        gamePanel.setBackground(Color.white);
        setLayout(new BorderLayout());
        add(gamePanel,BorderLayout.CENTER);
        setTitle("FIB PONG");
        setSize(1100,700);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        gamePanel.setFocusable(true);
        gamePanel.grabFocus();
        gamePanel.createPlayer();
        gamePanel.createPT();
        gamePanel.startTimer();
    }
}