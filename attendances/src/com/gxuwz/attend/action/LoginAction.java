package com.gxuwz.attend.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.gxuwz.attend.entity.Admin;
import com.gxuwz.attend.service.LoginService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction extends ActionSupport implements ModelDriven<Admin>{
	Admin admin = new Admin();
	LoginService loginService;
	
	
	
	public String login(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();	
		session.setAttribute("adminID", admin.getAdminId());
		return 	loginService.login(admin);
	}
	
	
	public String loginout(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();	
		session.invalidate();
		return 	"login";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//gt
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	@Override
	public Admin getModel() {
		// TODO Auto-generated method stub
		return admin;
	}
}
