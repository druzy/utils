package druzy.utils;

import java.sql.Time;

public class TimeUtils {

	private TimeUtils() {}

	static public int timeToSeconds(Time t){
		if (t==null) throw new NullPointerException("time cannot be null");
		
		return (int) (t.getTime()/1000)+60*60;
	}

	static public Time secondsToTime(int second){
		if (second<0) throw new IllegalArgumentException("second cannot be negative");
		
		return new Time((second-3600)*1000);
	}
	
	//pour les tests
	public static void main(String[] args){
		System.out.println(secondsToTime(4000));
	}
}
