
public class Program3 {

    public static void main(String[] args) {
        System.out.println("Hello");

        int[] a = {1,2,3,4};

        for(int i=0; i<a.length;i++) {
            for(int j=i+1;j<a.length;j++) {
                String x = "(" + a[i] + "," + a[j] + ")";
                System.out.println(x);
            }
        }









    }
}
