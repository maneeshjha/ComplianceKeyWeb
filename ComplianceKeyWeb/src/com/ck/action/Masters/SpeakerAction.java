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

import com.ck.DAO.Masters.SpeakerForm;
import com.ck.action.ComplianceDispatchAction;

public class SpeakerAction extends ComplianceDispatchAction{
	//@author:Maneesh
	//purpose:To update speaker Info
	public ActionForward updateSpeakerInfo(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
				SpeakerForm  				speakerForm  	= 			(SpeakerForm)form;
				String 						speakerName		=   		speakerForm.getSpeakerName() ;
				String 						description		=			speakerForm.getDescription();
				String 						status			=			speakerForm.getStatus();
				FormFile					file			=			speakerForm.getFile();
				String   					filePath		=			"D:"+"/ComplianceKey";
				File 						folder			= 			new File(filePath);
				String 						fileName		=			file.getFileName();
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
						
					}
					
				}
			
		return null;
	
		}
	

}
