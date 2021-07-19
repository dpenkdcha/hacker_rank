package TechGig.round2;
/* 
 * Enter your code here. Read input from STDIN. Print your output to STDOUT. 
 * Your class should be named CandidateCode.
*/

import java.io.*;
import java.util.*;

public class CandidateCode2 {
	public static void main(String args[]) throws Exception {

		// Write code here
		Scanner in = new Scanner(System.in);
//		int N = 5;
		int N = in.nextInt();
//		int R = 5;// in.nextInt();
		int R = in.nextInt();
		in.nextLine();

		/*
		 * long[][] values = new long[R][4]; for (int i = 0; i < R; i++) { values[i][0]
		 * = in.nextLong(); values[i][1] = in.nextLong(); values[i][2] = in.nextLong();
		 * values[i][3] = -1; in.nextLine(); }
		 */

		// long values[][] = new long[][] { { 1, 2, 30, -1 }, { 1, 3, 10, -1 }, { 2, 5, 40, -1 }, { 3, 4, 20, -1 }, { 4, 5, 30, -1 } };
		// long values[][] = new long[][] { { 1, 2, 30, -1 }, { 1, 3, 10, -1 }, { 2, 5, 40, -1 }, { 3, 4, 20, -1 }, { 4, 5, 30, -1 } };
		long values[][] = new long[][] { { 1, 3, 10, -1 }, { 3, 4, 5, -1 }, { 4, 5, 30, -1 }, { 5, 6, 10, -1 } };
		//long values[][] = new long[][] { { 1, 3, 20, -1 }, { 1, 4, 10, -1 }, { 2, 3, 5, -1 }, { 1, 2, 25, -1 }, {5, 2, 5, -1 }, {2, 5, 45, -1}, {2, 6, 30, -1}, {3, 5, 10, -1}, {3, 6, 15, -1} };

		/*
		 * for (int i = 0; i < R; i++) { for (int j = 0; j < 4; j++) {
		 * System.out.print(values[i][j] + " "); } System.out.println(); }
		 */

		int ans = PathLength(N, R, values, Integer.MAX_VALUE);
		//System.out.print(ans);
		boolean possible = false;
		long[] a = new long[2];
		if(ans <= 1) {
			possible = false;
		} else {
			long[] x = connecting(values[ans][0], values[ans][2], R, values, a);
			if(x[0] == 1) {
				System.out.print(x[1]);
				possible = true;
			} else {
				for (int i = 0; i < R; i++) {
					values[ans][3] = -1;
					if (values[i][3] == 0) {
						long[] y = connecting(values[i][0], values[i][2], R, values, a); 
						if (y[0] == 1) {
							System.out.print(y[1]);
							possible = true;
							break;
						}
					}
				}
			}
		}

		if (!possible) {
			System.out.print("NOT POSSIBLE");
		}

		in.close();
	}

	private static int PathLength(long n, long r, long[][] graph, long shortDist) {
		long dist = shortDist;
		int graphEle = -1;
		for (int i = 0; i < r; i++) {
			if (graph[i][1] == n && graph[i][3] == -1) {
				graph[i][3] = 0;
				if (dist > graph[i][2]) {
					dist = graph[i][2];
					graphEle = i;
				}
				// System.out.println("1 Dist : " + dist);
			}
		}

		return graphEle;
	}

	private static long[] connecting(long prevN, long distPrev, long r, long[][] graph, long[] a) {
		// System.out.println("N " + prevN);
		if (prevN == 1) {
			a[0] = 1;
			a[1] = a[1] + distPrev;
			return a;
		}
		a[0] = 0;
		for (int j = 0; j < r; j++) {
			System.out.println("1 j " + j + " prevN " + prevN + " distPrev " + distPrev);
			if (graph[j][1] == prevN && graph[j][3] == -1) {
				graph[j][3] = 0;
				if(distPrev > graph[j][2]) {
					a[1] = a[1] + (distPrev - graph[j][2]);
					a[0] = 1;
				} else {
					a[0] = 0;
					return a;
				}

				System.out.println("2 j " + j + " prevN " + prevN + " distPrev " + distPrev + " a[1] " + a[1]);
				a = connecting(graph[j][0], graph[j][2], r, graph, a);
				break;
			}
		}

		return a;
	}

}
