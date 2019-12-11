package com.gxuwz.attend.service;

import java.util.List;

import com.gxuwz.attend.entity.Course;

public interface CourseService {
	List<Course> findAll(String id);

	void delete(Course course);

	void update(Course course);

	boolean save(Course Course);

	Course get(Course course);
	void get(String courseId);
	public List getbycid(String courseId);
}
