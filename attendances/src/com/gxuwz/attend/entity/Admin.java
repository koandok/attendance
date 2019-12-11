package com.gxuwz.attend.entity;

/**
 * Admin entity. @author MyEclipse Persistence Tools
 */

public class Admin implements java.io.Serializable {

	// Fields

	private String adminId;
	private String adminPwd;
	private String adminType;

	// Constructors

	/** default constructor */
	public Admin() {
	}

	/** minimal constructor */
	public Admin(String adminId) {
		this.adminId = adminId;
	}

	/** full constructor */
	public Admin(String adminId, String adminPwd, String adminType) {
		this.adminId = adminId;
		this.adminPwd = adminPwd;
		this.adminType = adminType;
	}

	// Property accessors

	public String getAdminId() {
		return this.adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getAdminPwd() {
		return this.adminPwd;
	}

	public void setAdminPwd(String adminPwd) {
		this.adminPwd = adminPwd;
	}

	public String getAdminType() {
		return this.adminType;
	}

	public void setAdminType(String adminType) {
		this.adminType = adminType;
	}

}