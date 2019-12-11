package com.gxuwz.attend.entity;

/**
 * Course entity. @author MyEclipse Persistence Tools
 */

public class Course implements java.io.Serializable {

	// Fields

	private Integer id;
	private String courseId;
	private String courseName;
	private String teacherId;
	private String courseTime;
	private String num;
	private String credit;
	private String period;
	private String room;
	//add
	private Teacher teacher;
	// Constructors

	/** default constructor */
	public Course() {
	}

	/** minimal constructor */
	public Course(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Course(Integer id, String courseId, String courseName, String teacherId, String courseTime, String num,
			String credit, String period, String room) {
		this.id = id;
		this.courseId = courseId;
		this.courseName = courseName;
		this.teacherId = teacherId;
		this.courseTime = courseTime;
		this.num = num;
		this.credit = credit;
		this.period = period;
		this.room = room;
	}

	// Property accessors

	
	
	public Integer getId() {
		return this.id;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCourseId() {
		return this.courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return this.courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getTeacherId() {
		return this.teacherId;
	}

	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}

	public String getCourseTime() {
		return this.courseTime;
	}

	public void setCourseTime(String courseTime) {
		this.courseTime = courseTime;
	}

	public String getNum() {
		return this.num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getCredit() {
		return this.credit;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}

	public String getPeriod() {
		return this.period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getRoom() {
		return this.room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

}