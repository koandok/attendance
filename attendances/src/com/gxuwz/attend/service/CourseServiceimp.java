package com.gxuwz.attend.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.transaction.annotation.Transactional;

import com.gxuwz.attend.dao.CourseDao;
import com.gxuwz.attend.entity.Course;
@Transactional
public class CourseServiceimp implements CourseService {
	CourseDao courseDao;

	
	
	public List<Course> findAll(String id){
		return courseDao.findAll(id);
	}
	
	
	
	public Course get(Course course){
		return courseDao.get(course);
	
	}

	
	public void delete(Course course){
		courseDao.delete(course);
	}
	
	
	
	public boolean save(Course course){
		if(courseDao.get(course.getCourseId())){
		courseDao.save(course);
		return true;
		}else{
			return false;
		}
	}
	
	public void update(Course course){
		courseDao.update(course);
	}
	
	public List getbycid(String courseId){
		return courseDao.getbycid(courseId);
	}
	
	public void get(String courseId){
		HttpServletResponse response = ServletActionContext.getResponse();
		try{
		if(courseDao.get(courseId)){  
            response.getWriter().write("true");//此值jquery可以接收到    
        }else{
            response.getWriter().write("false");
        }

		
	}catch (Exception e) {
		e.printStackTrace();
	}
	}
	
	
	
	
	
	
	public void setCourseDao(CourseDao courseDao) {
		this.courseDao = courseDao;
	}
	
	
}
