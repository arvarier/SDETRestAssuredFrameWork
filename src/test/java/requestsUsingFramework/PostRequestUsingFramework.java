package requestsUsingFramework;


import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;

import com.crm.GenericUtility.DataBaseUtility;
import com.crm.GenericUtility.EndPointsLibrary;
import com.crm.GenericUtility.JavaUtility;
import com.crm.GenericUtility.RestAssuredLibrary;
import com.crm.GenericUtility.WebDriverUtility;

import io.restassured.http.ContentType;

public class PostRequestUsingFramework {

	public void postRequestUsingFramework() {
		DataBaseUtility dLib=new DataBaseUtility();
		JavaUtility jLib=new JavaUtility();
		RestAssuredLibrary rLib=new RestAssuredLibrary();
		WebDriverUtility wLib=new WebDriverUtility();
		
         JSONObject jObj=new JSONObject();
		
	    jObj.put("createdBy","Ganesha"	);
		jObj.put("status","RestAssuredAPI");
		jObj.put("projectName","SilverLine");
		jObj.put("teamSize","25");
		
		baseURI="http://localhost";
		port=8084;
		
   given().contentType(ContentType.JSON).body(jObj)
   .when().post(EndPointsLibrary.createProject)
   .then().log().all();
}
}