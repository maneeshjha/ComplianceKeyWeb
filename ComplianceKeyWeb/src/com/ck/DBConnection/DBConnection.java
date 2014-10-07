package com.ck.DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
public static Connection con	=	null;
	
	public static Connection getConnection (){
		
		String userName="root";
		String password="root";
		try 
		{
			String driverName = "org.gjt.mm.mysql.Driver";
			Class.forName(driverName);
		}
		 catch(Exception e) 
		{
		 	System.out.println("error in loading driver "+e);
		}
		 
		try
		{
			String serverName = "localhost:3306";
			String mydatabase = "compliancekey";						
			
			String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
			
			con = DriverManager.getConnection(url, userName, password);
			
		}
		catch (Exception e)
		{
			System.out.println("Error in DBConnect.connect() :- " + e);
		}
		return con;
		
	}
	
	public  void Disconnect()
	{

		try
		{
			if(con != null)
			{
				con.close();
			}
		}catch(SQLException s)
		{
			System.out.println("Error in DBConnect.Disconnect() :- "+s);
		}
	}


}
