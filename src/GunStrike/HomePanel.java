package GunStrike;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class HomePanel extends JPanel{
	
	
	public HomePanel() {
		setBounds(0, 0, 1074, 691);
		setBackground(new Color(46,47,56));
		
		JLabel lblHomeTitle = new JLabel("");
		lblHomeTitle.setBounds(116, 5, 842, 151);
		lblHomeTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblHomeTitle.setVerticalAlignment(SwingConstants.TOP);
		lblHomeTitle.setIcon(new ImageIcon(HomePanel.class.getResource("/image/tiltle.png")));
		
		JLabel lblHistory = new JLabel("");
		lblHistory.setBounds(67, 429, 200, 157);
		lblHistory.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHistory.setIcon(new ImageIcon(HomePanel.class.getResource("/image/icon_history.png")));
		
		JLabel lblMechanics = new JLabel("");
		lblMechanics.setBounds(467, 455, 140, 131);
		lblMechanics.setIcon(new ImageIcon(HomePanel.class.getResource("/image/icon_mechanics.png")));
		
		JLabel lblLeaderboards = new JLabel("");
		lblLeaderboards.setBounds(821, 429, 167, 146);
		lblLeaderboards.setIcon(new ImageIcon(HomePanel.class.getResource("/image/icon_leaderboards.png")));
		
		JButton btnVsCpu = new JButton("Player vs CPU");
		btnVsCpu.setBounds(409, 297, 255, 47);
		btnVsCpu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				removeAll();
				add(new NameInputPanel());
				repaint();
			}
		});		
		btnVsCpu.setForeground(new Color(70, 130, 180));
		btnVsCpu.setFont(new Font("Changa One", Font.PLAIN, 35));
		btnVsCpu.setOpaque(false);
		btnVsCpu.setBorderPainted(false);
		btnVsCpu.setContentAreaFilled(false);
		
		JButton btnHeadToHead = new JButton("Head to Head");
		btnHeadToHead.setBounds(408, 251, 257, 47);
		btnHeadToHead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				removeAll();
				add(new NameInputPanel2Player());
				repaint();
			}
		});
		btnHeadToHead.setOpaque(false);
		btnHeadToHead.setForeground(new Color(70, 130, 180));
		btnHeadToHead.setFont(new Font("Changa One", Font.PLAIN, 35));
		btnHeadToHead.setContentAreaFilled(false);
		btnHeadToHead.setBorderPainted(false);
		
		JButton btnHistory = new JButton("History");
		btnHistory.setBounds(77, 589, 190, 47);
		btnHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeAll();
				add(new HistoryPanel());
				repaint();
			}
		});
		btnHistory.setOpaque(false);
		btnHistory.setForeground(new Color(0, 255, 102));
		btnHistory.setFont(new Font("Changa One", Font.PLAIN, 35));
		btnHistory.setContentAreaFilled(false);
		btnHistory.setBorderPainted(false);
		
		JButton btnMechanics = new JButton("Mechanics");
		btnMechanics.setBounds(416, 589, 241, 47);
		btnMechanics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeAll();
				add(new MechanicsPanel());
				repaint();
			}
		});
		btnMechanics.setOpaque(false);
		btnMechanics.setForeground(new Color(0, 255, 102));
		btnMechanics.setFont(new Font("Changa One", Font.PLAIN, 35));
		btnMechanics.setContentAreaFilled(false);
		btnMechanics.setBorderPainted(false);
		
		JButton btnLeaderboards = new JButton("Leaderboards");
		btnLeaderboards.setBounds(767, 589, 267, 47);
		btnLeaderboards.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeAll();
				add(new LeaderboardPanel());
				repaint();
			}
		});
		btnLeaderboards.setOpaque(false);
		btnLeaderboards.setForeground(new Color(0, 255, 102));
		btnLeaderboards.setFont(new Font("Changa One", Font.PLAIN, 35));
		btnLeaderboards.setContentAreaFilled(false);
		btnLeaderboards.setBorderPainted(false);
		setLayout(null);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setOpaque(false);
		btnExit.setForeground(new Color(204, 102, 0));
		btnExit.setFont(new Font("Changa One", Font.PLAIN, 35));
		btnExit.setContentAreaFilled(false);
		btnExit.setBorderPainted(false);
		btnExit.setBounds(416, 355, 241, 47);
		
		add(lblHomeTitle);
		add(lblHistory);
		add(lblMechanics);
		add(lblLeaderboards);
		add(btnVsCpu);
		add(btnHeadToHead);
		add(btnHistory);
		add(btnMechanics);
		add(btnLeaderboards);
		add(btnExit);
		
	}
	
}