import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class IsOpenNow {
	
	// read file and get info about open hours for different shops
	public static void readFile() throws IOException{
		FileReader fr = new FileReader("OpenHours");
		BufferedReader br = new BufferedReader(fr);
		String s;
		 Hashtable info = new Hashtable();
		
		while((s = br.readLine()) != null) {
			info.put(s, br.readLine());
		}
		fr.close();
		
	}

	// for shop A type
	public static boolean AisOpenNow(int dayOfWeek, int hour, int weekofMonth) {
		if (dayOfWeek == Calendar.SUNDAY ||
				dayOfWeek == Calendar.SATURDAY){
			return false;
		}
		return 9 <= hour && hour < 17;
	}
	
	// for shop B type
	public static boolean BisOpenNow(int dayOfWeek, int hour, int weekofMonth) {
		return true;
	}
		
	// for shop C type
	public static boolean CisOpenNow(int dayOfWeek, int hour, int weekofMonth) {
		if (weekofMonth == 1 && dayOfWeek == Calendar.MONDAY){
			return false;
		}
		return 9 <= hour && hour < 17;
	}
	
	// for shop D type
	public static boolean DisOpenNow(int dayOfWeek, int hour, int weekofMonth) {
		if (dayOfWeek == Calendar.SUNDAY){
			return false;
		}
		return 9 <= hour && hour < 17;
	}
	
	// for shop E type
	public static boolean EisOpenNow(int dayOfWeek, int hour, int weekofMonth) {
		return ((11 <= hour && hour < 13) ||(16 <= hour && hour < 21));
	}
	
	//get current week of month, day of week, hour of day
	public static boolean isOpenNow(String shopName) {
		Calendar calendar = Calendar.getInstance();
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int weekofMonth = calendar.get(Calendar.WEEK_OF_MONTH);
		if(shopName == "A"){
			return AisOpenNow(dayOfWeek, hour, weekofMonth);
		}else if(shopName == "B"){
			return BisOpenNow(dayOfWeek, hour, weekofMonth);
		}else if(shopName == "C"){
			return CisOpenNow(dayOfWeek, hour, weekofMonth);
		}else if(shopName == "D"){
			return DisOpenNow(dayOfWeek, hour, weekofMonth);
		}else if(shopName == "E"){
			return EisOpenNow(dayOfWeek, hour, weekofMonth);
		}else{
			return false;
		}

		
	}
	
	
}
