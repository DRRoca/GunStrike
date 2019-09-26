package GunStrike;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class NameInputPanel2Player extends JPanel{
private JTextField textFieldName1;
private JTextField textFieldName2;

	
	public NameInputPanel2Player() {
		setBounds(0, 0, 1074, 691);
		setBackground(new Color(46,47,56));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(NameInputPanel2Player.class.getResource("/image/Title_NameInput_Player2.png")));
		lblNewLabel.setBounds(238, 23, 598, 85);
		add(lblNewLabel);
		
		JButton btnBack = new JButton("");
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
		
		Border border = BorderFactory.createLineBorder(new Color(115, 116, 143),10);
		
		textFieldName1 = new JTextField();
		textFieldName1.setToolTipText("Player 1");
		textFieldName1.setForeground(new Color(51, 204, 255));
		textFieldName1.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldName1.setBackground(new Color(46,47,56));
		textFieldName1.setFont(new Font("Changa One", Font.ITALIC, 47));
		textFieldName1.setBounds(392, 183, 414, 75);
		textFieldName1.setBorder(border);
		add(textFieldName1);
		textFieldName1.setColumns(10);
		
		textFieldName2 = new JTextField();
		textFieldName2.setToolTipText("Player 2");
		textFieldName2.setForeground(new Color(51, 204, 255));
		textFieldName2.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldName2.setBackground(new Color(46,47,56));
		textFieldName2.setFont(new Font("Changa One", Font.ITALIC, 47));
		textFieldName2.setColumns(10);
		textFieldName2.setBounds(392, 296, 414, 75);
		textFieldName2.setBorder(border);
		add(textFieldName2);
		
		JButton btnOK = new JButton("");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name1 = textFieldName1.getText();
				String name2 = textFieldName2.getText();
				if(!name2.equals("CPU") && name1.length()>2 && name2.length()>2){
					removeAll();
					add(new CountDownPanel(name1,name2));
					repaint();
				}
			}
		});
		btnOK.setIcon(new ImageIcon(NameInputPanel.class.getResource("/image/icon_button_OK.png")));
		btnOK.setBounds(445, 450, 183, 92);
		btnOK.setContentAreaFilled(false);
		btnOK.setBorderPainted(false);
		btnOK.setOpaque(false);
		add(btnOK);
		
		JLabel lblTextField1 = new JLabel("Player 1");
		lblTextField1.setForeground(new Color(51, 204, 255));
		lblTextField1.setFont(new Font("Changa One", Font.PLAIN, 30));
		lblTextField1.setHorizontalAlignment(SwingConstants.LEFT);
		lblTextField1.setBounds(260, 183, 122, 33);
		add(lblTextField1);
		
		JLabel lblPlayer = new JLabel("Player 2");
		lblPlayer.setHorizontalAlignment(SwingConstants.LEFT);
		lblPlayer.setForeground(new Color(51, 204, 255));
		lblPlayer.setFont(new Font("Changa One", Font.PLAIN, 30));
		lblPlayer.setBounds(260, 296, 122, 40);
		add(lblPlayer);
		
	}
}
