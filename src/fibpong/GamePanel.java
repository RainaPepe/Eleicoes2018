package fibpong;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.TimerTask;
import javax.swing.*;


public class GamePanel extends JPanel implements KeyListener, ActionListener{
    private Player player;
    private Ball pt;
    private ArrayList<Ball> facas;
    private int countFaca;
    private Timer timer;
    private boolean gameover;
    private int pontos, vidas;

    ImageIcon fundo = new ImageIcon(getClass().getResource("/images/fundo.jpg"));
    ImageIcon imgGameOver = new ImageIcon(getClass().getResource("/images/gameover1.png"));

    public GamePanel(){
        gameover = false;
        pontos = 0;
        countFaca = 0;
        facas = new ArrayList<Ball>();
        vidas = 3;
        addKeyListener(this);
    }


    public void createPlayer(){
        player = new Player(100,getHeight()/2);
    }
    public void createPT(){
        pt = new Ball(2,600,getHeight()/2,50, getHeight(), getWidth());
    }
    public void createFaca(){
        facas.add(new Ball(1,600,getHeight()/2,50, getHeight(), getWidth()));
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setFont(new Font("Ariel", Font.PLAIN, 20));

        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.GREEN);
        g2d.fillRect(0,0,10, getHeight());
        g2d.setColor(Color.YELLOW);
        g2d.fillRect(10,0,10, getHeight());
        g2d.setColor(Color.BLUE);
        g2d.fillRect(20,0,10, getHeight());
        g2d.setColor(Color.BLACK);
        g2d.drawString("Pontos: " + pontos, getWidth() - 200,  getHeight()-100);
        g2d.drawString("Vidas: " + vidas, 150,  20);

        if(gameover)
            g2d.drawImage(imgGameOver.getImage(),(getWidth()/2 )- 100,(getHeight()/2)-100, 200, 200, null);

        player.draw(g2d);
        pt.draw(g2d);
        for (Ball faca : facas) {
            faca.draw(g2d);
        }
    }
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP)
            player.moveUp();
        if (e.getKeyCode() == KeyEvent.VK_DOWN)
            player.moveDown();
    }
    @Override
    public void keyReleased(KeyEvent e) {
        player.stop();
    }
    @Override
    public void keyTyped(KeyEvent e) {    
    }
    public void startTimer(){
        timer = new Timer(10,this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(pt.rebateu(player.getX(), player.getY(),player.getHeight(),player.getWidth())){
            pontos++;
            if(countFaca == 2){
                createFaca();
                countFaca = 0;
            }
            else
                countFaca++;
        }
        boolean remove = false;
        Ball removed = null;
        for (Ball faca : facas) {

            if(faca.rebateu(player.getX(), player.getY(),player.getHeight(),player.getWidth())){
                vidas--;
                remove = true;
                removed = faca;
                if(vidas==0){
                    timer.stop();
                    gameover = true;
                }
            }
            else
                faca.move();
        }

        if(remove)
            facas.remove(removed);

        if(pt.getX()<=0){
            timer.stop();
            gameover = true;
        }
        else{
            player.move();
            pt.move();
        }

        repaint();
    }
}