package fibpong;

import javax.swing.*;
import java.awt.*;

public class Ball {


    private int x, y, radius;
    private int direcao;
    private int limiteAltura, limiteLargura;
    private float speed;
    private ImageIcon icone;


    public int getX(){
        return  x;
    }
    public int getY(){
        return  y;
    }

    public Ball(int tipo, int x, int y,int radius, int limiteAltura, int limiteLargura){
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.speed = 2.0f;
        this.direcao = 0;
        this.limiteAltura = limiteAltura;
        this.limiteLargura = limiteLargura;

        if(tipo == 1)
            this.icone = new ImageIcon(getClass().getResource("/images/faca.png"));
        else
            this.icone = new ImageIcon(getClass().getResource("/images/pt.png"));
    }

    //  _____
    //  |    |
    //  |    |
    //  |    |
    //  |    |
    //  |____|

    public boolean rebateu(int pX, int pY, int pAltura, int pLargura){
        boolean area = false;
        if(x>=pX && x<=pX+pLargura && y>=pY && y<= pY+pAltura)
            area = true;

        if(direcao==0 && area){
            direcao = 1;
            return true;
        }
        else if(direcao==3 && area){
            direcao = 2;
            return true;
        }
        return false;
    }

    private void verificarLimite(){
        if(direcao==0 && x<=0)
            direcao = 1;
        else if(direcao==0 && y<=0)
            direcao = 3;
        else if(direcao==1 && y<=0)
            direcao = 2;
        else if(direcao==1 && x>=limiteLargura)
            direcao = 0;
        else if(direcao==2 && x>=limiteLargura)
            direcao = 3;
        else if(direcao==2 && y>=limiteAltura)
            direcao = 1;
        else if(direcao==3 && y>=limiteAltura)
            direcao = 0;
        else if(direcao==3 && x<=0)
            direcao = 2;
    }

    public void move(){
        // 0  1
        // 3  2
        verificarLimite();

        if (direcao==0) {

            y -= speed;
            x -= speed;
        }
        else if (direcao==1) {
            y -= speed;
            x += speed;
        }
        else if (direcao==2) {
            y += speed;
            x += speed;
        }
        else if (direcao==3) {
            y += speed;
            x -= speed;
        }
    }
    public void draw(Graphics2D g2d){
        g2d.drawImage(icone.getImage(), x, y, radius, radius, null);
    }
}