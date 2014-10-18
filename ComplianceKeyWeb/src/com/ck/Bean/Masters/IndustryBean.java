package com.ck.Bean.Masters;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.ck.DAO.Masters.IndustriesForm;
import com.ck.DAO.Masters.SpeakerForm;
import com.ck.DBConnection.DBConnection;
import com.ck.DAO.CommonForm;

public class IndustryBean {
	public static boolean insertIndustryInfo(IndustriesForm form)
	{
		Connection			   con			=	null;
		String				   query		=	"";		
		PreparedStatement		pst			=	null;
		String               	user		=	"maneesh";
		int						count		=	0;
		boolean 				flag		= false;
		try
		{
			con=DBConnection.getConnection();
			query="INSERT INTO industriesmaster(industriesname, description, status,createdon,createdby) VALUES (?,?,?,sysdate(),?)";
			pst		=	con.prepareStatement(query);
			pst.setString(1, form.getIndustryName());
			pst.setString(2, form.getDescription());
			pst.setString(3, form.getStatus());
			pst.setString(4,user);
			count=pst.executeUpdate();
			if(count>0)
			{
				flag=true;
			}
			
		}
		catch(Exception e)
		{
			
		}
		return flag;
		
	}
	public static ArrayList<CommonForm> getIndustriesList()
	{
		Connection			   con			=	null;
		ArrayList<CommonForm>  dataList		=	new    ArrayList<CommonForm>();
		String				   query		=	"";	
		Statement  				stmt = null		;
		ResultSet   			rs			= null;
		try
		{
			con=DBConnection.getConnection();
			query="select industriesid,industriesname from industriesmaster";
			stmt=con.createStatement();
			rs=stmt.executeQuery(query);
			while(rs.next())
			{
				CommonForm		cForm		=	new  CommonForm();
				cForm.setField1(rs.getString(1));//industriestid
				cForm.setField2(rs.getString(2));//industryname
				dataList.add(cForm);
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Error in IndustriesBean.getIndustryList():"+e);
		}
		return dataList;
		
}
}
