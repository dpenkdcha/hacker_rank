import java.lang.reflect.Array;
import java.util.Arrays;

class Program8 {
    public static void main(String[] args) {
        
        System.out.println("Hello");

        //int[] a = {1, 2, -10, 4, -3, 10, 7, -8, 9};
        int[] a = {1, -2, 10, -10, -5};
        int p =1;
        int n =1;
        int neg = 0;

        Arrays.sort(a);

        System.out.println(Arrays.toString(a));

        for(int i=0; i<a.length; i++) {
            if(a[i] < 0) {
                neg++;
            } 
            p *= a[i];
        }

        if( p < 0 ) {
            System.out.println("Min : " + p);
            p = p / a[neg-1];
            System.out.println("Max : " + p);
        } else {
            System.out.println("Max : " + p);
            p = p / a[neg-1];
            System.out.println("Min : " + p);
        }
    }
}