package dataDrivenTesting;
//import pojoClassForCrudOperations.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import pojoClassForCrudOperations.ProjectLibrary;

public class AddProjectUsingDataProviderTest {
	@Test(dataProvider="bodyData")
	public void addProject(String createdBy,String projectName,String status,int teamSize)
	{
		ProjectLibrary pojo= new ProjectLibrary(createdBy,projectName,status,teamSize);
		
		given()
		.body(pojo)
		.contentType(ContentType.JSON)
		
		.when()
		.post("http://localhost:8084/addProject")
		
		.then()
		.assertThat().statusCode(201)
		.assertThat().contentType(ContentType.JSON)
		.assertThat().log().all();
		
	}
	
	@DataProvider(name="bodyData")
	
	public Object[][] bodyData(){
		
		Object[][] objArr=new Object[4][4];
		
		objArr[0][0]="Akshay";
		objArr[0][1]="Cricket";
		objArr[0][2]="Upcoming";
		objArr[0][3]=11;
		
		objArr[1][0]="Akshay";
		objArr[1][1]="Football";
		objArr[1][2]="Upcoming";
		objArr[1][3]=11;
		
		objArr[2][0]="Akshay";
		objArr[2][1]="Badminton";
		objArr[2][2]="Upcoming";
		objArr[2][3]=2;
		
		objArr[3][0]="Akshay";
		objArr[3][1]="Hockey";
		objArr[3][2]="Upcoming";
		objArr[3][3]=6;
		
		return objArr;
	}
	

}
