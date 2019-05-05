import java.util.regex.Pattern;

public class Temp {

	public static void main(String[] args) {
		String str = "&&J&a&va says hello world. Java String tutorial";
        
        //Replace first occurrence of substring "Java" with "JAVA"
        String newStr = str.replaceFirst("Java", "JAVA");
         
        //Replace first occurrence of substring "a" with "A"
        String regexResult = str.replaceFirst("\\w[&]", "Y");
         
        System.out.println(newStr);
        System.out.println(regexResult);
	}
}
