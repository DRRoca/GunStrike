package GunStrike;

import java.io.*;

public class WriteData {
	public WriteData(String date, String player1, String player2, String winner){
		try{  	
			int matchID = 1;
			String fileDir = "F:\\match.txt";
			
			FileWriter fw = new FileWriter(fileDir, true);
			FileReader fr = new FileReader(fileDir);
			BufferedReader br = new BufferedReader(fr);
			BufferedWriter bw = new BufferedWriter(fw);
			
			String line = null;
			
			do {
				line = br.readLine();
				
				if (line != null) {
					matchID++;
				}
			} while (line != null);
			
			line = matchID + "," + date + "," + player1 + "," + player2 + "," + winner;
			
			bw.write(line);
			bw.newLine();
			bw.flush();
			
			fr.close();
			fw.close();	
			br.close();
			bw.close();
			
		}catch(Exception e){e.printStackTrace();}  
	}
}
