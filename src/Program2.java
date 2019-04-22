import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Program2 {
	public static void main(String[] args) {
		
		System.out.println("Hello");
		
		Integer[] a = {2,3,4,5,6,1,7,5,3,5,11,454,23236,756,3412};
		ArrayList<Integer> al = new ArrayList<>(Arrays.asList(a));
		List<Integer> F = new ArrayList<>();
		List<Integer> E = new ArrayList<>();
		List<Integer> O = new ArrayList<>();
		
		
		for(int i=0;i<al.size();i++) {
			if((a[i]%2) == 0) {
				E.add(al.get(i));
			} else {
				O.add(al.get(i));
			}
		}
		Collections.sort(E);
		Collections.sort(O);
		F.addAll(E);
		F.addAll(O);
		Iterator<Integer> i = F.iterator(); 
        while (i.hasNext()) 
            System.out.println(i.next());
	}
}
