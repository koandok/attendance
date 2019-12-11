package com.gxuwz.attend.dao;

import java.util.List;

import org.hibernate.Query;

import com.gxuwz.attend.entity.Admin;

public class LoginDaoimp extends BaseDao implements LoginDao {
	
	public boolean login (Admin admin){
		String hql="from Admin where adminId=? and adminPwd=?";
		Query query=getSession().createQuery(hql);
		query.setString(0, admin.getAdminId());
		query.setString(1, admin.getAdminPwd());
		List list= query.list();
		if(!list.isEmpty()){
			return true;
		}
		else{
		return false;
		}
	}
	
	
	
	
	
	
	
}
