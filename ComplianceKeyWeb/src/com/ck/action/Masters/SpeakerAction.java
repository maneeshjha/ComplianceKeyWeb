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

import com.ck.Bean.Masters.SpeakerBean;
import com.ck.DAO.Masters.SpeakerForm;
import com.ck.action.ComplianceDispatchAction;

public class SpeakerAction extends ComplianceDispatchAction{
	
	public ActionForward showSpeakerMasterPage(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		SpeakerForm         speakerForm   = (SpeakerForm)form;
		speakerForm.reset(mapping, request);
		speakerForm.setStatus("ACTIVE");
		return mapping.findForward("showSpeakerMasterPage");
		
	}
	//@author:Maneesh
	//purpose:To update speaker Info
	public ActionForward insertSpeakerInfo(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
				SpeakerForm  				speakerForm  	= 			(SpeakerForm)form;
				FormFile					file			=			speakerForm.getFile();
				String   					filePath		=			"D:"+"/ComplianceKey"+"/SpeakerPics";
				File 						folder			= 			new File(filePath);
				String 						fileName		=			file.getFileName();
				String 						fileMessage		=				"";
				String						message		=	"";
				boolean 					success		= false;
				speakerForm.setPhotoName(fileName);
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
				success=SpeakerBean.insertUserInfo(speakerForm);
				
			}
			if(success)
			{
				message="Speaker Data has been saved Successfully";
				request.setAttribute("msg", message);
			
			}
			else
			{
				message="Cannot Save Speaker Data";
				request.setAttribute("msg", message);
			}
		return mapping.findForward("showSpeakerMasterPage");
	
		}
	

}
