
package com.ck.DAO.Masters;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

public class SpeakerForm extends ActionForm{
	private String speakerID;
	private String speakerName;
	private String photoName;
	private String description;
	private String status;
	private FormFile file;
	/**
	* 
	*
	* @author Maneesh
	*/
	public FormFile getFile() {
		return file;
	}
	@Override
	public void reset(final ActionMapping mapping, final HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.description=null;
		this.file=null;
		this.photoName=null;
		this.speakerName=null;
		this.status=null;
		this.speakerID=null;
	}
	public void setFile(FormFile file) {
		this.file = file;
	}
	public String getSpeakerID() {
		return speakerID;
	}
	public void setSpeakerID(final String speakerID) {
		this.speakerID = speakerID;
	}
	public String getSpeakerName() {
		return speakerName;
	}
	public void setSpeakerName(final String speakerName) {
		this.speakerName = speakerName;
	}
	public String getPhotoName() {
		return photoName;
	}
	public void setPhotoName(final String photoName) {
		this.photoName = photoName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(final String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(final String status) {
		this.status = status;
	}
	

}
