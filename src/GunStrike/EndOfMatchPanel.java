package GunStrike;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EndOfMatchPanel extends JPanel {
		;
	public EndOfMatchPanel(String name1, String name2, String winner, int score) {
		//BoardPanel newBoard = new BoardPanel(name1, name2);
		setBorder(new MatteBorder(7, 7, 7, 7, (Color) new Color(132, 191, 246)));
		setBackground(new Color(50, 51, 35));
		setBounds(0, 0, 1074, 691);
		setLayout(null);
		
		JLabel lblWinnerName = new JLabel( winner + " Wins");
		lblWinnerName.setForeground(Color.WHITE);
		lblWinnerName.setHorizontalAlignment(SwingConstants.CENTER);
		lblWinnerName.setFont(new Font("Changa One", Font.PLAIN, 87));
		lblWinnerName.setBounds(144, 117, 785, 86);
		add(lblWinnerName);
		
		JLabel lblScore = new JLabel(Integer.toString(score));
		lblScore.setForeground(Color.WHITE);
		lblScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblScore.setFont(new Font("Changa One", Font.PLAIN, 120));
		lblScore.setBounds(421, 267, 232, 127);
		add(lblScore);
		
		JButton btnMenu = new JButton("Menu");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeAll();
				add(new HomePanel());
				repaint();
			}
		});
		btnMenu.setForeground(Color.WHITE);
		btnMenu.setFont(new Font("Changa One", Font.PLAIN, 42));
		btnMenu.setBounds(30, 576, 220, 72);
		btnMenu.setOpaque(false);
		btnMenu.setBorderPainted(false);
		btnMenu.setContentAreaFilled(false);
		
		
		JButton btnReplay = new JButton("Replay");
		btnReplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeAll();
				if(name2.equals("CPU")){
					add(new CountDownPanel(name1));
				}
				else add(new CountDownPanel(name1, name2));
				repaint();
			}
		});
		btnReplay.setIcon(new ImageIcon(EndOfMatchPanel.class.getResource("/image/icon_replay.png")));
		btnReplay.setOpaque(false);
		btnReplay.setForeground(Color.WHITE);
		btnReplay.setFont(new Font("Changa One", Font.PLAIN, 42));
		btnReplay.setContentAreaFilled(false);
		btnReplay.setBorderPainted(false);
		btnReplay.setBounds(781, 576, 250, 72);
		
		add(btnReplay);
		add(btnMenu);
		
	}
}
