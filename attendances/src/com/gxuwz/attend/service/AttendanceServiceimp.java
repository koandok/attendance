package com.gxuwz.attend.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.gxuwz.attend.dao.AttendanceDao;
import com.gxuwz.attend.entity.Attendance;
import com.gxuwz.attend.entity.Sheet;
@Transactional
public class AttendanceServiceimp implements AttendanceService {
	AttendanceDao attendanceDao;
	

	public List<Sheet> list(String number,String courseId,String courseTime ){
		return attendanceDao.list(number,courseId,courseTime);
	}
	
	
	public void setAttendanceDao(AttendanceDao attendanceDao) {
		this.attendanceDao = attendanceDao;
	}

	public boolean checktime(String courseid,String time){
		return attendanceDao.checktime(courseid, time);
	}

	public void add(Attendance attendance){
		attendanceDao.add(attendance);
	}

	public List<Attendance> sheet(String courseid,String time){
		return attendanceDao.sheet(courseid,time);
	}
	
}
