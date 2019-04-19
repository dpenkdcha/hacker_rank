import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the plusMinus function below.
    static void plusMinus(int[] arr) {
        float posi=0;
        float negi=0;
        float nutr=0;
        float total=arr.length;
        DecimalFormat _numberFormat= new DecimalFormat("#0.00000");
        
        for(int i=0; i<arr.length; i++){
            if(arr[i] > 0){
                posi=posi+1;
            } else if(arr[i] < 0) {
                negi=negi+1;
            } else {
                nutr=nutr+1;
            }
        }

        System.out.println(_numberFormat.format(posi/total));
        System.out.println(_numberFormat.format(negi/total));
        System.out.println(_numberFormat.format(nutr/total));


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        plusMinus(arr);

        scanner.close();
    }
}
