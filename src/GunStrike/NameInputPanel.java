package GunStrike;

import java.awt.Color;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.border.Border;

import java.awt.Font;
import javax.swing.SwingConstants;

public class NameInputPanel extends JPanel {
	private JTextField textFieldName;

	
	public NameInputPanel() {
		setBounds(0, 0, 1074, 691);
		setBackground(new Color(46,47,56));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(NameInputPanel.class.getResource("/image/Title_NameInput.png")));
		lblNewLabel.setBounds(194, 23, 685, 85);
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
		
		textFieldName = new JTextField();
		textFieldName.setForeground(new Color(51, 204, 255));
		textFieldName.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldName.setFont(new Font("Changa One", Font.PLAIN, 47));
		textFieldName.setBounds(319, 200, 435, 92);
		textFieldName.setBackground(new Color(46,47,56));
		textFieldName.setBorder(border);
		add(textFieldName);
		textFieldName.setColumns(10);
		
		JButton btnOK = new JButton("");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textFieldName.getText();
				if(name.length()>2){
					removeAll();
					add(new CountDownPanel(name));
					repaint();
				}
			}
		});
		btnOK.setIcon(new ImageIcon(NameInputPanel.class.getResource("/image/icon_button_OK.png")));
		btnOK.setBounds(445, 328, 183, 92);
		btnOK.setContentAreaFilled(false);
		btnOK.setBorderPainted(false);
		btnOK.setOpaque(false);
		add(btnOK);
	}
}
