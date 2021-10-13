package com.crm.vtiger.genericUtilies;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;
import com.sun.jdi.connect.spi.Connection;

public class DataBaseData {
	java.sql.Connection con=null;
	ResultSet result=null;
	Driver driverref;
	
	public void ConnectionDB() throws SQLException {
		
	
	DriverManager.registerDriver(driverref);
	con=DriverManager.getConnection("http://localhost:8888","root","root");
	}
	
	public void closeDB() throws SQLException
	{
		con.close();
	}
	public String getDatafromDB(String query,int columnindex) throws SQLException {
	 String value =null;	
	result=con.createStatement().executeQuery(query);
	while(result.next())
		{
	  value=result.getString(columnindex);
		}
		return value;
	}

	public String getDataFromDB(String query,int colname,String expData) throws SQLException
	{
		 boolean flag = false;
		 result=con.createStatement().executeQuery(query);
		 while(result.next())
		 {
			 if(result.getString(colname).equalsIgnoreCase(expData))
			 {
				 flag=true;
				 break;
			 }
		 }
	
         if(flag)
        {
	     System.out.println(expData+"data verified");
	      return expData;
     	}
         else
         {
        	 System.out.println(expData+"data  not verified");
   	      return expData;
         }

}
}
	
	
