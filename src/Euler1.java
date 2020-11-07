import java.util.Scanner;

public class Euler1 {

	static int T = 0;
	static long N = 0;
	static long newN3 = 0;
	static long newN5 = 0;
	static long newN15 = 0;
	static long A = 0;
	static long B = 0;
	static long C = 0;
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		for(int k=1; k<=T; k++) {
			N = scanner.nextLong();
			newN3 = (N-1)/3;
			newN5 = (N-1)/5;
			newN15 = (N-1)/15;
			A=0; B=0; C=0;
			
			A = ((newN3) * (6  + (newN3-1)*3))/2;
			B = ((newN5) * (10  + (newN5-1)*5))/2;
			C = ((newN15) * (30 + (newN15-1)*15))/2;
			
			System.out.println(A+B-C);
			scanner.close();
		}
	}
}
