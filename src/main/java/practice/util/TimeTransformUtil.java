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
	
	
}
