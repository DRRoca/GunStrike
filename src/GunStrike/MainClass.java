package GunStrike;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;

public class MainClass {
		public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame frame = new JFrame("Gun Strike");
					frame.setBackground(new Color(46,47,56));
					frame.getContentPane().setLayout(null);
					frame.setResizable(false);
					frame.add(new HomePanel());	
					frame.setBounds(100, 100, 1080, 720);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
