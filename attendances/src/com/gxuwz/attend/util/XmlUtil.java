package com.gxuwz.attend.util;

import java.util.List;

import org.apache.poi.hssf.usermodel.*;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;





public class XmlUtil {
	//�����ͷ
	String[] excelHeader = {"�γ�����","ѧ��ID","ѧ������","ʱ��","״̬"};  
    public HSSFWorkbook export(JSONArray json) {  
        HSSFWorkbook wb = new HSSFWorkbook();  
        //�������ʽ
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
        //ÿ����������ݾ�������һ��
        for (int i = 0; i < json.size(); i++) {  
            row = sheet.createRow(i + 1);  
            //��ӱ������
            JSONObject jo = JSONObject.parseObject(json.get(i).toString());
            row.createCell(0).setCellValue(jo.getString("�γ�����"));  
            row.createCell(1).setCellValue(jo.getString("ѧ��ID"));  
            row.createCell(2).setCellValue(jo.getString("ѧ������"));  
            row.createCell(3).setCellValue(jo.getString("ʱ��"));  
            row.createCell(4).setCellValue(jo.getString("״̬"));  
            
        }  
        return wb;  
    }

}
