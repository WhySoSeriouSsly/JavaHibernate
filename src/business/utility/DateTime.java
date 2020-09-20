package business.utility;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTime {

	public static String dateNow() {
		Date date=new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String strDate = dateFormat.format(date);
		strDate = dateFormat.format(date);
		return strDate.toString();
	}
	public static Date date() {
		Date date =new Date();
		return date;
	}
	public static String dateNow(Date date) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String strDate = dateFormat.format(date);
		strDate = dateFormat.format(date);
		return strDate.toString();
	}
}
