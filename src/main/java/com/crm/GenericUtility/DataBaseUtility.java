package com.crm.GenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class DataBaseUtility {
	static Driver driverRef;
	static Connection connection;
	static ResultSet result;
	/**
	 * This method is used to connect to DB
	 * @param DBname
	 */
	public void connectToDB()
	{
		try
		{
			driverRef=new Driver();
			DriverManager.registerDriver(driverRef);
			connection=DriverManager.getConnection(IConstants.DbUrl,IConstants.DBUsername,IConstants.DBPassword);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
/**
 * this method is used to close DB connection
 */
	public void closeDB()
	{
		try
		{
			connection.close();
		}
		catch(Exception e)
		{
			//handle exception
			
		}
	}
	/**
	 * @param query
	 * @param columnNum
	 * @param exepectedData
	 * @return
	 * @throws SQLException
	 */
	public ResultSet executeQuery(String query) throws SQLException
	{
		result=connection.createStatement().executeQuery(query);
		return result;
        	
        }
	/**
	 * this method is used to perform execute updates
	 * @param query
	 * @throws SQLException
	 */
	public void executeUpdate(String query) throws SQLException
	{
		int res=connection.createStatement().executeUpdate(query);
		if(res==1)
			System.out.println("data is updated");
		else
			System.out.println("data is not updated");
		
	}
	}
