import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class SimpleDateTime {

	public static void main(String[] args) throws ParseException {
		System.out.println("Hello");
		
		String S = "2021-3-4 00:59:50";
		SimpleDateFormat dbFormat = new SimpleDateFormat("yyyy-MM-dd mm:mm:ss");//, Locale.ENGLISH);
		//SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date ED = (dbFormat.parse(S));
        //Date date = new Date();
        System.out.println("Current Date " + dbFormat.format(ED));

        // Convert Date to Calendar
		
		  Calendar c = Calendar.getInstance(); c.setTime(ED);
		  
		  c.add(Calendar.MINUTE, 1);
		  
		  Date currentDatePlusOne = c.getTime();
		  
		  System.out.println("Updated Date " + dbFormat.format(currentDatePlusOne));
		  
			  
		  
		 
	}
}
