import java.util.HashMap;

public class AddDays {

	     public static void main(String []args){
	        System.out.println("Hello World");
	        String date = "19112019";
	        int addDays = 2000;
	        
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
	        int extraDays = 0;
	        int finalYear = Integer.parseInt(datearr[2]);;
	        int finalMonth = 0;
	        int finalDay = 0;
	        int year = Integer.parseInt(datearr[2]);
	        int month = Integer.parseInt(datearr[1]);
	        int day = Integer.parseInt(datearr[0]);
	        
	        yearsToAdd = addDays / 365;
	        extraDays = (addDays % 365);
	        
	        if(yearsToAdd >= 1) {
	        	for(int i = 0; i<yearsToAdd; i++) {
	        		finalYear = finalYear + 1;
	        		if((finalYear % 400 == 0) || ((finalYear % 4 == 0) && (finalYear % 100 != 0))) {
	        			extraDays = extraDays-1;
	        		}
	        	}
	        }
        
	        if(((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) && Integer.parseInt(datearr[1]) <= 2) {
	        	extraDays = extraDays-1;
	        }
	        
        	System.out.println(" Leap Year Included: " + extraDays + " Calculated year : " + finalYear);
        	
            //for months 
            System.out.println("Current Month: " + Integer.parseInt(datearr[1]));
        
            
            extraDays = day + extraDays;
            for(int i=1; (i<12 && extraDays >= hm.get(month)); i++) {
        		extraDays = extraDays - hm.get(month);
        		System.out.println("Days in month " + month + " : " + hm.get(month) + " Remaining Days " + extraDays);
        		if(month < 12) {
        			month++;
        		} else {
        			month = 1;
        			finalYear++;
        		}
        		System.out.println(" Add in month : " + month);
            }
            System.out.println("Calculated Month :" + month);
            
            finalDay = extraDays;
            System.out.println("Calculated Day :" + finalDay);
            
            String finalDate = finalDay+""+month+""+finalYear;
            System.out.println("Calculated Date :" + finalDate);
	            
	        
	     }
}
