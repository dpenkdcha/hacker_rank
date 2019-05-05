import java.util.Arrays;

//import org.json.JSONArray;

public class Financial {

	public static void main(String[] args) {

	    //JSONArray DUParamsList = new JSONArray();
	    String docListQuery = "SELECT * FROM LP_DOC_PROOF_MASTER WHERE CUSTOMER_CATEGORY = ? and";
	    String DOCS_LIST = "IN|FP|_|Y,IN|FD|FD|_";
				String[] INDIVIDUALS_DOCS_LIST = DOCS_LIST.split(",");
				System.out.println("Splited List with , : " + Arrays.toString(INDIVIDUALS_DOCS_LIST));
				for(int j=0; j<INDIVIDUALS_DOCS_LIST.length; j++) {
					String[] DOCS_LIST_ITEM = INDIVIDUALS_DOCS_LIST[j].split("\\|");
					System.out.println(INDIVIDUALS_DOCS_LIST[j] + "Splited List with j : " + Arrays.toString(DOCS_LIST_ITEM));
					if(j > 0) {
						docListQuery += " or";
					}
					if(!DOCS_LIST_ITEM[2].equals("_")) {
						//DUParamsList.put(DOCS_LIST_ITEM[1]);
						//DUParamsList.put(DOCS_LIST_ITEM[2]);
						docListQuery += " (MPDOC_CODE = ? and MPPROOF_CODE = ?)";
					} else {
						//DUParamsList.put(DOCS_LIST_ITEM[1]);
						//DUParamsList.put(DOCS_LIST_ITEM[3]);
						docListQuery += " (MPDOC_CODE = ? and STANDARD_FLAG = ?)";
					}
	                System.out.println("Doc List Query : " + docListQuery);
	                //System.out.println("Doc List Query perms : " + DUParamsList);
				}

	}

}
