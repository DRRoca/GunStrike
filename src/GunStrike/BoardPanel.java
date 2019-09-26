package GunStrike;

import java.awt.Color;

import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.Timer;

import javax.swing.*;
import java.awt.*;
import javax.swing.SwingConstants;
import javax.swing.AbstractAction;


public class BoardPanel extends JPanel implements ActionListener{
	
	private static final int IFW = JComponent.WHEN_IN_FOCUSED_WINDOW;
	static GetCurrentDateTime date = new GetCurrentDateTime();;
	private int score1 = 0, score2 = 0, highScore ;
	Player p1,p2;
	Bullet b1,b2;
	private Timer timer, shootTimer, moveUpTimer1, moveDownTimer1;
	private String name1, name2, winner;
	TimerClass mins2;
	
	private final int DELAY = 10;
	
	public BoardPanel(String name1) {
		mins2 = new TimerClass(60);
		setName1(name1);
		setName2("CPU");
		p1 = new Player("/image/item_player1.png");
		p2 = new Player("/image/item_player2.png");
		
		this.setFocusable(true);
		this.requestFocusInWindow();
		this.setBounds(0, 0, 1074, 691);
		this.setBackground(new Color(81,126,168));
		this.setLayout(null);
		
		this.getInputMap(IFW).put(KeyStroke.getKeyStroke("W"), "u1");
		this.getInputMap(IFW).put(KeyStroke.getKeyStroke("S"), "d1");
		this.getInputMap(IFW).put(KeyStroke.getKeyStroke("D"), "s1");


		this.getActionMap().put("u1", new MoveAction1(-150));
		this.getActionMap().put("d1", new MoveAction1(150));
		this.getActionMap().put("s1", new ShootAction1(6));
		
		shootTimer = new Timer(200, new ShootAction2(-6));
		moveUpTimer1 = new Timer(500, new MoveActionAI(-150));
		moveDownTimer1 = new Timer(500, new MoveActionAI(150));
		
		JLabel lblName1 = new JLabel(name1);
		lblName1.setHorizontalAlignment(SwingConstants.LEFT);
		lblName1.setFont(new Font("Changa One", Font.PLAIN, 39));
		lblName1.setBounds(152, 11, 272, 78);
		add(lblName1);
		lblName1.setFocusable(false);
		
		JLabel lblName2 = new JLabel(name2);
		lblName2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName2.setFont(new Font("Changa One", Font.PLAIN, 39));
		lblName2.setBounds(643, 11, 272, 78);
		add(lblName2);
		lblName2.setFocusable(false);
		
		printLine();
		timer = new Timer(DELAY, this);
		
		
		shootTimer.start();
		moveDownTimer1.start();
        timer.start();
	}
	
	public BoardPanel(String name1, String name2) {
		mins2 = new TimerClass(60);
		setName1(name1);
		setName2(name2);
		p1 = new Player("/image/item_player1.png");
		p2 = new Player("/image/item_player2.png");
		
		this.setFocusable(true);
		this.requestFocusInWindow();
		this.setBounds(0, 0, 1074, 691);
		this.setBackground(new Color(81,126,168));
		this.setLayout(null);
		
		this.getInputMap(IFW).put(KeyStroke.getKeyStroke("W"), "u1");
		this.getInputMap(IFW).put(KeyStroke.getKeyStroke("S"), "d1");
		this.getInputMap(IFW).put(KeyStroke.getKeyStroke("D"), "s1");
		this.getInputMap(IFW).put(KeyStroke.getKeyStroke("UP"), "u2");
		this.getInputMap(IFW).put(KeyStroke.getKeyStroke("DOWN"), "d2");
		this.getInputMap(IFW).put(KeyStroke.getKeyStroke("LEFT"), "s2");
		
		this.getActionMap().put("u1", new MoveAction1(-150));
		this.getActionMap().put("d1", new MoveAction1(150));
		this.getActionMap().put("s1", new ShootAction1(6));
		this.getActionMap().put("u2", new MoveAction2(-150));
		this.getActionMap().put("d2", new MoveAction2(150));
		this.getActionMap().put("s2", new ShootAction2(-6));
		
		
		JLabel lblName1 = new JLabel(name1);
		lblName1.setHorizontalAlignment(SwingConstants.LEFT);
		lblName1.setFont(new Font("Changa One", Font.PLAIN, 39));
		lblName1.setBounds(152, 11, 272, 78);
		add(lblName1);
		lblName1.setFocusable(false);
		
		JLabel lblName2 = new JLabel(name2);
		lblName2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName2.setFont(new Font("Changa One", Font.PLAIN, 39));
		lblName2.setBounds(643, 11, 272, 78);
		add(lblName2);
		lblName2.setFocusable(false);
		
		printLine();
		
		timer = new Timer(DELAY, this);
        timer.start();
	}
	
	public void actionPerformed(ActionEvent e){
		if(!mins2.isEnd()){
			setWinner();
			updateBullets1();
			updateBullets2();
			checkCollision1();
			checkCollision2();
			repaint();
		}
		else endGame();
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		g.setColor(new Color(0, 255, 102));
		g.setFont(new Font("Changa One", Font.PLAIN, 50));
		g.drawString(mins2.getTime(), 500, 48);
		g.setFont(new Font("Changa One", Font.PLAIN, 70));
		g.drawString(Integer.toString(score1), 60, 70);
		g.drawString(Integer.toString(score2), 930, 70);

		g2d.drawImage(p1.getImage(), 80, p1.getY(), this);
		g2d.drawImage(p2.getImage(), 900, p2.getY(), this);
		
		ArrayList<Bullet> bs = p1.getBullets();

        for (Object b1 : bs) {
            Bullet b = (Bullet) b1;
            g2d.drawImage(b.getImage(), b.getX(),
                    b.getY(), this);
        }
        
		ArrayList<Bullet> bs1 = p2.getBullets();

        for (Object b1 : bs1) {
            Bullet b = (Bullet) b1;
            g2d.drawImage(b.getImage(), b.getX(),
                    b.getY(), this);
        }
	}
	
    private void updateBullets1() {

        ArrayList<Bullet> bs = p1.getBullets();

        for (int i = 0; i < bs.size(); i++) {

            Bullet b = (Bullet) bs.get(i);

            if (b.isVisible()) {

                b.move();
            } else {

                bs.remove(i);
            }
        }
    }
    
    private void updateBullets2() {

        ArrayList<Bullet> bs = p2.getBullets();

        for (int i = 0; i < bs.size(); i++) {

            Bullet b = (Bullet) bs.get(i);

            if (b.isVisible()) {

                b.move();
            } else {

                bs.remove(i);
            }
        }
    }
    
    public void checkCollision1(){
    	ArrayList<Bullet> bs = p1.getBullets();
    	int p2y = p2.getY()+13;
    	int p2x = 900;
    	for (Object b1 : bs) {
            Bullet b = (Bullet) b1;
            if(b.getY() == p2y && b.getX() >= p2x && b.getX() <= p2x + 7){
            	b.setVisible(false);
            	score1++;
            }
        }
    	
    }
    
    public void checkCollision2(){
    	ArrayList<Bullet> bs = p2.getBullets();
    	int p1y = p1.getY()+13;
    	int p1x = 155;
    	for (Object b1 : bs) {
            Bullet b = (Bullet) b1;
            if(b.getY() == p1y && b.getX() >= p1x-2 && b.getX() <= p1x + 3){
            	b.setVisible(false);
            	score2++;
            	
            }
        }
    	
    }

	private void printLine(){
		for(int y = 650; y>=200; y-=150){
			setLine(10,y);
			setLine(860,y);
		}
	}
	
	private void setLine(int xPosition, int yPosition){
		JLabel lblLine = new JLabel();
		lblLine.setHorizontalAlignment(SwingConstants.CENTER);
		lblLine.setIcon(new ImageIcon(BoardPanel.class.getResource("/image/item_line.png")));
		lblLine.setBounds(xPosition, yPosition, 204, 14);
		add(lblLine);
	}

	public void setName1(String name1) {
		this.name1 = name1;
	}

	public void setName2(String name2) {
		this.name2 = name2;
	}
	
	private void endGame(){
		timer.stop();
		if(!name2.equals("CPU")){		
			WriteData save = new WriteData(date.getDate(), name1, name2, winner);
		}
		removeAll();
		add(new EndOfMatchPanel(name1, name2, winner, highScore));
		repaint();
	}
	
	private void setWinner(){
		if(score1 > score2){
			this.highScore = score1;
			this.winner = this.name1;
		}
		else{
			this.highScore = score2;
			this.winner = this.name2;
		}
	}

	private class MoveAction1 extends AbstractAction {
		int dy;
		public MoveAction1(int dy){
			this.dy=dy;
		}
		public void actionPerformed(ActionEvent e) {
			p1.setDy(this.dy);
			p1.move();
		}
	}
	
	public class MoveAction2 extends AbstractAction {
		int dy;
		public MoveAction2(int dy){
			this.dy=dy;
		}
		public void actionPerformed(ActionEvent e) {
			p2.setDy(this.dy);
			p2.move();
		}
	}
	
	public class MoveActionAI extends AbstractAction {
		int dy;
		public MoveActionAI(int dy){
				this.dy=dy;
		}
		public void actionPerformed(ActionEvent e) {
			p2.setDy(this.dy);
			if((p2.getY()+150)>=510){
				moveDownTimer1.stop();
				moveUpTimer1.start();
			}
			
			else if((p2.getY()-150)<=60){
				moveUpTimer1.stop();
				moveDownTimer1.start();
			}
			p2.move();
		}
	}
	
	private class ShootAction1 extends AbstractAction {
		int speed;
		public ShootAction1(int speed){
			this.speed=speed;

	}
		public void actionPerformed(ActionEvent e) {
			p1.fire(speed, 155);
		}
	}
	
	public class ShootAction2 extends AbstractAction {
		int speed;
		public ShootAction2(int speed){
			this.speed=speed;

	}
		public void actionPerformed(ActionEvent e) {
			p2.fire(speed, 900);
		}
		

	}
}
