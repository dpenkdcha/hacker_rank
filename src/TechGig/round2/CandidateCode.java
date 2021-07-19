package TechGig.round2;
/* 
 * Enter your code here. Read input from STDIN. Print your output to STDOUT. 
 * Your class should be named CandidateCode.
*/

import java.io.*;
import java.util.*;
public class CandidateCode {
	public static void main(String args[] ) throws Exception {

    	//Write code here
        Scanner in = new Scanner(System.in);
        int N =  in.nextInt();
        
        long steps = 0;
        for (int i = 0; i < N; i++)
        {
        	long pack = in.nextLong();
        
         	if(pack == 1) {
           		steps = steps + 1;
           	} else {
				long stepsOdd = isPrime(steps, pack, 1);
				//System.out.println("h " + stepsOdd);
	            if(stepsOdd == pack) {
    	           	steps = 1 + steps + pack;
        	    } else {
            	   	steps = 1 + stepsOdd + pack;
            	}
			}
        }

        System.out.print(steps);
        in.close();
   }

    private static long isPrime(long steps, long n, long packgs) {
    	boolean isPrime = true;
    	long count = 1;
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				isPrime =  false;
				count = i;
				break;
			}
		}
		
		System.out.println("1 n " + n + " count " + count + " steps " + steps + " is prime " + isPrime);
		
		if(!isPrime) { 
			packgs = n/count;
			System.out.println("2 n " + n + " count " + count + " steps " + steps + " is prime " + isPrime);
			steps = steps + packgs;
			System.out.println("3 n " + n + " count " + count + " steps " + steps + " is prime " + isPrime);
			steps = isPrime(steps, packgs, packgs);
			System.out.println("4 n " + n + " count " + count + " steps " + steps + " is prime " + isPrime);
		}
		

		return steps;
	}

}
