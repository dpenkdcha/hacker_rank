
import java.util.*;


public class Euler2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            long N = in.nextLong();

            long p = 0;
            long c = 2;
            long n = 0;
            long sum = 2;
        
            for(int i=0;i<N;i++){
                n = p + 4*c;
                if(n>N){
                    break;
                }
                sum = sum + n;
                p=c;
                c=n;
            }
            System.out.println(sum); 
            in.close();
        }
    }
}

