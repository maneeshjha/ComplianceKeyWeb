package com.ck.action.Masters;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import com.ck.Bean.Masters.ArticleBean;
import com.ck.Bean.Masters.IndustryBean;
import com.ck.Bean.Masters.SpeakerBean;
import com.ck.DAO.CommonForm;
import com.ck.DAO.Masters.ArticleForm;
import com.ck.DAO.Masters.SpeakerForm;
import com.ck.action.ComplianceDispatchAction;

public class ArticleAction extends ComplianceDispatchAction{
	public ActionForward showArticleMasterPage(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		ArticleForm         articleForm   = (ArticleForm)form;
		ArrayList <CommonForm>  reqIndustryList   = IndustryBean.getIndustriesList();
		articleForm.reset(mapping, request);
		articleForm.setStatus("ACTIVE");
		request.setAttribute("reqIndustryList", reqIndustryList);
		return mapping.findForward("showArticleMasterPage");
		
	}
	public ActionForward insertArticleInfo(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		ArticleForm         articleForm   = (ArticleForm)form;
		FormFile					file			=			articleForm.getFile();
		ArrayList <CommonForm>  reqIndustryList   = IndustryBean.getIndustriesList();
		String   					filePath		=			"D:"+"/ComplianceKey"+"/Articles";
		File 						folder			= 			new File(filePath);
		String 						fileName		=			file.getFileName();
		String 						fileMessage		=				"";
		String						message		=	"";
		boolean 					success		= false;
		articleForm.setArticlePath(filePath);
		if(!folder.exists())
		{
			folder.mkdir();
		}
		if(!fileName.isEmpty())
		{
			File newFile = new File(filePath, fileName);
			if(!newFile.exists())
			{
				FileOutputStream   fos		= new FileOutputStream(newFile);
				fos.write(file.getFileData());
				fos.flush();
				fos.close();
				fileMessage="Successfuly Saved";
				
			}
			
		}
	if(!fileMessage.isEmpty())
	{
		success=ArticleBean.insertArticleInfo(articleForm);
		
	}
	if(success)
	{
		message="Article Data has been saved Successfully";
		request.setAttribute("reqIndustryList", reqIndustryList);
		request.setAttribute("msg", message);
	
	}
	else
	{
		message="Cannot Save Article Data";
		request.setAttribute("reqIndustryList", reqIndustryList);
		request.setAttribute("msg", message);
	}
return mapping.findForward("showArticleMasterPage");
		
		
	}
}
	
