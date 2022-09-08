package requestChaining;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.testng.annotations.Test;

import com.crm.GenericUtility.JavaUtility;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoClassForCrudOperations.ProjectLibrary;

public class CreateProjectRequestChaining {
	@Test
	
	public void requestChaining() {
		//create a project using pojo class
		JavaUtility jLib=new JavaUtility();
		ProjectLibrary pj=new ProjectLibrary("happy","ty_project123"+jLib.getRandomNumber(),"completed",20);
		
		baseURI="http://localhost";
		port=8084;
		
		Response resp=given()
		.body(pj)
		.contentType(ContentType.JSON)
		.when()
		.post("/addProject");
		
		//captured the project id
		String proId=resp.jsonPath().get("projectId");
		System.out.println(proId);
		resp.then().log().all();
		
		//created a get request and pass proId as path parameter
		given()
		.pathParam("pId",proId)
		.when()
		.get("/projects/{pId}")
		.then()
		.assertThat().statusCode(200).log().all();
	}

}
