package differentWaysToPostRequest;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateProjectUsingJSONfile {
	@Test
public void createProject() {
	
	//create pre requisites
	File file=new File("./src/test/resources/data.json");
	baseURI="http://localhost";
	port=8084;
	
	given()
	.body(file)
	.contentType(ContentType.JSON)
	
	.when()
	.post("/addProject")
	
	.then()
	.assertThat().statusCode(201)
	.assertThat().contentType(ContentType.JSON)
	.assertThat().log().all();
	
}
}
