package GunStrike;
import java.io.*;  
public class ReadData {
	private String[][] data = new String[100][5];

	private int row;
	public ReadData(){
		try{  		
			String filename = "F:\\match.txt";
			
			FileReader fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			
			String lines = null;
			
			row=0;
			do {		
				lines = br.readLine();
				if(lines != null){
					String[] line = lines.split(",");
					for(int col=0; col<5; col++){
						data[row][col] = line[col];
					}		
					row++;
				}		
			} while (lines != null);

			fr.close();
			br.close();
			
		}catch(Exception e){e.printStackTrace();}  
	}
	
	public String[][] getData() {
		return data;
	}
	
	public int getRow() {
		return row;
	}
}