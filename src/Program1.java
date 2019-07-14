import java.util.Arrays;
import java.util.HashSet;

public class Program1 {

	public static void main(String[] args) {
		System.out.println("Hello");
		String s = "abcecbcdcdcdcdb";
		String s1 = "abaedacebdbafbceccaebeea";
		String str1 = "hi hello how hello hey hi hello";
		String str2 = "hello";
		String str3 = "bye";
		char c;
		String d;
		int arr[] = {10, 5, 3, 4, 5, 3, 6};
		//char []c = new char[s.length()];
		//HashMap<Integer, Character> c = new HashMap<>();
		HashSet<Character> h = new HashSet<>();
		for(int i=0;i<s.length();i++) {
			c = s.charAt(i);
			if(h.contains(c)) {
				System.out.println(c);
				break;
			} else {
				h.add(c);
			}
		}

		while(s1.length()>0) {
			d = s1.substring(0,1);
			int lb = s1.length();
			s1 = s1.replaceAll(d, "");
			int la = s1.length();
			if( lb == la+1) {
				System.out.println(d);
				break;
			}
		}
		
		for(int i =0;i<str1.length();i++) {
			str1 = str1.replaceAll(str2, str3);
			//System.out.println(str1);
		}
		System.out.println(str1);

		String[] ss = str1.split(",");
		System.out.println(Arrays.toString(ss));

		
		
		int min = -1; 
        HashSet<Integer> set = new HashSet<>(); 
  
        for (int i=0; i<=arr.length-1; i++) 
        { 
            if (set.contains(arr[i])) {
            	min = i; 
            	System.out.println("ele " + arr[min]); 
            }
            else  
                set.add(arr[i]); 
        } 
  
        if (min != -1) 
          System.out.println("The first repeating element is " + arr[min]); 
        else
          System.out.println("There are no repeating elements");
	}
}
