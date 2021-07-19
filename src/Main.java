import java.util.*;
public class Main
{
    
	/*
	 * public static void game(int n){
	 * 
	 * boolean p1 = true; boolean p2 = false;
	 * 
	 * while(n>1){
	 * 
	 * if(p1) {
	 * 
	 * if(n>=5) {n = n-5; p2 = true;} else if(n>=3) {n = n-3; p2 = true;} else
	 * if(n>=2){n = n-2; p2 = true;} else { System.out.println("Player 1 Won"); }
	 * 
	 * }
	 * 
	 * if(p2) {
	 * 
	 * if(n>=5) {n = n-5; p1 = true;} else if(n>=3) {n = n-3; p1 = true;} else
	 * if(n>=2) {n = n-2; p1 = true;} else { System.out.println("Player 1 Won"); } }
	 * }
	 * 
	 * if(p1) System.out.println("Player 1 Won"); else
	 * System.out.println("Player 2 Won"); }
	 */
    static int c = 0;
public static void main(String[] args) {

		/*
		 * Scanner s = new Scanner(System.in); int m = s.nextInt(); game(m);
		 */
	
	System.out.println(Boolean.parseBoolean("FalSe"));
	
	ArrayList<String> a = new ArrayList<>();
	
	//a.sort(List.);
	String[] a1 = {"abc", "2", "10", "z"};
	List<String> a2 = Arrays.asList(a1);
	Collections.sort(a2);
	System.out.println(a2.toString());
	
	//System.out.println(int 0 % 5 == 0);

}
} 
