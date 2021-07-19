package Test;


public class StringTestt {

	public static void main(String[] args) {
		String S1 = "aabbcddc";
		
		int index = 0;
		
		char []C1 = new char[256];
		for(int i=0; i<S1.length(); i++) {
			C1[S1.charAt(i)]++;
		}
		
		for(int i=0; i<S1.length(); i++) {
			if(C1[S1.charAt(i)] == 1) {
				index = i+1;
				break;
			}
		}
		
		System.out.println(index);
		
	
	}
}
