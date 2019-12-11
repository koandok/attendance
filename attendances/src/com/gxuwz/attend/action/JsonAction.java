package com.gxuwz.attend.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.gxuwz.attend.entity.Course;
import com.gxuwz.attend.service.CourseService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class JsonAction extends ActionSupport implements ModelDriven<Course>{
	private Course course = new Course();
	private CourseService courseService;
	private Map<String, Object>  map ;
	String courseId;
	
	/**
	 * 二级联动下拉菜单（上课时间）
	 * @return
	 */
	public String gettime(){
		map = new HashMap<String, Object>();
		List<Course> courses = courseService.getbycid(course.getCourseId());
		//System.out.println(((Course)courses.get(0)).getCourseTime());
		String respBody = JSON.toJSONString(courses);
		map.put("courses", respBody);
		return SUCCESS;
	}
	
	

	
	public String getCourseId() {
		return courseId;
	}




	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}




	public CourseService getCourseService() {
		return courseService;
	}

	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public Course getModel() {
		// TODO Auto-generated method stub
		return course;
	}
}
