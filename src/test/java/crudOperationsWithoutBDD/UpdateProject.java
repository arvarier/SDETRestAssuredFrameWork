package crudOperationsWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class UpdateProject {
	@Test
	
	public void updateProject() {
		
		//JSON Object
		
				JSONObject jObj=new JSONObject();
				jObj.put("createdBy","akshay");
				jObj.put("projectName","ICIC");
				jObj.put("status","completed");
				jObj.put("teamSize","20");
				
				//request body and content type
				RequestSpecification reqSpec=RestAssured.given();
				reqSpec.body(jObj);
				reqSpec.contentType(ContentType.JSON);
				
				
				//action
				Response response=reqSpec.put("http://localhost:8084/projects/TY_PROJ_202");
				ValidatableResponse validate=response.then();
				validate.assertThat().contentType(ContentType.JSON);
				validate.assertThat().statusCode(200);
				validate.log().all();
	}

}
