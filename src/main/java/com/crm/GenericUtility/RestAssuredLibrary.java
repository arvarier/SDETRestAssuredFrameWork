package com.crm.GenericUtility;
import io.restassured.response.*;

public class RestAssuredLibrary {
	
	/**
	 * this method will get the json data through json path from response body
	 * @param resp
	 * @param path
	 * @return
	 */
   
	public String getJsonData(Response response,String path)
	{
		String jsonData=response.jsonPath().get(path);
		return jsonData;
	}
}
