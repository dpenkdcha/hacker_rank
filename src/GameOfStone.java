import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class GameOfStone {

	static boolean p1=true,p2=false,w1=false,w2=false;
    // Complete the gameOfStones function below.
    static String gameOfStones(int n) {
    	String s = "";
    	int m;
    	
    	for(int i=n;i>1;) {
    		if(p1) {
    			p1 = false;
    			p2 = true;
    			if(n>2) {
    				minus(n,2,"P1","W1");
    				n = n-2;
    			} else if(n>3) {
    				minus(n,3,"P1","W1");
    				n = n-3;
    			} else if(n>5) {
    				minus(n,5,"P1","W1");
    				n = n-5;
    			}
    		} else if (p2) {
    			p2 = false;
    			p1 = true;
    			if(n>2) {
    				minus(n,2,"P2","W1");
    				n = n-2;
    			} else if(n>3) {
    				minus(n,3,"P2","W1");
    				n = n-3;
    			} else if(n>5) {
    				minus(n,5,"P2","W1");
    				n = n-5;
    			}
    		}
    	}
    	
    	return s;
    }

    static void minus(int a, int b, String t,  String w) {
    	int x = a-b;
    	if(x<2) {
    		if(t.equals("P1")) {
    			w1 = true;
    		} else if(t.equals("P2")) {
    			w2 = true;
    		}
    	} 
    }
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            String result = gameOfStones(n);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
