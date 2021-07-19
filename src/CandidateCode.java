/* 
 * Enter your code here. Read input from STDIN. Print your output to STDOUT. 
 * Your class should be named CandidateCode.
*/

import java.util.Scanner;

public class CandidateCode {
	public static void main(String args[]) throws Exception {

		// Write code here
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			int prime1 = 0;
			int prime2 = 0;
			sc.nextLine();
			int firstInt = sc.nextInt();
			int lastInt = sc.nextInt();
			// System.out.println("first " + first + "last " + last);

			for (int i1 = firstInt; i1 <= lastInt; i1++) {
				if (isPrime(i1)) {
					prime1 = i1;
					break;
				}
			}

			if (prime1 > 0) {
				if (prime1 > firstInt) {
					firstInt = prime1;
				}
				for (int i1 = lastInt; i1 >= firstInt; i1--) {
					if (isPrime(i1)) {
						prime2 = i1;
						break;
					}
				}
			}
			// System.out.println("p1 " + p1 + "p2 " + p2);
			if (prime1 == prime2 && prime1 != 0 && prime2 != 0) {
				System.out.println("0");
			} else if (prime1 == 0 && prime2 == 0) {
				System.out.println("-1");
			} else {
				System.out.println(prime2 - prime1);
			}
		}

		sc.close();
	}

	private static boolean isPrime(int n) {
		if (n <= 1) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
}
