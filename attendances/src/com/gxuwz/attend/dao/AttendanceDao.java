package com.gxuwz.attend.dao;

import java.util.List;

import com.gxuwz.attend.entity.Attendance;
import com.gxuwz.attend.entity.Sheet;

public interface AttendanceDao {
	
	public List<Sheet> list(String number,String courseId,String courseTime );

	public void add(Attendance attendance);
	
	public boolean checktime(String courseid,String time);
	public List<Attendance> sheet(String courseid,String time);
}
