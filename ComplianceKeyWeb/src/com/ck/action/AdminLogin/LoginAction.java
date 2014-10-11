package com.ck.action.AdminLogin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.ck.Bean.LoginBean;
import com.ck.DAO.LoginForm;
import com.ck.action.ComplianceDispatchAction;

public class LoginAction extends ComplianceDispatchAction{
	public ActionForward checkLogin(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		LoginForm     loginForm   = (LoginForm) form;
		LoginBean		loginBean = new LoginBean();
		String emailid  = loginForm.getEmailid()!=null && loginForm.getEmailid().length()>0?loginForm.getEmailid().trim():"";
		String password = loginForm.getPassWord()!=null && loginForm.getPassWord().length()>0 ?loginForm.getPassWord().trim():"" ;
		ArrayList<String> userdetails = loginBean.checkLogin(emailid, password);
		if(!userdetails.isEmpty())
		{
			return mapping.findForward("ShowHomePage");
		}
		else
		{
			return mapping.findForward("ShowIndexPage");
		}
		
	}

}
