package crudOperationsWithBDD;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class UpdateProjectTest {
@Test
	public void updateProject() {
		JSONObject jObj=new JSONObject();
		jObj.put("createdBy","akshay");
		jObj.put("projectName","NewProject");
		jObj.put("status","update");
		jObj.put("teamSize",20);
		
		given()
		.contentType(ContentType.JSON)
		.when()
		.get("http://localhost:8084/projects/TY_PROJ_005")
		.then()
		.assertThat().statusCode(200)
		.assertThat().contentType(ContentType.JSON)
		.assertThat().log().all();
	}
}
