package com.gxuwz.attend.action;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.CollectionUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gxuwz.attend.entity.Attendance;
import com.gxuwz.attend.entity.Sheet;
import com.gxuwz.attend.service.AttendanceService;
import com.gxuwz.attend.util.DateUtil;
import com.gxuwz.attend.util.XmlUtil;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AttendenceAction extends ActionSupport implements ModelDriven<Sheet>{
	Sheet sheet = new Sheet();
	AttendanceService attendanceService;
	List<Sheet> sheetlist;
	List<Attendance> attendancelist;
	String table_data;
	
	/**
	 * 显示考勤名单
	 * @return
	 */
	public String list(){
		HttpServletRequest request = ServletActionContext.getRequest();
				String number = request.getParameter("number");
				String courseId = request.getParameter("courseId");                  
				String courseTime = request.getParameter("courseTime");
				sheetlist = attendanceService.list(number,courseId,courseTime);
				//request.setAttribute("sheetlist", sheetlist);
				request.getSession().setAttribute("sheetlist", sheetlist);;
		return "list";
	}
	/**
	 * 考勤
	 * @return
	 */
	public String add(){
		HttpServletRequest req = ServletActionContext.getRequest();
		JSONArray json = JSONArray.parseArray(table_data);
		DateUtil date = new DateUtil();
		String time = date.DateNow();
		JSONObject jo = JSONObject.parseObject(json.get(0).toString());
		if(attendanceService.checktime(jo.getString("课程id"), time)){
		for (int i = 0; i < json.size(); i++) {
			Attendance attendance = new Attendance();
			jo = JSONObject.parseObject(json.get(i).toString());
			attendance.setStudentId(jo.getString("学号"));
			attendance.setStats(jo.getString("考勤状态"));
			attendance.setCourseId(jo.getString("课程id"));
			System.out.println("课程="+attendance.getCourseId());
			attendanceService.add(attendance);
		}
			return sheet(jo.getString("课程id"),time);
		 }else{
		req.setAttribute("message", "当天已考勤");
		return list();
		}
	}
	
	/**
	 * 考勤结果显示
	 * @return
	 */
	public String sheet(String courseid,String time){
		HttpServletRequest request = ServletActionContext.getRequest();
		attendancelist = attendanceService.sheet(courseid,time);
		return "sheet";
	}
	/**
	 * 显示全部
	 * @return
	 */
	public String sheet(){
		HttpServletRequest request = ServletActionContext.getRequest();
		attendancelist = attendanceService.sheet(null,null);
		return "sheet";
	}
	
	
	
	/**
	 * 导出
	 * @return
	 */
	public void out(){
		HttpServletRequest req = ServletActionContext.getRequest();
		System.out.println(table_data);
		JSONArray json = JSONArray.parseArray(table_data);
		HttpServletResponse response = ServletActionContext.getResponse();
		//声明xml工具类
		XmlUtil xml =new XmlUtil();
		//调用xml工具类导出方法并把要导出的list传过去
        HSSFWorkbook wb = xml.export(json);
        response.setContentType("application/vnd.ms-excel");  
        //文本格式和文件名字
        response.setHeader("Content-disposition", "attachment;filename=xml.xls");  
        try {
        OutputStream ouputStream = response.getOutputStream();    
			wb.write(ouputStream);
			ouputStream.flush();
			ouputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
	
	
	
	
	
	
	
	
	




	public List<Attendance> getAttendancelist() {
		return attendancelist;
	}
	public void setAttendancelist(List<Attendance> attendancelist) {
		this.attendancelist = attendancelist;
	}
	public String getTable_data() {
		return table_data;
	}

	public void setTable_data(String table_data) {
		this.table_data = table_data;
	}

	public Sheet getSheet() {
		return sheet;
	}

	public void setSheet(Sheet sheet) {
		this.sheet = sheet;
	}

	public AttendanceService getAttendanceService() {
		return attendanceService;
	}

	public void setAttendanceService(AttendanceService attendanceService) {
		this.attendanceService = attendanceService;
	}

	public List<Sheet> getSheetlist() {
		return sheetlist;
	}

	public void setSheetlist(List<Sheet> sheetlist) {
		this.sheetlist = sheetlist;
	}

	@Override
	public Sheet getModel() {
		// TODO Auto-generated method stub
		return null;
	}
}
