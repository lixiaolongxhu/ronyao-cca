package com.ronyao.cca.tool;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;




/**
 * 文件上传下载工具类
 * @author lixiaolong
 * @version datetime：2015年6月14日  下午3:19:34
 */

public class FileUtil {
	private static final Logger  LOG=LoggerFactory.getLogger(FileUtil.class);
	
	
	/** 
	 * 删除单个文件 
	 * @param   sPath    被删除文件的文件名 
	 * @return 单个文件删除成功返回true，否则返回false 
	 */  
	public static boolean deleteFile(String sPath) {  
		Boolean flag = false;  
	   File  file = new File(sPath);  
	    // 路径为文件且不为空则进行删除  
	    if (file.isFile() && file.exists()) {  
	        file.delete();  
	        flag = true;  
	    }  
	    return flag;  
	}
	/**
	 * 获取文件保存路径
	 * @return
	 */
//	public static String getFilePath(){
//		String filePath=null;
//		if(Global.os == OS.WINDOWS){
//			filePath = ResourceReader.getApplicationConfigString("file_path_window");
//		}else if(Global.os == OS.LINUX){
//			filePath = ResourceReader.getApplicationConfigString("file_path_linux");
//		}else {
//			throw new BizException("不支持的操作系统类型");
//		}
//		return filePath;
//	}
	
	/**
	 * 获取文件上传路径
	 * @return
	 */
	public static String getFilePath(){
//		return Env.getFileUploadPath();
		return "";
	}
	
	/**
	 * 获取文件后缀名
	 * @param filename
	 * @return
	 */
	public static String getExtensionName(String filename) {   
        if ((filename != null) && (filename.length() > 0)) {   
            int dot = filename.lastIndexOf('.');   
            if ((dot >-1) && (dot < (filename.length() - 1))) {   
                return filename.substring(dot + 1);   
            }   
        }      
        return filename;   
    }  
	
//	/**
//	 * 文件删除接口
//	 * @param fileName
//	 * @return
//	 */
//	public static boolean deleteFile(String fileName){
//		boolean deleted = false;
//		
//		String filePath = null;
//		
//		filePath=getFilePath();
//		
//		filePath += fileName;
//		File file = new File(filePath);
//		if(file.exists()){
//			deleted = file.delete();
//			if(!deleted){
//				LOG.warn("文件删除失败");
//			}
//		}
//		
//		return deleted;
//	}
	
	

    /**
     * 获取文件下载浏览url
     * @return
     */
	public static String  getFileDownLoadUrl(){
//		return Env.getFileBrowsePath();
		return "";
	}

	/**
	 * 多文件上传接口
	 * @param files
	 * @param saveFilePath 
	 * @return
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	public static List<String> uploadFiles(MultipartFile[] files, String saveFilePath) throws IllegalStateException, IOException {
		
		List<String>  fileNameList = new ArrayList<String>();
		String filePath=getFilePath();
		//判断file数组不能为空并且长度大于0  
        if(files!=null&&files.length>0){  
            //循环获取file数组中得文件  
            for(int i = 0;i<files.length;i++){  
                MultipartFile file = files[i];  
                if (file != null) {
					String fileNameOrigin = file.getOriginalFilename();
					
					String ext = FileUtil.getExtensionName(fileNameOrigin).toLowerCase().trim();
					
//					if(ext == null 
//							|| (!ext.equals("jpg") 
//									&& !ext.equals("jpeg")
//									&& !ext.equals("png")
//									&& !ext.equals("gif"))){
//						throw new BizException("不支持的格式" + ext);
//					}
					
					if(ext == null){
						LOG.error("不支持的格式" + ext);
					}
					
					//附件路径创建
					File folderFile = new File(filePath);
					if (!folderFile.exists()) {  
						folderFile.mkdirs();  
				    }
					
					//设置文件名
					String fileName = DateUtil.dateToString(new Date(), DateUtil.DATAFORMAT5)+ "." + ext;
					fileNameList.add(fileName);
					String path = saveFilePath + fileName;
					File localFile=new File(path);	
					file.transferTo(localFile);
//					try {
//						
//					} catch (IllegalStateException e) {
//						e.printStackTrace();
//						LOG.error("文件上传失败", e.getMessage());
//					} catch (IOException e) {
//						e.printStackTrace();
//						LOG.error("文件上传失败", e.getMessage());
//					}
				} 
            }  
        } 
        
        return fileNameList;
	}
	

	/**
	 * 获取文件全名称 带后缀 如：xxxx.jpg<br>
	 * 如果文件 accessFilePath 为空则返回""
	 * @param accessFilePath 文件的访问地址：如http://192.168.0.1:8080/xxxx/xxxx.jpg
	 * @return 文件全名称
	 */
//	public static String  getFileName(String  accessFilePath){
//		String accessFilePathStr=accessFilePath;
//		if(!ToolHelper.isEmpty(accessFilePathStr)){
//			accessFilePathStr = accessFilePathStr.substring(accessFilePathStr.lastIndexOf("/")+1);
//		} else{
//			accessFilePathStr = "";
//		}
//		return  accessFilePathStr;
//	}
	
	

//	/**
//	 * 单个文件上传[@author wucc]
//	 * @param file 文件对象
//	 * @param fileDirectory 文件存储的目录 如："appversion"</br>
//	 *        如果需要将文件放到配置定义的根路径（如：d:/apache-tomcat-7.0.62/webapps/ryx-file/）下面</br>
//	 *        该参数传入null
//	 * @return  文件上传成功后的下载(访问)路径
//	 */
//	public static String uploadFile(MultipartFile file,String fileDirectory) {
//		        String fileName = "error";
//		        StringBuffer accessUrl = new StringBuffer(getFileDownLoadUrl());
//                if (file != null) {
//                	String filePath=getFilePath();
//                	if(!StringUtils.isBlank(fileDirectory)){
//                		filePath = filePath+fileDirectory;
//                		accessUrl.append(fileDirectory);
//                	 }
//                	//filePath= filePath.replace("//", "/");
//            		String fileNameOrigin = file.getOriginalFilename();
//            		String ext = FileUtil.getExtensionName(fileNameOrigin).toLowerCase().trim();
//            		if(ext == null){
//            			throw new BizException("不支持的格式" + ext);
//            		}
//					//附件路径创建
//					File folderFile = new File(filePath);
//					if (!folderFile.exists()) {  
//						folderFile.mkdirs();  
//				    }
//					//设置文件名
//					//fileName = ToolHelper.getFileNameRandom()+ "." + ext;
//					fileName = ToolHelper.getRandomString(3) + fileNameOrigin;
//					accessUrl.append("/").append(fileName);
//					File localFile=new File(folderFile,fileName);	
//					try {
//						file.transferTo(localFile);
//					} catch (IllegalStateException e) {
//						e.printStackTrace();
//						throw new BizException("文件上传失败", e.getMessage());
//					} catch (IOException e) {
//						e.printStackTrace();
//						throw new BizException("文件上传失败", e.getMessage());
//					}
//				} 
//               
//        return  accessUrl.toString().replace("\\", "/");
//	}
	
}
