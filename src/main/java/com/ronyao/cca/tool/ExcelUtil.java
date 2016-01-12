package com.ronyao.cca.tool;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**excel poi 处理工具类
 * 
 * @author user
 *
 */
public class ExcelUtil {
	
	private  static final Logger  LOG=LoggerFactory.getLogger(ExcelUtil.class);
	
	/**poi 导出excel
	 * 
	 * @param hearderName
	 * @throws IOException 
	 */
	public  static  void  excelExport(String  fileName,List<String> headerName,List<Map<Integer, String>>   columnValue,HttpServletResponse response) throws IOException{
		
		if(headerName==null || headerName.isEmpty()){
			return;
		}
		
		
		// 第一步，创建一个webbook，对应一个Excel文件  
        HSSFWorkbook wb = new HSSFWorkbook();  
        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet  
        HSSFSheet sheet = wb.createSheet("sheet one");  
        
        //HSSFSheet有个方法叫SetColumnWidth，共有两个参数：一个是列的索引（从0开始），一个是宽度。
        for(int i=0;i<headerName.size();i++){
        	   //第0列才用默认列宽
        	   sheet.setColumnWidth(i+1, 100 * 100);

        }
       
        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short  
        HSSFRow row = sheet.createRow((int) 0);  
        // 第四步，创建单元格，并设置值表头 设置表头居中  
        HSSFCellStyle style = wb.createCellStyle();  
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式  
        
        // 第五步，写入实体数据 实际应用中这些数据从数据库得到，  
        HSSFCell cell = row.createCell( 0);  
     
        for(int i=0;i<headerName.size();i++){
        	 cell.setCellValue(headerName.get(i));  
             cell.setCellStyle(style);  
             cell = row.createCell( i+1); 
//             cell.setCellValue("主管单位");  
//             cell.setCellStyle(style);  
//             cell = row.createCell( 1);  
//             cell.setCellValue("企业全称");  
//             cell.setCellStyle(style);  
//             cell = row.createCell( 2);  
//             cell.setCellValue("企业简称");  

        }
        
        
        for (int i = 0; i < columnValue.size(); i++)  
        {  
            row = sheet.createRow((int) i + 1);  
            Map<Integer, String> enter = columnValue.get(i);  
            // 第四步，创建单元格，并设置值  
            for(int j=0;j<headerName.size();j++){
            	HSSFCell  hsscell= row.createCell(j);
            	hsscell.setCellStyle(style); //设置内容共内容样式
            	hsscell.setCellValue(enter.get(j));   //设置列表内容值
            }
//          row.createCell(0).setCellValue(enter.getSupervisorunit());  
//          row.createCell(1).setCellValue(enter.getFullname());  
//          row.createCell(2).setCellValue(enter.getName());  
//          row.createCell(3).setCellValue(enter.getProperty());     
//          cell = row.createCell(3);  
//          cell.setCellValue(new SimpleDateFormat("yyyy-mm-dd").format(stu  
//                    .getBirth()));  
        }  
        
        
        // 第六步，将文件存到指定位置  
        String filename=fileName ;
        //设置 contentType
        response.setContentType("application/vnd.ms-excel;charset=utf-8"); 
        // 设置response的Header ,文件下载的名称
        response.setHeader("Content-Disposition", "attachment;filename="+new String(filename.getBytes("GBK"), "ISO-8859-1")+".xls");
//      OutputStream ouputStream = response.getOutputStream();  
        OutputStream toClient = new BufferedOutputStream(  
                response.getOutputStream()); 
        wb.write(toClient); 
        toClient.flush();    
        toClient.close();
        wb.close();
        LOG.debug("执行文件:" +fileName+"  excel下载导出完成");
	}

}
