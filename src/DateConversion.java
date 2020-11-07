import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConversion {

	public static void main(String[] args) throws Exception {
		
		
		SimpleDateFormat dbFormat = new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat pdfFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date curDate = pdfFormat.parse((new SimpleDateFormat("yyyy-MM-dd")).format(new Date()));
		Date toDate = pdfFormat.parse((new SimpleDateFormat("yyyy-MM-dd")).format(dbFormat.parse("01-03-2020")));
		Date fromDate = pdfFormat.parse((new SimpleDateFormat("yyyy-MM-dd")).format(dbFormat.parse("27-03-2020")));
		
		System.out.println("PDF " + curDate);
		System.out.println("PDF " + toDate);
		System.out.println("db " + fromDate);
		
		if(true && (curDate.after(toDate) && curDate.before(fromDate)) || curDate.compareTo(toDate) == 0 || curDate.compareTo(fromDate) == 0) {
			System.out.println("Hello");
		} else {
			System.out.println("Hi");
		}
	}
}
