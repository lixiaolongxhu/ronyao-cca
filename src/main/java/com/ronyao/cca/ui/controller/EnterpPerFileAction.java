package com.ronyao.cca.ui.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.ronyao.cca.constant.ConstFileType;
import com.ronyao.cca.db.dao.EnterprisePerFileMapper;
import com.ronyao.cca.db.model.EnterprisePerFile;
import com.ronyao.cca.tool.DateUtil;
import com.ronyao.cca.tool.FileUtil;




/**企业持证人员证件信息管理
 * 
 * @author user
 *
 */
@Controller
@RequestMapping(value="/enterprisePer")
public class EnterpPerFileAction {
	
	private static final  Logger  LOG=LoggerFactory.getLogger(EnterpAptAction.class);
	
	@Resource
	private EnterprisePerFileMapper  enterprisePerFileMapper;

	
	/**上传人员证件信息图片
	 * 
	 * @param request
	 * @param uuid
	 * @return
	 */
	@RequestMapping(value="/uploadImage")
	public void uploadImage(@RequestParam("files") MultipartFile[] files,HttpServletRequest request, HttpServletResponse response,EnterprisePerFile enterPerFile ){
//		System.out.println("输出企业id  enterpriseid:  " +enterpriseid);
//		System.out.println("输出上传文件 : "+files[0].getOriginalFilename()) ;
		
		String saveFilePath = request.getSession().getServletContext()
				.getRealPath("/")
				+ "/res/file/";
		List<String> fileNameList=null;
		String result = "{success:true,reason:1}";
		try {
			fileNameList=FileUtil.uploadFiles(files,saveFilePath);
			if(fileNameList.isEmpty() || fileNameList.get(0).isEmpty()){
				result = "{success:false,reason:1}"; //文件上传失败,为获取到对应的相当路径文件名
			}else{
				enterPerFile.setPath(fileNameList.get(0));
				enterPerFile.setCreatetime(DateUtil.dateToString(new Date(), DateUtil.DATAFORMAT0));
				enterPerFile.setFiletype(ConstFileType.IMAGE);
				enterprisePerFileMapper.insert(enterPerFile);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("文件上传失败", e.getMessage());
			result = "{success:false,reason:2}"; //文件上传失败,出现异常
		} finally{
			write(response,result);
		}
		
	}
	
	
	/**返回结果
	 * 
	 * @param response
	 * @param result
	 */
	private  void  write(HttpServletResponse response,String result){
		try {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.write(result);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
