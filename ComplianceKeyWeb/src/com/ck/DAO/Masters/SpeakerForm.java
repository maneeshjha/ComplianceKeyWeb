
package com.ck.DAO.Masters;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

public class SpeakerForm extends ActionForm{
	private String speakerID;
	private String speakerName;
	private String photoName;
	private String description;
	private String status;
	private FormFile file;
	public FormFile getFile() {
		return file;
	}
	public void setFile(FormFile file) {
		this.file = file;
	}
	public String getSpeakerID() {
		return speakerID;
	}
	public void setSpeakerID(String speakerID) {
		this.speakerID = speakerID;
	}
	public String getSpeakerName() {
		return speakerName;
	}
	public void setSpeakerName(String speakerName) {
		this.speakerName = speakerName;
	}
	public String getPhotoName() {
		return photoName;
	}
	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

}
