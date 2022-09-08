package differentWaysToPostRequest;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import pojoClassForCrudOperations.ProjectLibrary;

public class CreateProjectUsingPOJO {
	@Test
	public void postUsingPOJO() {
	
	ProjectLibrary pro=new ProjectLibrary("Ganesha","Kailasa","In Progress",20);
	
	given()
	.contentType(ContentType.JSON)
	.body(pro)
	.when()
	.post("http://localhost:8084/addProject")
	.then()
	.assertThat().statusCode(201)
	.assertThat().contentType(ContentType.JSON)
	.assertThat().log().all();

}
}