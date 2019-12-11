package com.gxuwz.attend.util;

import java.util.List;

import org.apache.poi.hssf.usermodel.*;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;





public class XmlUtil {
	//定义表头
	String[] excelHeader = {"课程名字","学生ID","学生名字","时间","状态"};  
    public HSSFWorkbook export(JSONArray json) {  
        HSSFWorkbook wb = new HSSFWorkbook();  
        //定义表格格式
        HSSFSheet sheet = wb.createSheet("Student");  
        HSSFRow row = sheet.createRow((int) 0);  
        HSSFCellStyle style = wb.createCellStyle();  
        //style.setAlignment(HSSFCellStyle.ALIGN_CENTER);  

        for (int i = 0; i < excelHeader.length; i++) {  
            HSSFCell cell = row.createCell(i);  
            cell.setCellValue(excelHeader[i]);  
            cell.setCellStyle(style);  
            sheet.autoSizeColumn(i);  
            sheet.setColumnWidth(i, 100 * 50);
        }  
        //每行添加完内容就跳到下一行
        for (int i = 0; i < json.size(); i++) {  
            row = sheet.createRow(i + 1);  
            //添加表格内容
            JSONObject jo = JSONObject.parseObject(json.get(i).toString());
            row.createCell(0).setCellValue(jo.getString("课程名字"));  
            row.createCell(1).setCellValue(jo.getString("学生ID"));  
            row.createCell(2).setCellValue(jo.getString("学生名字"));  
            row.createCell(3).setCellValue(jo.getString("时间"));  
            row.createCell(4).setCellValue(jo.getString("状态"));  
            
        }  
        return wb;  
    }

}
