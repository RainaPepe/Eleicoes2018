package fibpong;
import javax.swing.*;
import java.awt.Graphics2D;
public class Player {
    private int x, y, width, height;
    private float speed;
    private boolean up, down;
    private ImageIcon bolso = new ImageIcon(getClass().getResource("/images/bolsonaro.png"));
    public Player(int x, int y){
        width = 60;
        height = 100;
        this.x = x;        
        this.y = y - height/2;
        speed = 2.0f;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }
    public void draw(Graphics2D g2d){
        g2d.drawImage(bolso.getImage(), x, y, width, height, null);
    }
    public void moveUp(){
        up = true;
    }
    public void moveDown(){
        down = true;
    }
    public void move(){
        if (up)
            y-=speed;
        else if (down)
            y+=speed;
    }
    public void stop(){
        up = false;
        down = false;
    }
}