package com.gxuwz.attend.dao;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;

import com.gxuwz.attend.entity.*;


public class CourseDaoimp extends BaseDao implements CourseDao {
	/**
	 * 查看全部
	 */
	@Override
	public List<Course> findAll(String id) {
		List<Course> result = new ArrayList<>();
		String hql="from Course where teacherId=?";
		Query query=getSession().createQuery(hql);
		query.setString(0, id);
		List<Course> tempList = query.list();
		
		tempList.forEach(v->{	
			Course temp = v;
			Query querys = getSession().createQuery("from Teacher where teaId = ?");
			querys.setString(0, id);
			temp.setTeacher((Teacher)querys.list().get(0));
			result.add(temp);
		});
		return result;
	}
	
	/**
	 * 删除
	 */
	@Override
	public void delete(Course course){
			getSession().delete(course);;
		
	}
	

	/***
	 * 查看单个
	 */
	@Override
	public Course get(Course course){
		String hql="from Course where courseId=? and teacherId=?";
		System.out.println(course.getCourseId());
		System.out.println(course.getTeacherId());
		Query query=getSession().createQuery(hql);
		query.setString(0, course.getCourseId());
		query.setString(1, course.getTeacherId());
		List list= query.list();
		if(!list.isEmpty()){
			return (Course)list.get(0);
		}
		else{
		return null;}
	}
	
	
	/**
	 * 通过课程ID查询
	 * @param tid
	 * @return
	 */
	public boolean get(String courseId){
		String hql="from Course where courseId=?";
		Query query=getSession().createQuery(hql);
		query.setString(0, courseId);
		List list= query.list();
		if(!list.isEmpty()){
			return false;
		}
		else{
		return true;}
	}
	
	public List getbycid(String courseId){
		String hql="from Course where courseId=?";
		Query query=getSession().createQuery(hql);
		query.setString(0, courseId);
		return query.list();

	}
	
	@Override
	public void update(Course course){
		getSession().update(course);
	}
	@Override
	public void save(Course course){
		getSession().save(course);
	}
}
