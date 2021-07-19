import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
	
	public static void main(String[] args) {
		System.out.println("Hello");
		List<Integer> list = new ArrayList<>();
	    List<Integer> result = Stream.of(1, 2, 3, 4)
	            .peek(x -> list.add(x))
	            .map(x -> x * 2)
	            .collect(Collectors.toList());
	    		/*.peek(x -> list.add(x))
	    		.map(x -> x * 2)
	    		.filter(x -> x > 8);*/

	    System.out.println(list);
	    System.out.println(result);
	}

}
