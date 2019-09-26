package GunStrike;

import java.awt.Color;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HistoryPanel extends JPanel {

	private ReadData read;
	private String[][] data;
	private int lines;
	public HistoryPanel() {
		setBounds(0, 0, 1074, 691);
		setBackground(new Color(46,47,56));
		setLayout(null);
		
		JLabel lblTitle = new JLabel("");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setIcon(new ImageIcon(HistoryPanel.class.getResource("/image/title_history.png")));
		lblTitle.setBounds(333, 52, 408, 48);
		add(lblTitle);
		
		JButton btnBack = new JButton("");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeAll();
				add(new HomePanel());
				repaint();
			}
		});
		btnBack.setIcon(new ImageIcon(LeaderboardPanel.class.getResource("/image/icon_back.png")));
		btnBack.setBounds(39, 31, 91, 63);
		btnBack.setContentAreaFilled(false);
		btnBack.setBorderPainted(false);
		btnBack.setOpaque(false);
		add(btnBack);
		
		JLabel lblDate = new JLabel("DATE");
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate.setForeground(new Color(51, 204, 255));
		lblDate.setFont(new Font("Changa One", Font.PLAIN, 38));
		lblDate.setBounds(178, 169, 118, 51);
		add(lblDate);
		
		JLabel lblWinner = new JLabel("WINNER");
		lblWinner.setHorizontalAlignment(SwingConstants.CENTER);
		lblWinner.setForeground(new Color(51, 204, 255));
		lblWinner.setFont(new Font("Changa One", Font.PLAIN, 38));
		lblWinner.setBounds(752, 169, 169, 51);
		add(lblWinner);
		
		JLabel lblMatch = new JLabel("MATCH");
		lblMatch.setHorizontalAlignment(SwingConstants.CENTER);
		lblMatch.setForeground(new Color(51, 204, 255));
		lblMatch.setFont(new Font("Changa One", Font.PLAIN, 38));
		lblMatch.setBounds(478, 171, 118, 51);
		add(lblMatch);
		
		read = new ReadData();
		data = read.getData();
		lines = read.getRow();
		printHistory();

	}
	
	private void printHistory(){
		int lineNum = lines-1;
		for(int y=217, max=lineNum-10; lineNum > max; lineNum--, y+=34){
			if(lineNum<0)break;
			setDate(y,data[lineNum][1]);
			setMatch(y,data[lineNum][2],data[lineNum][3]);
			setWinner(y,data[lineNum][4]);
		}
	}
	
	private void setDate(int yPosition, String date){
		JLabel dateList = new JLabel(date);
		dateList.setHorizontalAlignment(SwingConstants.CENTER);
		dateList.setForeground(new Color(0, 255, 102));
		dateList.setFont(new Font("Changa One", Font.PLAIN, 27));
		dateList.setBounds(159, yPosition, 156, 30);
		add(dateList);
	}
	
	private void setMatch(int yPosition, String player1, String player2){
		JLabel matchList = new JLabel(player1 + " vs "+ player2);
		matchList.setHorizontalAlignment(SwingConstants.CENTER);
		matchList.setForeground(new Color(0, 255, 102));
		matchList.setFont(new Font("Changa One", Font.PLAIN, 27));
		matchList.setBounds(366, yPosition, 344, 30);
		add(matchList);
	}
	
	private void setWinner(int yPosition, String winner){
		JLabel winnerList = new JLabel(winner);
		winnerList.setHorizontalAlignment(SwingConstants.CENTER);
		winnerList.setForeground(new Color(0, 255, 102));
		winnerList.setFont(new Font("Changa One", Font.PLAIN, 27));
		winnerList.setBounds(742, yPosition, 192, 30);
		add(winnerList);
	}
}
