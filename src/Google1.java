import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Google1 {

	static String Tstr = null;
	static int T = 0;
	static String Nstr = null;
	static int N = 0;
	static String L = null;
	static String M = "";
	static int A[][];
	static int B[][];
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		Tstr = scanner.nextLine();
		T = Integer.parseInt(Tstr);
		for(int k = 1; k <=T; k++) {
			Nstr = scanner.nextLine();
			L = scanner.nextLine().toUpperCase();
			N = Integer.parseInt(Nstr);
			
			A = new int[N][N];
			B = new int[N][N];
			A[0][0] = 1;
			B[0][0] = 1;
			M = "";
			for(int i=0; i<N;i++) {
				for(int j=0; j<N;j++) {
					for(int p=0; p<L.length(); p++) {
						if(L.substring(p, p+1).equals("E")) {
							j++;
							M = M+"S";
						} else {
							i++;
							M = M+"E";
						}
						A[i][j] = 1;
						B[j][i] = 1;
					}
				}
			}
			
			for (int i = 0; i < A.length; ++i) {
		        for(int j = 0; j < A.length; ++j) {
		           System.out.print(A[i][j] + "\t");
		        }
		        System.out.print("\n");
		     }
			/*System.out.print("\n");
			for (int i = 0; i < B.length; ++i) {
		        for(int j = 0; j < B.length; ++j) {
		           System.out.print(B[i][j] + "\t");
		        }
		        System.out.print("\n");
		     }*/
			
			B[3][2] = 1;
			B[4][2] = 1;
			B[4][3] = 1;
			B[4][4] = 1;
			
			B[2][3] = 0;
			B[2][4] = 0;
			B[3][4] = 0;
			
			System.out.print("\n");
			for (int i = 0; i < B.length; ++i) {
		        for(int j = 0; j < B.length; ++j) {
		           System.out.print(B[i][j] + "\t");
		        }
		        System.out.print("\n");
		     }
			
			for(int i=0; i<N-1;i++) {
				for(int j=0;j<N-1;j++) {
					if(A[i][j] == 1 && B[i][j] == 1) {
						System.out.println("I : " + i + " J : " + j);
						if(A[i][j+1] == 1 && B[i][j+1] == 1) {
							System.out.println("I : " + i + " J1 : " + j);
							B[i][j] = 0;
							B[i+1][j-1] = 1;
						} else if(A[i+1][j] == 1 && B[i+1][j] == 1) {
							System.out.println("I1 : " + i + " J1 : " + j);
							B[i][j] = 0;
							B[i-1][j+1] = 1;
						}
					}
				}
			}
			System.out.print("\n");
			for (int i = 0; i < B.length; ++i) {
		        for(int j = 0; j < B.length; ++j) {
		           System.out.print(B[i][j] + "\t");
		        }
		        System.out.print("\n");
		     }
			System.out.println("Case #" + k  + ": " + M);
		}
		scanner.close();
	}
}
