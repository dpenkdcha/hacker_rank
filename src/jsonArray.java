import org.apache.commons.lang.StringEscapeUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class jsonArray {

	public static void main(String[] args) {
		
		JSONArray ary = new JSONArray();
		if(ary.length() > 0) {
			
			JSONObject j1 = ary.optJSONObject(0);
			j1.optString("A");
			System.out.println("HI");
		}
		
		JSONObject j2 = ary.optJSONObject(0);
		if(j2.length() > 0) {
			System.out.println("Hello");
		}
		
		
		
	}
}
