
public class Program13 {
	public static void main(String[] args) {
		System.out.println("Hello");
		
		int a = 153;
		int b = a;
		int c = 0;
		int d = 0;
		int n = 0;
		
		while(a> 0) {
			c = a % 10;
			a = a / 10;
			d = c * c * c;
			n = n + d;
			System.out.println("c : " + c + " n : " + n);
		}
		
		if(b == n) {
			System.out.println("Yes");
		}
 		
	}
}
