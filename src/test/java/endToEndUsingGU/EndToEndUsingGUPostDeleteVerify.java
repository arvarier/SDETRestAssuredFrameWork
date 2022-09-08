package endToEndUsingGU;

import static io.restassured.RestAssured.*;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.GenericUtility.DataBaseUtility;
import com.crm.GenericUtility.EndPointsLibrary;
import com.crm.GenericUtility.FileUtility;
import com.crm.GenericUtility.IConstants;
import com.crm.GenericUtility.JavaUtility;
import com.crm.GenericUtility.RestAssuredLibrary;
import com.crm.GenericUtility.WebDriverUtility;
import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoClassForCrudOperations.ProjectLibrary;

public class EndToEndUsingGUPostDeleteVerify {
	
	public void EndToEnd() throws Throwable {
		
		baseURI="http://localhost";
		  port=8084;
		  JavaUtility jLib=new JavaUtility();
		  ProjectLibrary pojo=new ProjectLibrary("James","JB"+jLib.getRandomNumber(),"Created",60);
		  
		  Response response = given().body(pojo).contentType(ContentType.JSON)
		  .when().post(EndPointsLibrary.createProject);
		  String projectId= response.body().jsonPath().get("projectId");
		  System.out.println(projectId);
		  response.then().assertThat().statusCode(201).assertThat().contentType(ContentType.JSON).log().all();

		  
		  FileUtility fLib=new FileUtility();
		  String url=fLib.getPropertyKeyValue("url");
		  String username=fLib.getPropertyKeyValue("username");
		  String password=fLib.getPropertyKeyValue("password");
		  
		  WebDriverManager.chromedriver().create();
		  WebDriver driver=new ChromeDriver();
		  driver.get(url);
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//input[@id='usernmae']")).sendKeys(username);
		  driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
		  driver.findElement(By.xpath("//button[@type='submit']")).click();
		  Thread.sleep(2000);
		  
		  driver.findElement(By.xpath("//a[.='Projects']")).click();
		  Thread.sleep(2000);
		  List<WebElement> ProjectIDs = driver.findElements(By.xpath("//tr//td[1]"));
		  
		  for(WebElement projId:ProjectIDs) {
		   if(projId.getText().equalsIgnoreCase(projectId)) {
		    System.out.println("project has been created");
		   }
		   
		  }
		  
		  DataBaseUtility dLib=new DataBaseUtility();
		  dLib.connectToDB();
		  String delete="delete from project where project_id="+"'"+projectId+"'";
		  dLib.executeUpdate(delete);
		  
		  driver.get(url);
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//input[@id='usernmae']")).sendKeys(username);
		  driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
		  driver.findElement(By.xpath("//button[@type='submit']")).click();
		  Thread.sleep(2000);
		  
		  driver.findElement(By.xpath("//a[.='Projects']")).click();
		  Thread.sleep(2000);
		  List<WebElement> ProjIDs = driver.findElements(By.xpath("//tr//td[1]"));
		  boolean flag=true;
		  for(WebElement projId:ProjIDs) {
		   if(projId.getText().equalsIgnoreCase(projectId)) {
		    flag=false;
		   }
		   else {
		    flag=true;
		   }
		   
		  }
		  if(flag=true) {
		   System.out.println("project was deleted");
		  }
		  
		  driver.close();
		  }
		}