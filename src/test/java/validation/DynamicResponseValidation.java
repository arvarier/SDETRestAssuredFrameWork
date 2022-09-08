package validation;
import static io.restassured.RestAssured.*;


import org.junit.Assert;

import io.restassured.response.Response;

public class DynamicResponseValidation {

	
	public void dynamicResponse() {
		//pre requistes
		String expData="TY_PROJ_3035";
		baseURI="http://localhost";
		port=8084;
		
		//Action 
		Response resp=when().get("/projects");
		
		//Validation
		boolean flag=false;
        java.util.List<String> pIds = resp.jsonPath().get("projectId");
		
		for(String projectId:pIds)
		{
			if(projectId.equalsIgnoreCase(expData))
			{
				flag=true;
			}
		}
		Assert.assertTrue(flag);
		System.out.println("data verified");
	}
}
