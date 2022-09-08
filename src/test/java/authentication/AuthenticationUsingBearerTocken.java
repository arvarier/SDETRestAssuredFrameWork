package authentication;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class AuthenticationUsingBearerTocken {
	@Test
	public void bearerTocken()
	{
		baseURI="https://api.github.com";
		JSONObject jObj=new JSONObject();
		jObj.put("name"," sdet37resTAssured");
			given()
			.auth()
			.oauth2("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")
			.body(jObj)
			.contentType(ContentType.JSON)
			
			.when()
			.post("/user/repos")
			
			.then().log().all();
	}

}
