package crudOperationsWithBDD;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class GetProjectsTest {
	@Test
	public void getAllProjects() {
		given()
		.contentType(ContentType.JSON)
		.when()
		.get("http://localhost:8084/projects")
		.then()
		.assertThat().statusCode(200)
		.assertThat().contentType(ContentType.JSON)
		.assertThat().log().all();
	}

}
