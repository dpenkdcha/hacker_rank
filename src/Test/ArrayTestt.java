package Test;

public class ArrayTestt {
	
	public static void main(String[] args) {
		
		int []a1 = {1,2,3,4,6,7,8,9,10};
		
		int num = 0;
		
		for(int i=0;i<a1.length-1;i++) {
			if(a1[i] != a1[i+1] - 1) {
				num = a1[i] + 1;
				break;
			}
		}
		
		System.out.println("Missing number : " + num);
		
		String test="a1b2c3";
		String[] tokens =test.split("\\d");
		for(String s : tokens)
		System.out.println(s+ " ");
		
		int arr[] = new int[10];
		int i=5;
		arr[i++] = ++i+i++;
		System.out.println(arr[5]+":"+arr[6]);
		
		Character ch1 = new Character('A');
		System.out.println(ch1+"\t"+(int)ch1);
		
		final char ch='A';
		switch(65)
		{
		case ch:
		System.out.println("65"); //65
		case 66:
		System.out.println("66"); //66
		}
	}

}
