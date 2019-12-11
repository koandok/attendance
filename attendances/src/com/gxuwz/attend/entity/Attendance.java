package com.gxuwz.attend.entity;

/**
 * Attendance entity. @author MyEclipse Persistence Tools
 */

public class Attendance implements java.io.Serializable {

	// Fields

	private Integer id;
	private String studentId;
	private String courseId;
	private String stats;
	private String time;
	//add
	private Student student;
	private Course course;
	// Constructors
	
	/** default constructor */
	public Attendance() {
	}

	/** full constructor */
	public Attendance(String studentId, String courseId, String stats, String time) {
		this.studentId = studentId;
		this.courseId = courseId;
		this.stats = stats;
		this.time = time;
	}

	// Property accessors

	
	
	public Integer getId() {
		return this.id;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
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

	public String getStudentId() {
		return this.studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getCourseId() {
		return this.courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getStats() {
		return this.stats;
	}

	public void setStats(String stats) {
		this.stats = stats;
	}

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}