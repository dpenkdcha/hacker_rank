/* 
 * Enter your code here. Read input from STDIN. Print your output to STDOUT. 
 * Your class should be named CandidateCode.
*/

import java.util.Scanner;

public class CandidateCode1 {
	public static void main(String args[]) throws Exception {

		// Write code here
		Scanner sc = new Scanner(System.in);
		String virus = sc.nextLine();
		int personCount = sc.nextInt();
		sc.nextLine();

		for (int iterator = 0; iterator < personCount; iterator++) {
			String person = sc.nextLine();
			int init = -1;
			int index = 0;
			while (index < person.length()) {
				int location = virus.indexOf(person.charAt(index), init+1);
				if (location > init) {
					init = location;
				} else {
					System.out.println("NEGATIVE");
					init = -1;
					break;
				}
				index++;
			}
			if (init != -1)
				System.out.println("POSITIVE");
		}
		sc.close();
	}
}
