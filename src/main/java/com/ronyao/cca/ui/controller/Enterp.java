package com.ronyao.cca.ui.controller;

import org.springframework.stereotype.Controller;


/**企业基本信息
 * 
 * @author user
 *
 */
@Controller
public class Enterp {

	
	/**
	 * 上传商家图片
	 * @param request
	 * @param uuid
	 * @return
	 */
//	@RequestMapping(value="/uploadImage")
//	public String uploadImage(@RequestParam("files") MultipartFile[] files,HttpServletRequest request,BusinessImage businessImage){
//		if(ToolHelper.isEmpty(ToolHelper.isEmpty(businessImage.getBusinessUuid()))){
//			throw new BizException(Const.ResponseStatusCode.PARAMETER_ERROR,"商家uuid标识缺失");
//		}
//		if(ToolHelper.isEmpty(businessImage.getImageType())){
//			throw new BizException(Const.ResponseStatusCode.PARAMETER_ERROR,"图片类型缺失");
//		}
//		businessImageService.uploadBusinessImage(files,businessImage);
//		return  "上传商家图片成功";
//	}
	
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
