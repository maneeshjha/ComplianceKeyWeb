package com.ck.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.ck.Bean.CommonMethodBean;

public class CommonMethodAction extends ComplianceDispatchAction {
	public ActionForward getStatusWiseEmpList(ActionMapping mapping,ActionForm form, HttpServletRequest request, HttpServletResponse response)throws IOException,SQLException
	{
		
		PrintWriter				writer				=	response.getWriter();
		String					empName			=	request.getParameter("empName")== null ? "" : request.getParameter("empName").trim().toUpperCase();
		String					status				=	request.getParameter("status");
		CommonMethodBean		commonMethodBean		= new CommonMethodBean();
		JSONArray				empList			=	commonMethodBean.getSpeakerNameForTTS(empName, status);
		try
		{
			JSONObject		object				=	new JSONObject();
			object.put("DataList", empList);
			
			String  result		=	object.toString();
			writer.println(result);
		}
		catch (JSONException e) 
		{
			System.out.println("Error in CommonMethodAction:getStatusWiseempList():"+e);
		}
		return null;
	}

}
