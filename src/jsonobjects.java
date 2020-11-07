import org.apache.commons.lang.StringEscapeUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class jsonobjects {

	public static void main(String[] args) throws JSONException {
		JSONObject obj = new JSONObject();
		System.out.println("obj" + obj.optString("HELLO").equals("hi") + "obj");
		obj.put("cn", "asdfg,zxcvb");
		
		boolean a = obj.optString("cn").contains("zxc");
		System.out.println(a);
		System.out.println(a);
		String s1 = StringEscapeUtils.unescapeJava("{\"payment_enq_resp\":{\"transaction\":{\"IBLRefNo\":\"VK79DT0011511630\",\"CustomerRefNo\":\"210719051811711\",\"StatusCode\":\"E\",\"StatusDesc\":\"Success\",\"Amount\":\"1.00\",\"TranType\":\"IMPS\",\"PaymentDate\":\"21-07-2019 17:18\",\"IBL_customer_name\":\"M\\S LAXMI ANN BHANDA\",\"name_match_status\":\"MISMATCH\",\"policy_no\":\"C228328645\",\"IMPSRefNo\":\"920217488648\"}}}");
		String s2 = "{\"payment_enq_resp\":{\"transaction\":{\"IBLRefNo\":\"VK79DT0011511630\",\"CustomerRefNo\":\"210719051811711\",\"StatusCode\":\"E\",\"StatusDesc\":\"Success\",\"Amount\":\"1.00\",\"TranType\":\"IMPS\",\"PaymentDate\":\"21-07-2019 17:18\",\"IBL_customer_name\":\"M\\S LAXMI ANN BHANDA\",\"name_match_status\":\"MISMATCH\",\"policy_no\":\"C228328645\",\"IMPSRefNo\":\"920217488648\"}}}";
		//String s1 = StringEscapeUtils.unescapeJava("{\"payment_enq_resp\":{\"transaction\":{\"IBLRefNo\":\"VK79DT0011511630\",\"CustomerRefNo\":\"210719051811711\",\"StatusCode\":\"E\",\"StatusDesc\":\"Success\",\"Amount\":\"1.00\",\"TranType\":\"IMPS\",\"PaymentDate\":\"\",\"IBL_customer_name\":\"M\\S LAXMI ANN BHANDA\",\"name_match_status\":\"MISMATCH\",\"policy_no\":\"C228328645\",\"IMPSRefNo\":\"920217488648\"}}}");
	//	JSONObject obj2 = new JSONObject("{\"payment_enq_resp\":{\"transaction\":{\"IBLRefNo\":\"VK79DT0011511630\",\"CustomerRefNo\":\"210719051811711\",\"StatusCode\":\"E\",\"StatusDesc\":\"Success\",\"Amount\":\"1.00\",\"TranType\":\"IMPS\",\"PaymentDate\":\"\",\"IBL_customer_name\":\"M\\S LAXMI ANN BHANDA\",\"name_match_status\":\"MISMATCH\",\"policy_no\":\"C228328645\",\"IMPSRefNo\":\"920217488648\"}}}");
		System.out.println(s1);
		System.out.println("S2" + s2);
		//JSONObject obj4 = new JSONObject(s1);
		//JSONObject obj5 = new JSONObject(s2);
	
		//JSONObject obj3 = obj2.optJSONObject("payment_enq_resp").optJSONObject("transaction");
		
		//System.out.println(obj3);
		//System.out.println(obj4.optJSONObject("payment_enq_resp").optJSONObject("transaction"));
		//System.out.println("obj5" + obj5.optJSONObject("payment_enq_resp").optJSONObject("transaction"));
		
		JSONObject financialGridresponse = new JSONObject("{\"RS\":{\"FR_RESP\":null,\"AC\":\"4077011\",\"RESP\":\"S\",\"POLICY_NO\":\"U99013418\"}}");
		String s3 = financialGridresponse.optJSONObject("RS").optString("FR_RESP");
		String s4 = null;
		System.out.println("value of s3 : " +s3);
		System.out.println(s3 == null);
		System.out.println(s4 == null);
		
		
		
		JSONObject j1 = new JSONObject();
		j1.put("key1", "value1");
		j1.put("key2", "value1");
		System.out.println(j1.toString());
		j1.put("key1", "value2");
		j1.put("key2", "value");
		System.out.println(j1.toString());
		
		System.out.println("karza");
		try {
			JSONObject response = new JSONObject("{\"RS\":{\"Status\":\"failure\",\"Message\":\"Fail\",\"RESP\":null}}");
			if(response.has("RS") && response.optJSONObject("RS").has("RESP") && !response.optJSONObject("RS").optString("RESP").equals("") && response.optJSONObject("RS").optJSONObject("RESP").has("result")) {
				System.out.println("Hii");
			} else {
				System.out.println("No Hii");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("bye");
		String t1 = "";
		String t2 = "Hello";
		System.out.println(t1.equals(t2) + "," + t2.indexOf(t1) + "," + t1.contains(t2) );
		
		JSONObject j2 = new JSONObject();
		JSONObject j3 = new JSONObject();
		j2.put("id", j3);
		j3.put("id", "1");
		System.out.println(j2.toString());
		System.out.println(j2.isNull("id"));
		System.out.println(j2.has("id"));
		System.out.println((j2.optJSONObject(("id")).isNull("id")));
		
		
	}
	
}
