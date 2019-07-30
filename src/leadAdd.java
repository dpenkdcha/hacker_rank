import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class leadAdd {

	public static void main(String[] args) {
		String adrs = "RAJAPUSHPA ATRIA BLOCK-B AURA-306~GOLDEN MILE ROAD KOKAPET~POULOMI ARISTOS~500075";
		String[] leadAddressArr = adrs.split("~");
		Pattern regex = Pattern.compile("[$&+,:;=?@#!|]");
		for(int i=0;i<2;i++)
		{
			if(leadAddressArr[i] == null)
				leadAddressArr[i] = "";
			else if(leadAddressArr[i].toString() == null)
				leadAddressArr[i] = "";
			
			Matcher matcher = regex.matcher(leadAddressArr[i]);
			while(matcher.find())
			{
				String s= matcher.group();
				leadAddressArr[i] = leadAddressArr[i].replaceAll("\\"+s, "");
			}
		}
		
		String leadAddress1 = leadAddressArr[0].substring(0, leadAddressArr[0].length()>30?29:leadAddressArr[0].length());
		String leadAddress2 = leadAddressArr[1].substring(0, leadAddressArr[1].length()>30?29:leadAddressArr[1].length());
		String leadAddress3 = leadAddressArr[2].substring(0, leadAddressArr[2].length()>30?29:leadAddressArr[2].length());
		String leadZipcode = leadAddressArr[3];
		
		System.out.println("a1: " + leadAddress1);
		System.out.println("a2: " + leadAddress2);
		System.out.println("a3: " + leadAddress3);
		System.out.println("a4: " + leadZipcode);
	}
}
