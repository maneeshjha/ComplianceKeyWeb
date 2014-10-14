package com.ck.Bean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.json.JSONArray;
import org.json.JSONObject;

import com.ck.DBConnection.DBConnection;

public class CommonMethodBean {
	public JSONArray getSpeakerNameForTTS(String speakerName,String status)
	{
		
		Connection			   	con			 =	null;
		Statement			   	st			 =	null;
		ResultSet			   	rs			 =	null;
		JSONArray				speakerArray =	new JSONArray();
		String				   query		 =	"";
		
		try
		{
			query		=		"	select 		speakerid,speakername 	" +
								"	from 		speakermaster		" +
								"	where 		0=0			" ;
								if(!speakerName.isEmpty())
								{
									query	+=	"	and	speakername	like	'"+speakerName+"%'	" ;
								}
								if(status != null && status.length() > 0)
								{
									query	+=	"	and		status	=	'"+status+"'	" ;
								}
								query	+=	"	order by 	speakername ";
			
			con			=	DBConnection.getConnection();
			st			=	con.createStatement();
			rs			=	st.executeQuery(query);
			while(rs.next())
			{
				JSONObject	jsonObject	= 	new JSONObject();
				jsonObject.put("value", rs.getString(1));
				jsonObject.put("name", rs.getString(2));
				speakerArray.put(jsonObject);
			}
			if(st!=null)
				st.close();
		}
		catch (Exception e) 
		{
			System.out.println("Error in CommonMethodBean.getSpeakerNameForTTS():"+e);
		}
		finally
		{
			try
			{
				if(con != null)
				{
					con.close();
					con	 =	null;					
				}
			}
			catch (Exception e) 
			{
				System.out.println("Exception in Closing DB Connection CommonMethodBean.getSpeakerNameForTTS():"+e);
			}
		}
		return speakerArray;
	}
}
