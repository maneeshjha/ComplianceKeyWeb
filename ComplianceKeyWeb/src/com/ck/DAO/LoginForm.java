package com.ck.DAO;

import org.apache.struts.action.ActionForm;

public class LoginForm extends ActionForm {
	private String passWord;
	private String emailid;
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	
}
