
public class InterviewProgram {

/*	find window
 *	// you can also use imports, for example:
	 import java.util.*;

	// you can write to stdout for debugging purposes, e.g.
	// System.out.println("this is a debug message");

 *
 * window finding
 * class Solution { public int solution(int[] A) { // write your code in Java SE
 * 8
 * 
 * int N = A.length; //int M = N ; int dist = 0; boolean visited[] = new
 * boolean[N]; Arrays.fill(visited, false);
 * 
 * for(int i=0; i<N; i++) { if(visited[A[i]] == false) { visited[A[i]] = true;
 * dist++; } }
 * 
 * int leftPointer = 0, rightPointer = 1, max = 0; ArrayList<Integer> arr = new
 * ArrayList<>(N); arr.add(A[0]); System.out.println(ArrayList) while
 * (rightPointer < A.length-1 && arr.size() < dist) { if
 * (!arr.contains(A[rightPointer]) && A[rightPointer] != A[leftPointer]) {
 * arr.add(A[rightPointer]); rightPointer++; max = Math.min(max, arr.size()); }
 * else { arr.remove(A[leftPointer]); leftPointer++; } } return max; } }
 */
	
	/* find window
	 * 
	 * int N = A.length; //int M = N ; int dist = 0; boolean visited[] = new
	 * boolean[N]; Arrays.fill(visited, false);
	 * 
	 * for(int i=0; i<N; i++) { if(visited[A[i]] == false) { visited[A[i]] = true;
	 * dist++; } }
	 * 
	 * System.out.println(dist);
	 * 
	 * int start = 0; int minLen = N; int count = 0; int[] curCount = new int[N];
	 * for(int j=0; j<N; j++) { curCount[A[j]]++;
	 * 
	 * if(curCount[A[j]] == 1) count++;
	 * 
	 * if(count == dist) { System.out.println("j" + j); while (curCount[start] > 1)
	 * { if (curCount[start] > 1) curCount[start]--; start++; }
	 * 
	 * int len = j - start + 1; if(minLen > len) { minLen = len; } } }
	 * 
	 * System.out.println("start" + start); System.out.println("curCount" +
	 * Arrays.toString(curCount));
	 * 
	 * return minLen;
	 */
	 
	 

}
