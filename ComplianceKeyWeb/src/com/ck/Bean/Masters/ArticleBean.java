package com.ck.Bean.Masters;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.ck.DAO.Masters.ArticleForm;
import com.ck.DAO.Masters.SpeakerForm;
import com.ck.DBConnection.DBConnection;

public class ArticleBean {
	public static boolean insertArticleInfo(ArticleForm form)
	{
		Connection			   con			=	null;
		String				   query		=	"";		
		PreparedStatement		pst			=	null;
		int						count		=	0;
		boolean 				flag		= false;
		String					user		=	"maneesh";
		try
		{
			con=DBConnection.getConnection();
			query="INSERT INTO articlemaster(articlename, articlepath, description,status,industriesid,createdon,createdby) VALUES (?,?,?,?,?,sysdate(),?)";
			pst		=	con.prepareStatement(query);
			pst.setString(1, form.getArticleName());
			pst.setString(2, form.getArticlePath());
			pst.setString(3, form.getDescription());
			pst.setString(4, form.getStatus());
			pst.setString(5, form.getIndustryID());
			pst.setString(6, user);
			count=pst.executeUpdate();
			if(count>0)
			{
				flag=true;
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return flag;
		
	}

}
