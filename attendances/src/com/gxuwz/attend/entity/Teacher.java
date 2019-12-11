package com.gxuwz.attend.entity;

/**
 * Teacher entity. @author MyEclipse Persistence Tools
 */

public class Teacher implements java.io.Serializable {

	// Fields

	private String teaId;
	private String teaName;
	private String depId;

	// Constructors

	/** default constructor */
	public Teacher() {
	}

	/** minimal constructor */
	public Teacher(String teaId) {
		this.teaId = teaId;
	}

	/** full constructor */
	public Teacher(String teaId, String teaName, String depId) {
		this.teaId = teaId;
		this.teaName = teaName;
		this.depId = depId;
	}

	// Property accessors

	public String getTeaId() {
		return this.teaId;
	}

	public void setTeaId(String teaId) {
		this.teaId = teaId;
	}

	public String getTeaName() {
		return this.teaName;
	}

	public void setTeaName(String teaName) {
		this.teaName = teaName;
	}

	public String getDepId() {
		return this.depId;
	}

	public void setDepId(String depId) {
		this.depId = depId;
	}

}