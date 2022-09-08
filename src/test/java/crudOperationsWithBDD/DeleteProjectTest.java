package crudOperationsWithBDD;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;

public class DeleteProjectTest {
	public void deleteProject() {
		given()
		.contentType(ContentType.JSON)
		.when()
		.get("http://localhost:8084/projects/TY_PROJ_005")
		.then()
		.assertThat().statusCode(204)
		.assertThat().contentType(ContentType.JSON)
		.assertThat().log().all();
	}

}
