package jsonHandler;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ReUsableMethods {

	
	public static JsonPath rawToJson(String res) {
		
		JsonPath js = new JsonPath(res);
		
		return js;
	}
	
}
