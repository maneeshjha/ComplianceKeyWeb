package com.ck.Bean.Masters;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.ck.DAO.Masters.SpeakerForm;
import com.ck.DBConnection.DBConnection;

public class SpeakerBean {
	public static boolean updateUserInfo(SpeakerForm form)
	{
		Connection			   con			=	null;
		Statement			   st			=	null;
		ResultSet			   rs			=	null;
		String				   query		=	"";		
		PreparedStatement		pst			=	null;
		int						count		=	0;
		boolean 				flag		= false;
		try
		{
			con=DBConnection.getConnection();
			query="INSERT INTO speakermaster(speakerName, description, photoname) VALUES (?,?,?)";
			pst		=	con.prepareStatement(query);
			pst.setString(1, form.getSpeakerName());
			pst.setString(2, form.getDescription());
			pst.setString(3, form.getPhotoName());
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

}
