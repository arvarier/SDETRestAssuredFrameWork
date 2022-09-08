package validation;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import junit.framework.Assert;

public class StaticResponseValidationGet {
	@Test
	public void staticResponseGet()
	{
		//prerequisites
		String expData="TY_PROJ_1002";
		baseURI="http://localhost";
		port=8084;
		
		//action
		Response resp=when().get("/projects");
		
		
		//validation
		String actData=resp.jsonPath().get("[1].projectId");
		Assert.assertEquals(actData, expData);
		System.out.println("data verified");
		
		resp.then().log().all();
	}

}
