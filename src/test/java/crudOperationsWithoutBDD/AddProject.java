package crudOperationsWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class AddProject {
	
	@Test
	public void create() {
		//JSON Object
		
		JSONObject jObj=new JSONObject();
		jObj.put("createdBy","akshay");
		jObj.put("projectName","ICIC");
		jObj.put("status","InProgress");
		jObj.put("teamSize","20");
		
		//request body and content type
		RequestSpecification reqSpec=RestAssured.given();
		reqSpec.body(jObj);
		//by default its text format
		reqSpec.contentType(ContentType.JSON);
		
		
		//action
		Response response=reqSpec.post("http://localhost:8084/addProject");
		ValidatableResponse validate=response.then();
		validate.assertThat().contentType(ContentType.JSON);
		validate.assertThat().statusCode(201);
		validate.log().all();
		
		
	}

}
