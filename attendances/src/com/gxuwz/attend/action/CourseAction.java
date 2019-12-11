package com.gxuwz.attend.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.gxuwz.attend.entity.Course;
import com.gxuwz.attend.service.CourseService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CourseAction extends ActionSupport implements ModelDriven<Course>{
	private Course course = new Course();
	CourseService courseService;
	List<Course> courselist;
	
	

	/**
	 * 显示
	 * @return
	 */
	public String list (){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();	
		String adminid = (String)session.getAttribute("adminID");
		courselist = courseService.findAll(adminid);
		return "courselist";
	}
	/**
	 * 删除
	 * @return
	 */
	public String delete(){
		course = courseService.get(course);
		courseService.delete(course);
		return list();
	}
	
	/**
	 * 添加
	 * @return
	 */
	public String add(){	
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();	
		String adminid = (String)session.getAttribute("adminID");
		course.setTeacherId(adminid);
		if(courseService.save(course)){
			return list();
		}
		return "error";
	}
	/**
	 * 跳转修改页面
	 * @return
	 */
	public String get(){
		HttpServletRequest request = ServletActionContext.getRequest();
		course = courseService.get(course);
		request.setAttribute("course", course);
		return "get";
	}
	/**
	 * 修改
	 * @return
	 */
	public String update(){
		courseService.update(course);
		return list();
	}
	
	public String listbyid(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();	
		String adminid = (String)session.getAttribute("adminID");
		courselist = courseService.findAll(adminid);
		request.setAttribute("courselist", courselist);
		return "attendancelist";
	}
	
	/**
	 * 验证
	 * @return
	 */
	public void check(){
		courseService.get(course.getCourseId());
	}
	
	
	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}


	public List<Course> getCourselist() {
		return courselist;
	}



	public void setCourselist(List<Course> courselist) {
		this.courselist = courselist;
	}


	@Override
	public Course getModel() {
		// TODO Auto-generated method stub
		return course;
	}

}
