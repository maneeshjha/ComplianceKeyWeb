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
	public ActionForward getStatusWiseSpeakerList(ActionMapping mapping,ActionForm form, HttpServletRequest request, HttpServletResponse response)throws IOException,SQLException
	{
		
		PrintWriter				writer				=	response.getWriter();
		String					speakerName			=	request.getParameter("spkName")== null ? "" : request.getParameter("spkName").trim().toUpperCase();
		String					status				=	request.getParameter("status");
		CommonMethodBean		commonMethodBean		= new CommonMethodBean();
		JSONArray				speakerList			=	commonMethodBean.getSpeakerNameForTTS(speakerName, status);
		try
		{
			JSONObject		object				=	new JSONObject();
			object.put("DataList", speakerList);
			
			String  result		=	object.toString();
			writer.println(result);
		}
		catch (JSONException e) 
		{
			System.out.println("Error in CommonMethodAction:getStatusWiseSpeakerList():"+e);
		}
		return null;
	}

}
