public class Program6 {
	
	
    public static void main(String[] args) {
        System.out.println("Hello");

        int n = 4;

        for(int i=1;i<=n;i++) {
            for(int j=1;j<=n-i;j++) {
                System.out.print(" ");
            }
            for(int k=0;k<i;k++) {
            	System.out.print("*");
            }
            System.out.println("");
        }

    }
}