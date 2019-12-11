package com.gxuwz.attend.entity;

/**
 * Classes entity. @author MyEclipse Persistence Tools
 */

public class Classes implements java.io.Serializable {

	// Fields

	private String classesId;
	private String classesName;

	// Constructors

	/** default constructor */
	public Classes() {
	}

	/** minimal constructor */
	public Classes(String classesId) {
		this.classesId = classesId;
	}

	/** full constructor */
	public Classes(String classesId, String classesName) {
		this.classesId = classesId;
		this.classesName = classesName;
	}

	// Property accessors

	public String getClassesId() {
		return this.classesId;
	}

	public void setClassesId(String classesId) {
		this.classesId = classesId;
	}

	public String getClassesName() {
		return this.classesName;
	}

	public void setClassesName(String classesName) {
		this.classesName = classesName;
	}

}