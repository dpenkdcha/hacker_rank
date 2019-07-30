import org.apache.commons.lang.StringEscapeUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class jsonobjects {

	public static void main(String[] args) throws JSONException {
		JSONObject obj = new JSONObject();
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
		
		JSONObject financialGridresponse = new JSONObject("{\"RS\":{\"FR_RESP\":\"\\\"IN|FQ|FQ|_|_|E042;PR|FQ|FQ|_|_|E042\\\"\",\"AC\":\"4077011\",\"RESP\":\"S\",\"POLICY_NO\":\"U99013418\"}}");
		String s3 = financialGridresponse.optJSONObject("RS").optString("FR_RESP");
		System.out.println("S3" + s3);
		
		
	}
	
}
