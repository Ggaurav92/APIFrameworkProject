package dynamicJson;

import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import jsonHandler.ReUsableMethods;
import payload.Payload;

public class DynamicJson {

	@Test (dataProvider = "BooksData")
	public void addBook(String isbn,String aisle) {
		
		RestAssured.baseURI = "http://216.10.245.166";
		
		String res = given().log().all().header("Content-Type","application/json")
						.body(Payload.AddBook(isbn,aisle)).
						when()
						.post("Library/AddBook.php")
						.then().assertThat().statusCode(200)
						.extract().response().asString();
		
		
		JsonPath js3 = ReUsableMethods.rawToJson(res);
		
		String id = js3.get("ID");
		
		System.out.println(id);
	}
	
	
	@DataProvider (name = "BooksData")
	public Object[][] getdata(){
		
		return new Object[][] {{"fsafd","12859"}};//,{"gfdsd","644683"},{"fshgd","4644667"}};
	}
	
	
}//End of Class
