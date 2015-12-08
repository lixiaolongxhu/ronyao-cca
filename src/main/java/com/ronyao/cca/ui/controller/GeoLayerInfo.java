//package com.ronyao.cca.ui.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.ronyao.cca.db.dao.GisLayerMapper;
//import com.ronyao.cca.db.model.GisLayer;
//import com.ronyao.cca.db.model.GisLayerExample;
//
//@Controller
//public class GeoLayerInfo {
//	
//	@Autowired
//	private GisLayerMapper gisLayerMapper;
//	
//	
//	@RequestMapping(value = "/getGeoLayerJson",method = RequestMethod.POST,produces="text/html;charset=UTF-8")
//	@ResponseBody
//	public String getGeoLayerJson() throws Exception {
//		GisLayerExample gisLayerExample = new GisLayerExample();
//		List<GisLayer> gisLayerList = gisLayerMapper.selectByExample(gisLayerExample);
//		String geoLayerJson="{\"GeoLayers\":[";
//		if(gisLayerList.size()!=0){
//			for(GisLayer gisLayer:gisLayerList){
//				geoLayerJson+="{\"id\":\""+gisLayer.getId()+"\",\"name\":\""+gisLayer.getName()+"\",\"fname\":\""+gisLayer.getFname()+"\"},";
//			}
//			geoLayerJson=geoLayerJson.substring(0,geoLayerJson.length()-1)+"]}";
//		}else{
//			
//			geoLayerJson=geoLayerJson + "]}";
//		}
//		return geoLayerJson;
//	}
//}
