package GunStrike;

import java.awt.Color;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MechanicsPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public MechanicsPanel() {
		setBounds(0, 0, 1074, 691);
		setBackground(new Color(46,47,56));
		setLayout(null);
		
		JButton btnBack = new JButton();
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeAll();		
				add(new HomePanel());
				repaint();
			}
		});
		btnBack.setIcon(new ImageIcon(NameInputPanel.class.getResource("/image/icon_back.png")));
		btnBack.setBounds(39, 31, 91, 63);
		btnBack.setContentAreaFilled(false);
		btnBack.setBorderPainted(false);
		btnBack.setOpaque(false);
		add(btnBack);
		
		JLabel lblTitle = new JLabel();
		lblTitle.setBounds(376, 5, 322, 78);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setIcon(new ImageIcon(MechanicsPanel.class.getResource("/image/title_Mechanics.png")));
		add(lblTitle);
		
		JLabel lblInstruction = new JLabel("<html>The main objective of the game is to shoot the opponent to gain enough points during the duration of the game. And whoever the player gets the most points win. The player is limited only to move vertically means up and down movement only. The configurations are shown below.</html>");
		lblInstruction.setHorizontalAlignment(SwingConstants.CENTER);
		lblInstruction.setFont(new Font("Changa One", Font.PLAIN, 38));
		lblInstruction.setForeground(new Color(51, 204, 255));
		lblInstruction.setBounds(77, 145, 961, 255);
		add(lblInstruction);
		
		JLabel lblControl1 = new JLabel();
		lblControl1.setHorizontalAlignment(SwingConstants.CENTER);
		lblControl1.setIcon(new ImageIcon(MechanicsPanel.class.getResource("/image/icon_control1.png")));
		lblControl1.setBounds(148, 471, 277, 153);
		add(lblControl1);
		
		JLabel lblControl2 = new JLabel();
		lblControl2.setIcon(new ImageIcon(MechanicsPanel.class.getResource("/image/icon_control2.png")));
		lblControl2.setHorizontalAlignment(SwingConstants.CENTER);
		lblControl2.setBounds(644, 471, 277, 153);
		add(lblControl2);
	}
}
