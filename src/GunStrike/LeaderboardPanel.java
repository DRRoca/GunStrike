package GunStrike;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import java.awt.Font;


public class LeaderboardPanel extends JPanel {
	
	private ReadData read;
	private String[][] data;
	private int lines;
	private String winner[] = new String[25];
	private int winCount[] = new int[25];
	//private String winnerFinal[]
	
	public LeaderboardPanel() {
		
		setBounds(0, 0, 1074, 691);
		setBackground(new Color(46,47,56));
		setLayout(null);
		
		JLabel lblTitle = new JLabel();
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setIcon(new ImageIcon(LeaderboardPanel.class.getResource("/image/title_leaderboards.png")));
		lblTitle.setBounds(309, 51, 455, 63);
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
		
		JLabel lblRankTitle = new JLabel("RANK");
		lblRankTitle.setFont(new Font("Changa One", Font.PLAIN, 38));
		lblRankTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblRankTitle.setForeground(new Color(51, 204, 255));
		lblRankTitle.setBounds(195, 164, 175, 51);
		add(lblRankTitle);
		
		JLabel lblNameTitle = new JLabel("NAME");
		lblNameTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblNameTitle.setForeground(new Color(51, 204, 255));
		lblNameTitle.setFont(new Font("Changa One", Font.PLAIN, 38));
		lblNameTitle.setBounds(449, 164, 175, 51);
		add(lblNameTitle);
		
		JLabel lblWinsTitle = new JLabel("WINS");
		lblWinsTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblWinsTitle.setForeground(new Color(51, 204, 255));
		lblWinsTitle.setFont(new Font("Changa One", Font.PLAIN, 38));
		lblWinsTitle.setBounds(694, 164, 175, 51);
		add(lblWinsTitle);
		
		read = new ReadData();
		data = read.getData();
		lines = read.getRow();  
		setWinner();
		printLeaderboards();
	}
	
	private void setWinner(){
		int winnerIndex = 0;
		for(int currentLine=0; currentLine<lines; currentLine++){
			for(int j=0; j<lines; j++){
				
				if(data[currentLine][4].equals(data[j][4])){
					if(notRepeated(winnerIndex, data[currentLine][4])){
						winner[winnerIndex] = data[currentLine][4];
						winCount[winnerIndex]++;
						winnerIndex++;
						
					}
					
					break;
				}
			}	
		}
		sortWinner();
	}
	
	private boolean notRepeated(int index, String name){
		for(int currentIndex = 0; currentIndex<index; currentIndex++){
				if(winner[currentIndex].equals(name)){
					winCount[currentIndex]++;
					return false;
				}
		}
		return true;
	}
	
	private void sortWinner(){
		int countTemp;
		String nameTemp;
		for(int j=0; j<winCount.length;j++){
			for(int i=0; i<winCount.length;i++){
				if(winCount[j]>winCount[i]){
					countTemp = winCount[j];
					winCount[j] = winCount[i];
					winCount[i] = countTemp;
					nameTemp = winner[j];
					winner[j] = winner[i];
					winner[i] = nameTemp;
				}
			}
		}
	}
	
	private void printLeaderboards(){
		for(int y=217, line=0; line<10; line++, y+=34){
			if(winner[line] == null)break;
				setRank(y,Integer.toString(line+1));
				setName(y,winner[line]);
				setWins(y,Integer.toString(winCount[line]));
		}
	}
	
	private void setRank(int yPosition, String date){
		JLabel rankList = new JLabel(date);
		rankList.setHorizontalAlignment(SwingConstants.CENTER);
		rankList.setForeground(new Color(0, 255, 102));
		rankList.setFont(new Font("Changa One", Font.PLAIN, 27));
		rankList.setBounds(204, yPosition, 156, 30);
		add(rankList);
	}
	
	private void setName(int yPosition, String player1){
		JLabel nameList = new JLabel(player1);
		nameList.setHorizontalAlignment(SwingConstants.CENTER);
		nameList.setForeground(new Color(0, 255, 102));
		nameList.setFont(new Font("Changa One", Font.PLAIN, 27));
		nameList.setBounds(366, yPosition, 344, 30);
		add(nameList);
	}
	
	private void setWins(int yPosition, String winner){
		JLabel winsList = new JLabel(winner);
		winsList.setHorizontalAlignment(SwingConstants.CENTER);
		winsList.setForeground(new Color(0, 255, 102));
		winsList.setFont(new Font("Changa One", Font.PLAIN, 27));
		winsList.setBounds(684, yPosition, 192, 30);
		add(winsList);
	}
	
}
