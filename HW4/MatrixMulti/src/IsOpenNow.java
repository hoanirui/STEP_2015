import java.util.*;

public class IsOpenNow {

	public static boolean isOpenNow(int dayOfWeek, int hour) {
		if (dayOfWeek == Calendar.SUNDAY ||
				dayOfWeek == Calendar.SATURDAY){
			return false;
		}
		return 9 <= hour && hour < 17;
	}
	
	public static boolean isOpenNow() {
		Calendar calendar = Calendar.getInstance();
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		return isOpenNow(dayOfWeek, hour);
	}
	
/*
 * 
 */
	
}
