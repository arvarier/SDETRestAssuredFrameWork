package crudOperationsWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class GetProjects {
	@Test
public void getProject() {
	//request body and content type
			RequestSpecification reqSpec=RestAssured.given();
//		reqSpec.contentType(ContentType.JSON);
			
			
			//action
			Response response=reqSpec.get("http://localhost:8084/projects");
			ValidatableResponse validate=response.then();
//			validate.assertThat().contentType(ContentType.JSON);
			validate.assertThat().statusCode(200);
			validate.log().all();
			
			
}
}

