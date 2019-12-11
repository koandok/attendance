package com.gxuwz.attend.entity;

/**
 * Student entity. @author MyEclipse Persistence Tools
 */

public class Student implements java.io.Serializable {

	// Fields

	private String stuId;
	private String stuName;
	private String classesId;

	// Constructors

	/** default constructor */
	public Student() {
	}

	/** minimal constructor */
	public Student(String stuId) {
		this.stuId = stuId;
	}

	/** full constructor */
	public Student(String stuId, String stuName, String classesId) {
		this.stuId = stuId;
		this.stuName = stuName;
		this.classesId = classesId;
	}

	// Property accessors

	public String getStuId() {
		return this.stuId;
	}

	public void setStuId(String stuId) {
		this.stuId = stuId;
	}

	public String getStuName() {
		return this.stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getClassesId() {
		return this.classesId;
	}

	public void setClassesId(String classesId) {
		this.classesId = classesId;
	}

}