import java.io.*;
import java.util.*;
import java.util.Scanner;

public class Google2 {
	
	static long B = 0;
	static long multi = 1;
	static long A = 0;
	static long read = 0;
	static String s = null;
	static int numLen = 0;
	static int T = 0;
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		T = scanner.nextInt();
		for(int k = 1; k <=T; ++k) {
			B = 0;
			read = scanner.nextLong();
			s = read+"";
			numLen  = s.length();
			for(int i = 0; i<numLen; i++) {
				s = read+"";
				if(s.charAt(i) == '4') {
					multi = 1;
					for(int j=0;j<(numLen-(i+1));j++) {
						multi = multi * 10;
					}
					B = B + multi;
				}
			}
			A = read - B;
			System.out.println("Case #" + k  + ": " + A + " " + B);
		}
	}
}