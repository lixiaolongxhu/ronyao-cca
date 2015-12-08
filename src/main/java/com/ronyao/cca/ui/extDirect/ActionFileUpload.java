//package com.ronyao.cca.ui.extDirect;
//
//import java.io.ByteArrayOutputStream;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.PrintWriter;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.ronyao.cca.db.dao.GisLayerMapper;
//import com.ronyao.cca.db.model.GisLayer;
//
//@Controller
//public class ActionFileUpload {
//
//	@Autowired
//	private GisLayerMapper gisLayerMapper;
//
//	Logger log = LoggerFactory.getLogger(ActionFileUpload.class);
//
//	@RequestMapping(value = "/uploadPicture", method = RequestMethod.POST)
//	public void uploadPicture(
//			@RequestBody MultipartFile detailLayerNewFilePath,
//			@RequestParam("id") int id, @RequestParam("name") String name,
//			HttpServletRequest request, HttpServletResponse response) {
//		String originalFilename = detailLayerNewFilePath.getOriginalFilename();
//		String success = "{success:true,reason:1}";
//		String failure = "{success:false:reason:1}";
//		String result = null;
//
//		if (!name.equals(null)) {
//			this.updateLayerName(id, name);
//			result = success;
//		}
//
//		if (originalFilename != "" && originalFilename != null) {
//			if (-1 == originalFilename.indexOf(".jpg")) {
//				result = "{success:false,reason:2}";
//			} else {
//				log.info("无图片上传，修改图层名称");
//				log.info("start to upload the file:" + originalFilename);
//				String path = request.getSession().getServletContext()
//						.getRealPath("/")
//						+ "/res/map/";
//				String filename = id + ".jpg";
//				try {
//					this.copyFile(detailLayerNewFilePath.getInputStream(),
//							filename, path);
//					this.updateLayer(id, filename);
//					result = "{success:true,reason:2}";
//				} catch (Exception e) {
//					e.printStackTrace();
//					result = failure;
//				}
//			}
//		}
//
//		try {
//			response.setContentType("text/html");
//			PrintWriter out = response.getWriter();
//			out.write(result);
//			out.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//	@RequestMapping(value = "/upload", method = RequestMethod.POST)
//	// @ResponseBody
//	public void uploadFile(@RequestBody MultipartFile detailLayerNewFilePath,
//			@RequestParam("name") String name, HttpServletRequest request,
//			HttpServletResponse response) {
//		MultipartFile file = detailLayerNewFilePath;
//		log.info("start to upload the file:" + file.getOriginalFilename());
//		log.info("start to upload the really file:" + name);
//		String path = request.getSession().getServletContext().getRealPath("/")
//				+ "/res/map/";
//		String success = "{success:true,reason:2}";
//		String failure = "{success:false,reason:2}";
//		String result = failure;
//		if (file.isEmpty()) {
//			result = failure;
//		} else {
//			String realFile = file.getOriginalFilename();
//			if (-1 == realFile.indexOf(".jpg")) {
//				result = "{success:false,reason:1}";
//			} else {
//				try {
//					int id = this.addLayer(name);
//					String filename = id + ".jpg";
//					this.copyFile(file.getInputStream(), filename, path);
//					this.updateLayer(id, filename);
//					result = success;
//				} catch (IOException e) {
//					e.printStackTrace();
//					result = failure;
//				}
//			}
//		}
//		log.info("finished uploading the file:" + file.getOriginalFilename());
//		log.info("result:" + result);
//		try {
//			response.setContentType("text/html");
//			PrintWriter out = response.getWriter();
//			out.write(result);
//			out.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		// return result;
//
//	}
//
//	// 拷贝文件到指定目录
//	private void copyFile(InputStream in, String fileName, String path)
//			throws IOException {
//		fileName = "layer" + fileName;
//		File file = new File(path + fileName);
//		FileOutputStream fs = new FileOutputStream(file);
//		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
//		byte[] buffer = new byte[1024];
//		int byteread = 0;
//		while ((byteread = in.read(buffer)) != -1) {
//			outStream.write(buffer, 0, byteread);
//		}
//		byte[] data = outStream.toByteArray();
//		in.close();
//		fs.write(data);
//		fs.close();
//	}
//
//	private int addLayer(String layerName) {
//		GisLayer gisLayer = new GisLayer();
//		gisLayer.setName(layerName);
//		gisLayer.setFname("");
//		gisLayerMapper.insert(gisLayer);
//		return gisLayer.getId();
//	}
//
//	private void updateLayerName(int id, String layerName) {
//		GisLayer gisLayer = new GisLayer();
//		gisLayer.setId(id);
//		gisLayer.setName(layerName);
//		gisLayerMapper.updateByPrimaryKeySelective(gisLayer);
//	}
//
//	private void updateLayer(int id, String filename) {
//		GisLayer gisLayer = new GisLayer();
//		gisLayer.setId(id);
//		gisLayer.setFname("layer" + filename);
//		gisLayerMapper.updateByPrimaryKeySelective(gisLayer);
//	}
//}
