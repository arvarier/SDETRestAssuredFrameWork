package differentWaysToPostRequest;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.util.HashMap;

import org.testng.annotations.Test;

import com.crm.GenericUtility.JavaUtility;

import io.restassured.http.ContentType;

public class CreateProjectUsingHashMap {
	@Test
	public void createProject() {
		
		JavaUtility jLib=new JavaUtility();
		baseURI="http://localhost";
		port=8084;
		
		//create pre requisites
		HashMap map=new  HashMap();
		map.put("createdBy", "Akshay");
		map.put("projectName","Sony "+jLib.getRandomNumber());
		map.put("status", "Created");
		map.put("teamSize", 4);
		
		given()
		.body(map)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/addProject")
		
		.then()
		.assertThat().statusCode(201)
		.log().all();
		
	}
}
