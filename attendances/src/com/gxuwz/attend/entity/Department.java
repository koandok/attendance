package com.gxuwz.attend.entity;

/**
 * Department entity. @author MyEclipse Persistence Tools
 */

public class Department implements java.io.Serializable {

	// Fields

	private Integer depId;
	private String depName;

	// Constructors

	/** default constructor */
	public Department() {
	}

	/** minimal constructor */
	public Department(Integer depId) {
		this.depId = depId;
	}

	/** full constructor */
	public Department(Integer depId, String depName) {
		this.depId = depId;
		this.depName = depName;
	}

	// Property accessors

	public Integer getDepId() {
		return this.depId;
	}

	public void setDepId(Integer depId) {
		this.depId = depId;
	}

	public String getDepName() {
		return this.depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

}