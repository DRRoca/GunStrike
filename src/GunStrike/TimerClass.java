package GunStrike;

import java.util.Timer;
import java.util.TimerTask;



public class TimerClass {
	private int interval;
	private Timer timer;
	private String time = "1:00";
	static GetCurrentDateTime date = new GetCurrentDateTime();;
	private boolean end = false;

	public String getTime() {
		return time;
	}

	TimerClass(int seconds){
	    timer = new Timer();
	    interval = seconds;
	    timer.scheduleAtFixedRate(new TimerTask() {
	
	        public void run() {
	        	int interval = setInterval();
	        	int minute = interval/60;
	        	int seconds = interval-(60*minute);
	            time = (minute + ":" + String.format("%02d", seconds));
	        }
	    }, 1000, 1000);
	
	}
	
	private int setInterval() {
	    if (interval == 1){
	        timer.cancel();
	        timer.purge();
	        this.end = true;
	    }
	    return --interval;
	}

	public boolean isEnd() {
		return end;
	}
}