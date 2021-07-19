package Stream;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class HMap {
	
	static LinkedHashMap<Integer, String> hmap1 = new LinkedHashMap<>();
	static LinkedHashMap<Key, String> hmap = new LinkedHashMap<>();
	
	public static void main(String[] args) {
		
		Key _101 = new Key(101);
		Key _102 = new Key(102);
		hmap.put(_101, "Ram");	//Same Hashcode different key by default equals method
		hmap.put(_102, "Ram1");
		hmap.put(new Key(103), "Sheeta");
		hmap.put(new Key(103), "Radha");
		hmap.put(new Key(104), "Ram");
		hmap.put(new Key(105), "L");
		hmap.put(new Key(102), "Ram");
		hmap.put(new Key(106), "M");
		hmap.put(_101, "Ram");
		hmap.put(_101, "Ram2");
		
		hmap1.put(101, "Ram");
		hmap1.put(102, "Ram");
		hmap1.put(103, "Sheeta");
		hmap1.put(103, "Radha");
		hmap1.put(104, "Ram");
		hmap1.put(105, "L");
		hmap1.put(102, "Ram");
		
		
		hmap.entrySet().forEach(entry -> {
		    System.out.println(entry.getKey().getKey() + " " + entry.getValue());
		});
		
		 System.out.println("*");
		
		hmap1.entrySet().forEach(entry -> {
		    System.out.println(entry.getKey() + " " + entry.getValue());
		});
	}
	
}

class Key
{
  int key;
  Key(int key)
  {
    this.key = key;
  }
  
  @Override
  public int hashCode() 
  {
		
		  if(key == 101 || key == 102) return 101;
		 
     return key;
  }

  public int getKey() {
	  return key;
  }
  
}
