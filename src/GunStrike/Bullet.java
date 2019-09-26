package GunStrike;

public class Bullet extends Sprite {

	private int speed;

	public void setSpeed(int speed) {
		this.speed = speed;
	}


	public Bullet(int x, int y, int speed) {
		super(x, y);
		this.speed = speed;
		initBullet();
	}
	
	private void initBullet(){
		loadImage("/image/item_bullet.png");
	}
	
	public void move() {
		vis = true;
		x += speed;
		if(x > 1080 || x < 0) {
			vis = false;
		}
	}
}
