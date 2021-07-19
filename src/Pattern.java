
public class Pattern {
	
	public static void main(String[] args) {
		int n = 5;
		int [][]a = new int[n][n];
		int c= 0;
		int b = n*(n+1)/2;
		//System.out.println(b);
		for(int i=0;i<n;i++) {
			for(int j=c;j<n;j++) {
				a[j][i] = b;
				b--;
			}
			c++;
		}

		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(a[i][j] == 0) {
					continue;
				} else {
					System.out.print(a[i][j] + " ");
				}
			}
			System.out.println();
		}	
	}
}
