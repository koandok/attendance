package com.gxuwz.attend.dao;

import java.util.List;

import com.gxuwz.attend.entity.Course;

public interface CourseDao {

	List<Course> findAll(String id);

	void delete(Course course);

	void update(Course course);

	void save(Course Course);

	Course get(Course course);
	
	boolean get(String courseId);
	public List getbycid(String courseId);
}
