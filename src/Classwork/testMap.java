package Classwork;

//import java.util.Map;
import java.util.*;
public class testMap {

	private Map<String, String> map;

	public testMap(){
		map = new TreeMap<>();
	}

	public void insert(String x, String y){
		if (!map.containsKey(x))
			map.put(x,y);

		Set<String> keys = map.keySet();
	}
}
