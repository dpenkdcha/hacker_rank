package Test;

import java.util.Arrays;

public class TestingString {
	
	public static void main(String[] args) {
		
		String S1 = "1,3,5,7;2,4,6";
		
		String[] S2 = S1.split(";");
		
		String[] S3 = S2[0].split(",");
		
		String[] S4 = S2[1].split(",");
		
		String[] S5 = new String[S3.length + S4.length];
		
		System.arraycopy(S3, 0, S5, 0, S3.length);
		System.arraycopy(S4, 0, S5, S3.length, S4.length);
		
		Arrays.sort(S5);
		for(int i=0;i<S5.length;i++)
		System.out.println(S5[i]);
		
	}

}
