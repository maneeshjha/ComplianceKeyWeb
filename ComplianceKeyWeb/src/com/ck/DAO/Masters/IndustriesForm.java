package com.ck.DAO.Masters; 

import javax.servlet.http.HttpServletRequest; 
import org.apache.struts.action.ActionForm; 
import org.apache.struts.action.ActionMapping; 
 
 
public class IndustriesForm extends ActionForm{ 
	private String industryID;
	private String industryName;
	private String description;
	private String status;
	
	@Override
	public void reset(final ActionMapping mapping,final  HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.description=null;
		this.industryID=null;
		this.industryName=null;
		this.status=null;
		
	}
	public String getStatus() {
		return status;
	}
	public String getIndustryID() {
		return industryID;
	}
	public void setIndustryID(final String industryID) {
		this.industryID = industryID;
	}
	public void setStatus(final String status) {
		this.status = status;
	}
	public String getIndustryName() {
		return industryName;
	}
	public void setIndustryName(final String industryName) {
		this.industryName = industryName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(final String description) {
		this.description = description;
	}
}
