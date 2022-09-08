package crudOperationsWithoutBDD;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class DeleteProject {
	public void deleteProject() {
		RequestSpecification reqSpec=RestAssured.given();
        reqSpec.contentType(ContentType.JSON);
			
			
			//action
			Response response=reqSpec.delete("http://localhost:8084/projects/TY_PROJ_006");
			ValidatableResponse validate=response.then();
//			validate.assertThat().contentType(ContentType.JSON);
			validate.assertThat().statusCode(204);
			validate.log().all();
	}

}
