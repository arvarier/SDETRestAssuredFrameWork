package paramters;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.testng.annotations.Test;

public class PathParamter {
	@Test
	public void getSingleProject()
	{
		
		//pre requisites
		baseURI="http://localhost";
		port=8084;
		
		given()
		.pathParam("pId","TY_PROJ_3215")
		
		//Actions
		.when()
		.get("/projects/{pId}")
		
		//Validations
		.then()
		.log().all();
	}

}
