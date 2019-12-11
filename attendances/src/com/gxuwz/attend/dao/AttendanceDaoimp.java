package com.gxuwz.attend.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.hibernate.Query;

import com.gxuwz.attend.entity.Attendance;
import com.gxuwz.attend.entity.Course;
import com.gxuwz.attend.entity.Sheet;
import com.gxuwz.attend.entity.Student;
import com.gxuwz.attend.entity.Teacher;
import com.gxuwz.attend.util.DateUtil;
public class AttendanceDaoimp extends BaseDao implements AttendanceDao {
	public List<Sheet> list(String number,String courseId,String courseTime ){
		List<Sheet> result = new ArrayList<>();
		String hql="from Sheet where courseId = ?";
		Query query=getSession().createQuery(hql);
		query.setString(0, courseId);
		List<Sheet> sheetlist = query.list();
		sheetlist.forEach(v->{	
			Sheet temp = v;
			Query querys = getSession().createQuery("from Student where stuId = ?");
			querys.setString(0, v.getStudentId());
			temp.setStudent((Student)querys.list().get(0));
			result.add(temp);
		});
		
		if(number==null||number.equals("0" )){
			return result;	
		}else{
			
			if(Integer.parseInt(number)>sheetlist.size()){
			return null;	
			}else{
		        //随机抽取
		        Random random = new Random();
		        List<Integer> tempList = new ArrayList<Integer>();
		        List<Sheet> sheetlist2 = new ArrayList<Sheet>();
		        //定义下标
		        int temp=0;
		        for(int i=0;i<Integer.parseInt(number);i++){
		        	//将产生的随机数作为被抽取的list，即allStudent的索引
		        	temp=random.nextInt(sheetlist.size());
		        	
		        	if(!tempList.contains(temp)){
		        		tempList.add(temp);
		        		sheetlist2.add(result.get(temp));
		        	}else{
		        		i--;
		        	}
		        }
		        return sheetlist2;
			}
		}
	}
	
	
	public boolean checktime(String courseid,String time){
		String hql="from Attendance where courseId = ? and time = ?";
		Query query=getSession().createQuery(hql);
		query.setString(0, courseid);
		query.setString(1, time);
		List list = query.list();
		if(list.isEmpty()){
			return true;
		}else{
			return false;
		}
	}
	
	public void add(Attendance attendance){
		DateUtil date = new DateUtil();
			attendance.setTime(date.DateNow());
			getSession().save(attendance);
	}
	
	public List<Attendance> sheet(String courseid,String time){
		List<Attendance> result = new ArrayList<>();
		String hql = "from Attendance where 1=1";
		Query query =null;
		if(!(courseid==null)){
				hql = "from Attendance where courseId = ? and time = ?";
				query = getSession().createQuery(hql);
				query.setString(0, courseid);
				query.setString(1, time);
				List<Attendance> attendancelist= new ArrayList<>();
				attendancelist = query.list();
				attendancelist.forEach(v->{
					Attendance temp = v;
					Query querys = getSession().createQuery("from Student where stuId = ?");
					querys.setString(0, v.getStudentId());
					
					Query query2 = getSession().createQuery("from Course where courseId = ?");
					query2.setString(0, v.getCourseId());
					
					
					temp.setStudent((Student)querys.list().get(0));
					temp.setCourse((Course)query2.list().get(0));
					result.add(temp);
				});
				return result;
		}else{
			query = getSession().createQuery(hql);
			List<Attendance> attendancelist= new ArrayList<>();
			attendancelist = query.list();
			attendancelist.forEach(v->{
				Attendance temp = v;
				Query querys = getSession().createQuery("from Student where stuId = ?");
				querys.setString(0, v.getStudentId());
				temp.setStudent((Student)querys.list().get(0));
				Query query2 = getSession().createQuery("from Course where courseId = ?");
				query2.setString(0, v.getCourseId());
				
				
				temp.setStudent((Student)querys.list().get(0));
				temp.setCourse((Course)query2.list().get(0));
				result.add(temp);
			});
			return result;
		}
		
	}
}
