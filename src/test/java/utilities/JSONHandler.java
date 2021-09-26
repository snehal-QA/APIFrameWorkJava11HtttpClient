package utilities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONHandler {
	
	public static Map<String,String> mapStr = new HashMap<String, String>();
	
	public static List<String> jsonArray_getkey(String jsonArrayStr, String key) {
	    JSONArray jsonArray = new JSONArray(jsonArrayStr); 
	    return IntStream.range(0, jsonArray.length())
	      .mapToObj(index -> ((JSONObject)jsonArray.get(index)).optString(key))
	      .collect(Collectors.toList());
	}
	
	public static String  handleValue(Object value) {
	    if (value instanceof JSONObject) {
	        handleJSONObject((JSONObject) value);
	    } 
	    else if (value instanceof JSONArray) {
	        handleJSONArray((JSONArray) value);
	    } 
	    return value.toString();
	}
	
	public static void handleJSONObject(JSONObject jsonObject) {
	    jsonObject.keys().
	    forEachRemaining(key -> {
	        Object value = jsonObject.get(key);
	        if(value instanceof JSONObject) 
	        { handleValue(value);} 
	        else 
		    { mapStr.put(key, String.valueOf(value));}
	    });
	}
	
	
	  public static void handleJSONArray(JSONArray jsonArray) {
	  jsonArray.iterator(). forEachRemaining(element -> handleValue(element)); }
	

}
