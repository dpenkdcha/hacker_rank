package Stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class StringTest {
	
	public static void main(String[] args) {
		System.out.println("Hello");
		String S = "1.re.re.tr";
		
		String S1 =  Arrays.asList(S.split("\\.")).stream()
							.sorted(Collections.reverseOrder())
							.map(String::valueOf)
                            .collect(Collectors.joining("."));
		 
		System.out.println("Reversed " + S1);
	}

	
}
