import java.util.HashMap;

public class AddDays {

	     public static void main(String []args){
	        System.out.println("Hello World");
	        String date = "01032000";
	        int addDays = 2254;
	        
	        HashMap<Integer, Integer> hm = new HashMap<>();
	        hm.put(1, 31);
	        hm.put(2, 28);
	        hm.put(3, 31);
	        hm.put(4, 30);
	        hm.put(5, 31);
	        hm.put(6, 30);
	        hm.put(7, 31);
	        hm.put(8, 31);
	        hm.put(9, 30);
	        hm.put(10, 31);
	        hm.put(11, 30);
	        hm.put(12, 31);
	        
	        
	        boolean isLeap = false;
	        System.out.println(date);
	        String []datearr = new String[5];
	        datearr[0] = date.substring(0,2);
	        datearr[1] = date.substring(2,4);
	        datearr[2] = date.substring(4);
	        System.out.println(datearr[0] + " " + datearr[1] + " " + datearr[2]);
	        
	        int yearsToAdd = 0;
	        int monthsToAdd = 0;
	        int daysToAdd = 0;
	        int leapYearInBtwn = 0;
	        int extraDays = 0;
	        int finalYear = 0;
	        int finalMonth = 0;
	        int finalDay = 0;
	        int year = Integer.parseInt(datearr[2]);
	        
	            
	        yearsToAdd = addDays / 365;
        	leapYearInBtwn = yearsToAdd/4;
        	if((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0)) && Integer.parseInt(datearr[1]) <=2)
        		extraDays = (addDays % 365) - leapYearInBtwn - 1;
        	else
        		extraDays = (addDays % 365) - leapYearInBtwn;
        	System.out.println("Years to be added: " + yearsToAdd + " Leap Year Included: " + leapYearInBtwn + " Extra Days: " + extraDays);
        	
            finalYear = Integer.parseInt(datearr[2]) + yearsToAdd;
            System.out.println("Calculated year : " + finalYear);
            
            //for months 
            System.out.println("Current Month: " + Integer.parseInt(datearr[1]));
        
            for(int i=Integer.parseInt(datearr[1]); (i<=12 && extraDays >= hm.get(i)); i++) {
        		extraDays = extraDays - hm.get(i);
        		monthsToAdd++;
        		
            	if((finalYear % 400 == 0) || ((finalYear % 4 == 0) && (finalYear % 100 != 0)) && monthsToAdd == 2 && finalYear != Integer.parseInt(datearr[2])) {
            		System.out.println("Current is Leap");
            		extraDays = extraDays - 1;
        		}
            	System.out.println("Days in month " + i + " : " + hm.get(i) + " Remaining Days " + extraDays + " Add in month : " + monthsToAdd);
            }
            finalMonth  = Integer.parseInt(datearr[1]) + monthsToAdd;
            System.out.println("Calculated Month :" + finalMonth);
            
            finalDay = Integer.parseInt(datearr[0]) + extraDays;
            System.out.println("Calculated Day :" + finalDay);
            
            String finalDate = finalDay+""+finalMonth+""+finalYear;
            System.out.println("Calculated Date :" + finalDate);
	            
	        
	     }
}
