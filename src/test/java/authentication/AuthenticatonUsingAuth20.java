package authentication;

import static io.restassured.RestAssured.*;

import io.restassured.response.Response;


public class AuthenticatonUsingAuth20 {
	
	
	public void authenticatonUsingAuth20() {

	 Response response = given()
				.formParam("client_id","SDET37")
				.formParam("client_secret","f2aa22c4ac0ac90eb2a04bf978f74193")
				.formParam("grant_type","client_credentials")
				.formParam("redirect_uri","http://example.com")
				.formParam("code","3746")
		    .when().post("http://coop.apps.symfonycasts.com/authorize");
		
		//capture the access token from the response of the above the request
		String token=response.jsonPath().get("access_token");
		System.out.println(token);
		
		//create another request and use the token to access the APIs
		given()
		.auth().oauth2(token)
		.pathParam("USER_ID",3746)
		
		.when()
		.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-count")
		
		.then().log().all();
	}

}
