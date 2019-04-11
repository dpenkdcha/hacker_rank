import java.math.BigInteger;
import java.util.Scanner;

public class Euler2 {
	
	static int T = 0;
	static long N = 0;
	static double A = 0;
	static double B = 0;
	static double C = 0;
	static long D = 0;
	static long E = 0;
	static long x = 0;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		for(int k=1; k<=T; k++) {
			N = scanner.nextLong();
			D=0; x = 0;
			E=2;			
			
			E = nextNum(D,E,N);
			
			System.out.println(E);
		}
	}
	
	public static long nextNum(long p, long q, long n) {
		x = (q * 4) + p;
		if (x < n) {
			E = E + x;
			nextNum(q,x,n);
		}
		return E;
	}
}
