package endToEndUsingGU;
import static io.restassured.RestAssured.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.GenericUtility.DataBaseUtility;
import com.crm.GenericUtility.EndPointsLibrary;
import com.crm.GenericUtility.IConstants;
import com.crm.GenericUtility.JavaUtility;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoClassForCrudOperations.ProjectLibrary;

public class EndToEndUsingGUPostPutVerify {
	public void endToEndUsingGUPostPutVerify() throws Throwable {
		baseURI="http://localhost";
		port=8084;
		
		JavaUtility jLib=new JavaUtility();
		ProjectLibrary pojo=new ProjectLibrary("Sherlock","Story"+jLib.getRandomNumber(),"In progress",20);
		
		Response response = given().body(pojo).contentType(ContentType.JSON)
		.when().post(EndPointsLibrary.createProject);
       String projectId = response.body().jsonPath().get("projectId");
       System.out.println(projectId);
       response.then().assertThat().contentType(ContentType.JSON).log().all();

       
       String username=IConstants.APIUsername;
       String password=IConstants.APIPassword;
       String url=IConstants.APIUrl;
       
       WebDriverManager.chromedriver().create();
       WebDriver driver=new ChromeDriver();
       driver.get(url);
       driver.findElement(By.id("usernmae")).sendKeys(username);
       driver.findElement(By.id("inputPassword")).sendKeys(password);
       driver.findElement(By.xpath("//button[text()='Sign in']")).click();
       driver.findElement(By.xpath("//a[text()='Projects']")).click();
       
      List<WebElement> pIds = driver.findElements(By.xpath("//tr//td[1]"));
      for(WebElement pid:pIds)
      {
    	  if(pid.getText().equalsIgnoreCase(projectId))
    		  System.out.println("project created successfully");
      }
      
   String createdBy="Arthur"+jLib.getRandomNumber();
   ProjectLibrary poj=new ProjectLibrary(createdBy,"NewProject"+jLib.getRandomNumber(),"completed",21);
   
  Response resp = given().body(poj).contentType(ContentType.JSON)
   .when().put(EndPointsLibrary.updateProject);
  String created=resp.body().jsonPath().get("createdBy");
  System.out.println(created);
  
  driver.get(url);
  driver.findElement(By.id("usernmae")).sendKeys(username);
  driver.findElement(By.id("inputPassword")).sendKeys(password);
  driver.findElement(By.xpath("//button[text()='Sign in']")).click();
  driver.findElement(By.xpath("//a[text()='Projects']")).click();
  List<WebElement> proMgr = driver.findElements(By.xpath("//tr//td[4]"));
  for(WebElement pm:proMgr)
  {
	  if(pm.getText().equalsIgnoreCase(created)){
		  System.out.println("project updated successfully");
	  }
  }
  
  driver.close();
  
  DataBaseUtility dLib=new DataBaseUtility();
  dLib.connectToDB();
  String query="select* from project where created_by="+"'"+created+"'";
  ResultSet result = dLib.executeQuery(query);
  boolean flag=false;
  while(result.next())
  {
	System.out.println(result.getString(1)+"\t"+result.getString(2)+result.getString(3)+"\t"+result.getString(4)+"\t"+result.getString(5)+"\t"+result.getInt(6));
     flag=true;
  }
  if(flag=true)
	  System.out.println("project updated successfully");
  
      
}
}

