package com.gxuwz.attend.service;

import org.springframework.transaction.annotation.Transactional;

import com.gxuwz.attend.dao.LoginDao;
import com.gxuwz.attend.entity.Admin;
@Transactional
public class LoginServiceimp implements LoginService {
	LoginDao loginDao;

	public String login(Admin admin){
		String a="login";
		if(loginDao.login(admin)){
		if(admin.getAdminType().equals("A")){
			a = "studnet";
		}if(admin.getAdminType().equals("B")){
			a = "teacher";
		}if(admin.getAdminType().equals("C")){
			a=  "user";
		}}
		return a;
	}
	
	
	
	
	
	//gt
	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}
	
}	
