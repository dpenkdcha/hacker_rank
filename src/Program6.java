public class Program6 {
	
	
    public static void main(String[] args) {
        System.out.println("Hello");

        int n = 5;
        int space = 0;

        for(int i=1;i<=n;i++) {
        	space = n-i;
            for(int j=1;j<=space-1;j++) {
                System.out.print(" ");
            }
            for(int k=0;k<i;k++) {
            	if(i == n) {
            		System.out.print("* ");
            	} else {
            		System.out.print(" *");
            	}
            }
            System.out.println("");
        }

    }
}