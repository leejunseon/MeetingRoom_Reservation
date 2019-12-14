package practice.util;

import java.util.StringTokenizer;
import org.springframework.stereotype.Component;

@Component
public class TimeTransformUtil {
	
	private StringTokenizer st;
	
	public int toInteger(String time) {
		int result=0;
		st=new StringTokenizer(time," :");
		
		int hour=Integer.parseInt(st.nextToken());
		if(hour==12)
			hour=0;
		int minute=Integer.parseInt(st.nextToken());
		
		result+=60*hour;
		result+=minute;
		
		String ampm=st.nextToken();
		if(ampm.equals("PM"))
			result+=60*12;
		
		return result;
	}
	
	public String toTime(int time) {
		String result="";
		
		String ampm="";
		if(time>=720) {
			ampm="PM";
			time-=720;
		}else {
			ampm="AM";
		}
		
		String hour=Integer.toString(time/60);
		if(hour.equals("0"))
			hour="12";
		if(hour.length()==1)
			hour="0"+hour;
		
		String minute=Integer.toString(time%60);
		if(minute.length()==1)
			minute="0"+minute;
		
		result=hour+":"+minute+" "+ampm;
		return result;
	}
}
