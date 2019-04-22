import java.util.HashMap;
import java.util.HashSet;

public class Program1 {

	public static void main(String[] args) {
		System.out.println("Hello");
		String s = "abcccdcdcdcdb";
		char c;
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
	}
}
