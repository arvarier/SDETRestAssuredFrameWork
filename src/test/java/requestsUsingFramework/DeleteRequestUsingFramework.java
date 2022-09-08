package requestsUsingFramework;
import static io.restassured.RestAssured.*;
import com.crm.GenericUtility.DataBaseUtility;
import com.crm.GenericUtility.EndPointsLibrary;
import com.crm.GenericUtility.JavaUtility;
import com.crm.GenericUtility.RestAssuredLibrary;
import com.crm.GenericUtility.WebDriverUtility;

import io.restassured.http.ContentType;

public class DeleteRequestUsingFramework {

	public void deleteRequestUsingFramework() {
		DataBaseUtility dLib=new DataBaseUtility();
		JavaUtility jLib=new JavaUtility();
		RestAssuredLibrary rLib=new RestAssuredLibrary();
		WebDriverUtility wLib=new WebDriverUtility();
		
		baseURI="http://localhost";
		port=8084;
		
   given().contentType(ContentType.JSON).when().get(EndPointsLibrary.getAllProjects).then().assertThat().statusCode(200).assertThat().contentType(ContentType.JSON);
		
}
}