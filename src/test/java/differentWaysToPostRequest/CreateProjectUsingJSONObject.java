package differentWaysToPostRequest;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateProjectUsingJSONObject {
	@Test
	public void postUsingJSONObject() {
		JSONObject jObj=new JSONObject();
		jObj.put("createdBy","SomeOne");
		jObj.put("projectName","NoIdea");
		jObj.put("status","SomeHow");
		jObj.put("teamSize",10);
		
		given()
		.contentType(ContentType.JSON)
		.body(jObj)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat().statusCode(201)
		.assertThat().contentType(ContentType.JSON)
		.assertThat().log().all();
	}

}
