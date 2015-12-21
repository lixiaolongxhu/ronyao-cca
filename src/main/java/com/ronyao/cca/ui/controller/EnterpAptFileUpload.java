package com.ronyao.cca.ui.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.multipart.MultipartFile;




/**企业基本信息
 * 
 * @author user
 *
 */
@Controller
@RequestMapping(value="/enterpriseApt")
public class EnterpAptFileUpload {

	
	/**上传企业资质图片
	 * 
	 * @param request
	 * @param uuid
	 * @return
	 */
	@RequestMapping(value="/uploadImage")
	public void uploadImage(@RequestParam("files") MultipartFile[] files,HttpServletRequest request, HttpServletResponse response,Integer overallrank,Integer enterpriseid ){
		System.out.println("输出企业id  enterpriseid:  " +enterpriseid);
		System.out.println("输出上传文件 : "+files[0].getOriginalFilename()) ;
		String result = "{success:true,reason:2}";
		try {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.write(result);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
//	public void uploadBusinessImage(MultipartFile[] files,
//			BusinessImage businessImage) {
//		
//		List<String> fileNameList = null;
//		
//		fileNameList = FileUtil.uploadFiles(files);
//		
//		if(ToolHelper.isNotEmpty(fileNameList) || Env.unitTest){
//			for (String fileName : fileNameList) {
//				ImageUtil.compress(fileName, FileUtil.getFilePath(), 100, 100);
//				businessImage.setUuid(ToolHelper.getUUID());
//				businessImage.setCreateTime(ToolHelper.dateToString(new Date(), 0));
//				businessImage.setStatus(Const.CommonStatus.OPEN);
//				businessImage.setPath(fileName);
//				basicdao.Insert(businessImage);
//			}
//			if(Env.unitTest) {
//				basicdao.Insert(businessImage);
//			}
//		}
//	}
}
