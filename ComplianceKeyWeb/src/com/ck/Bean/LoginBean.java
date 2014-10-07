package com.ck.Bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.ck.DBConnection.DBConnection;


public class LoginBean {
	public ArrayList<String> checkLogin(String username,String userpass)
	{
		ArrayList<String> retList 	= 	new ArrayList<String>();
		String retResult	=	"invalid";
		Connection con		=	null;
		PreparedStatement	st		=	null;
		ResultSet rs		=	null;
		con	=	DBConnection.getConnection();
		String query	=	" select id,username from user where email=? and password=? "; 
		
		try{
			st=	con.prepareStatement(query);
			st.setString(1, username);
			st.setString(2, userpass);
			rs=st.executeQuery();
			if(rs.next())
			{
				String userId		=	rs.getString(1);//USERID
				String userName 	= 	rs.getString(2);//LOGIN_NAME
				retResult			=	"valid";
				retList.add(retResult);
				retList.add(userId);
				retList.add(userName);		
			}
			if(st!=null)
				st.close();
			
		}catch(Exception e)
		{
				System.out.println("Error in LoginBean.checkLogin : "+e);
		}finally 
		{
			try
			{
				if(con != null)
				{	
					con.close();
					con = null;
				}	
			}catch(Exception s)
			{
				System.out.println("Error in closing connection in LoginBean.checkLogin : "+s);
			}
		}	
		return retList;
	}

}
