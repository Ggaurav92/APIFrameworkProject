package basics;

import io.restassured.path.json.JsonPath;
import jsonHandler.ReUsableMethods;
import payload.Payload;

public class ComplexJsonParse {

	
	public static void main(String[] args) {
	JsonPath js1 = ReUsableMethods.rawToJson(Payload.coursePrice());
	
	int count = js1.getInt("courses.size()");
	System.out.println(count);
	
	int totalAmount = js1.getInt("dashboard.purchaseAmount");
	
	System.out.println(totalAmount);
	
	String titleOfFirstCourse = js1.get("courses[0].title");
	System.out.println(titleOfFirstCourse);
	
	
	//print all course title and their respective prices
	
	for (int i = 0; i < count; i++) {
		
		String courseTitles = js1.get("courses[" + i + "].title"); 
		System.out.println(courseTitles);
		int coursePrices = js1.get("courses[" + i + "].price");
		System.out.println(coursePrices);
	}
	
	}
	
	
	
}//End of Class
