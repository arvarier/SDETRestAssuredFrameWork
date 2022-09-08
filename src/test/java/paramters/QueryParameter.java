package paramters;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class QueryParameter {
	@Test
	public void queryParameter() {
		
		
		baseURI="http://reqres.in";
		
		given()
		.queryParam("page",3)
		
		.when()
		.get("/api/users")
		
		.then()
		.log().all();
	}

}
