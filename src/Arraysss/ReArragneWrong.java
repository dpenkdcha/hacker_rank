package Arraysss;

import java.util.Arrays;

public class ReArragneWrong {

	public static void main(String[] args) {

		int[] arr = { -5, -2, 5, 2, 4, 7, 1, 8, 0, -8 };

		System.out.println( Arrays.toString(arr));
		int i = -1, temp = 0;
        for (int j = 0; j < arr.length; j++)
        {
            if (arr[j] < 0)
            {
                i++;
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            System.out.println( Arrays.toString(arr));
        }
        
        int pos = i+1, neg = 0;

        // Increment the negative index by 2 and positive index by 1, i.e.,
        // swap every alternate negative number with next positive number
        while (pos < arr.length && neg < pos && arr[neg] < 0)
        {
            temp = arr[neg];
            arr[neg] = arr[pos];
            arr[pos] = temp;
            pos++;
            neg += 2;
        }
        System.out.println( Arrays.toString(arr));
	}
}
