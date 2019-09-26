package GunStrike;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;


public class Player{
	private int y, dy;
	private ArrayList<Bullet> bullets;
	
	Image player;
	
	public Player(String imgDir){
		ImageIcon i = new ImageIcon(Player.class.getResource(imgDir));
		player = i.getImage();
		y = 360;
		bullets = new ArrayList<Bullet>();
	}
	
	public void move(){
		if((y+dy)>=60 && (y+dy)<=510){	
			y += dy;
		}
	}
	
    public void fire(int speed, int x) {
        bullets.add(new Bullet(x, y+13, speed));
    }
    
    public ArrayList<Bullet> getBullets() {
        return bullets;
    }
	
	public void setDy(int dy) {
		this.dy = dy;
	}

	public int getY(){
		return y;
	}
	
	public Image getImage(){
		return player;
	}
}