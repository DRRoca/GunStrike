package GunStrike;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class GetCurrentDateTime {

	//private final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
   // private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	private String date;
	public GetCurrentDateTime(){
    	LocalDate localDate = LocalDate.now();
    	this.date = DateTimeFormatter.ofPattern("MM/dd/yy").format(localDate);
    }

    public String getDate(){
    	return date;
    }
}
