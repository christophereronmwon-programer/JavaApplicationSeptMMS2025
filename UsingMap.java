import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class UsingMap{
	public static void main(String[] args){
		// Create a new HashMap
		Map<Integer, String> map = new HashMap<>();
		
		//put(K Key, V value) -Inserts Key-value pairs into the map
		map.put(101, "Frank John");
		map.put(102, "Henry Clinton");
		map.put(103, "Kate Benson");
		map.put(104, "Lucy Gerry");
		map.put(105, "Johnny Victor");
	    map.put(106, "Kate Benson");
		map.put(107, "Nathan Zoe");
		
		//get(object key) - Returns the value associated with the key
		String value = map.get(102);
		System.out.println("Value for '102': "+ value);
		
		//remove(object Key) - Checks if the map contains the specified
		map.remove(106);
		
		//containsKey(Object Key) - checks if the map contains the specified
		boolean hasApple =  map.containsKey(106);
		System.out.println("Map Contains 106:" + hasApple);
		
		//Keyset ()- Returns a set view of the keys contained in the map
		Set<Integer> keys = map.keySet();
		System.out.println("Keys in the map:" + keys);
	}
}