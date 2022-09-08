package crudOperationsWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;


public class AddProjectTest {
	@Test
	public void addProject() {
		JSONObject jObj=new JSONObject();
		
	    jObj.put("createdBy","Ganesha"	);
		jObj.put("status","RestAssuredAPI");
		jObj.put("projectName","SilverLine");
		jObj.put("teamSize","25");
		
		given()
		
		.contentType(ContentType.JSON)
		.body(jObj)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat().statusCode(201)
		.assertThat().contentType(ContentType.JSON)
		.assertThat().log().all();
		
		//

	}
	}
