package GunStrike;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class CountDownPanel extends JPanel implements ActionListener{
	
	private Timer timer;
	private int sec3 = 3;
	private String name1,name2;
	
	public CountDownPanel(String name1,String name2){
		this.name1 = name1;
		this.name2 = name2;
		initPanel();
		timer = new Timer(1000, this);
		timer.start();
	}
	
	public CountDownPanel(String name1){
		this.name1 = name1;
		initPanel();
		timer = new Timer(1000, this);
		timer.start();
	}
	
	private void initPanel(){
		this.setFocusable(true);
		this.requestFocusInWindow();
		this.setBounds(0, 0, 1074, 691);
		this.setBackground(new Color(81,126,168));
		this.setLayout(null);
	}
	public void actionPerformed(ActionEvent arg0) {
		repaint();
		sec3--;
		if(sec3==0){
			if(name2 != null){
				removeAll();
				add(new BoardPanel(this.name1, this.name2));
				repaint();
			}	
			else{
				removeAll();
				add(new BoardPanel(this.name1));
				repaint();
			}
		}
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.setColor(new Color(0, 0, 0, 0.35f));
		g.fillRect(0, 0, 1080, 720);
		
		g.setColor(new Color(242, 242, 242));
		g.setFont(new Font("Changa One", Font.PLAIN, 100));
		g.drawString("Game begins in", 190, 250);
		g.setFont(new Font("Changa One", Font.PLAIN, 200));
		g.drawString(Integer.toString(sec3), 480, 430);
	}
}