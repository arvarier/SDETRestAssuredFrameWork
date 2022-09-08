package crudOperationsWithBDD;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;

public class GetSingleProject {
@Test
	public void getSingleProject()
	{
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
