package com.gxuwz.attend.entity;

/**
 * Sheet entity. @author MyEclipse Persistence Tools
 */

public class Sheet implements java.io.Serializable {

	// Fields

	private Integer id;
	private String teacherId;
	private String courseId;
	private String studentId;
	//add
	private Student student;
	// Constructors

	/** default constructor */
	public Sheet() {
	}

	/** minimal constructor */
	public Sheet(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Sheet(Integer id, String teacherId, String courseId, String studentId) {
		this.id = id;
		this.teacherId = teacherId;
		this.courseId = courseId;
		this.studentId = studentId;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTeacherId() {
		return this.teacherId;
	}

	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}

	public String getCourseId() {
		return this.courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getStudentId() {
		return this.studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

}