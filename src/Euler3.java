import java.util.Scanner;

public class Euler3 {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            long n = in.nextLong();
            long A = 0;
            while(n % 2 == 0) {
            	n = n / 2;
            	A = n;
            }
            int i = 3;
            for(i = 3; i<=Math.sqrt(n); i = i + 2) {
            	
            	while(n % i == 0) {
            		n = n / i;
            		if(n >= 1 ) {
            			A = i;
            		}
            		
            	}
            }
            
            if(n>2) {
            	A = n;
            }
            System.out.println(A);
        }
	}

}
