package com.crm.GenericUtility;

import java.sql.SQLException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseAPIClass {
	DataBaseUtility dLib=new DataBaseUtility();
	JavaUtility jLib=new JavaUtility();
	
	@BeforeSuite
	public void bsConfig()throws SQLException
	{
		dLib.connectToDB();
		
	}

	@AfterSuite
	public void asConfig()
	{
		dLib.closeDB();
	}
}
