package com.ck.action.Masters;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import com.ck.Bean.Masters.IndustryBean;
import com.ck.Bean.Masters.SpeakerBean;
import com.ck.DAO.Masters.ArticleForm;
import com.ck.DAO.Masters.IndustriesForm;
import com.ck.DAO.Masters.SpeakerForm;
import com.ck.action.ComplianceDispatchAction;

public class IndustriesAction extends ComplianceDispatchAction{
	public ActionForward inserIndustryInfo(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		IndustriesForm  	industryForm  	= 			(IndustriesForm)form;
		boolean 			result			= IndustryBean.insertIndustryInfo(industryForm);
		String 				msg				=null;
		if(result)
		{
			msg="Industry Data has been Inserted Successfully!!";
			request.setAttribute("msg", msg);
		}
		else
		{
			msg="Cannot Insert Data!!";
			request.setAttribute("msg", msg);
		}
		return mapping.findForward("showIndustriesMasterPage");

}

}
