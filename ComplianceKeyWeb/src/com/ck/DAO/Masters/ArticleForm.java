package com.ck.DAO.Masters; 

import javax.servlet.http.HttpServletRequest; 

import org.apache.struts.action.ActionForm; 
import org.apache.struts.action.ActionMapping; 
import org.apache.struts.upload.FormFile;
 
 
public class ArticleForm extends ActionForm{ 
	private String articleId;
	private String articleName;
	private FormFile file;
	public String getArticleId() {
		return articleId;
	}
	
	@Override
	public void reset(final ActionMapping mapping, final HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.articleId=null; 
		this.articleName=null;
		this.file=null;
		
	}

	public void setArticleId(final String articleId) {
		this.articleId = articleId;
	}
	public String getArticleName() {
		return articleName;
	}
	public void setArticleName(final String articleName) {
		this.articleName = articleName;
	}
	public FormFile getFile() {
		return file;
	}
	public void setFile(final FormFile file) {
		this.file = file;
	}
	
}
