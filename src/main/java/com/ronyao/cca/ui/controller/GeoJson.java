//package com.ronyao.cca.ui.controller;
//
//import java.util.List;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.ronyao.cca.db.dao.GisResMapper;
//import com.ronyao.cca.db.dao.ResourceMapper;
//import com.ronyao.cca.db.model.GisRes;
//import com.ronyao.cca.db.model.GisResExample;
//import com.ronyao.cca.db.model.Resource;
//import com.ronyao.cca.db.model.ResourceExample;
//
//@Controller
//public class GeoJson {
//
//	@Autowired
//	private GisResMapper gisResMapper;
//	@Autowired
//    private ResourceMapper resourceMapper;
//
//	/**
//	 * 1：点\\n2：多点\\n3：线\\n4：多线\\n5：面\\n6：多面
//	 * 
//	 * @param type
//	 * @return
//	 */
//	private String getGisType(int type) {
//		String gisType = "";
//		switch (type) {
//		case 1:
//			gisType = "Point";
//			break;
//		case 2:
//			gisType = "MultiPoint";
//			break;
//		case 3:
//			gisType = "LineString";
//			break;
//		case 4:
//			gisType = "MultiLineString";
//			break;
//		case 5:
//			gisType = "Polygon";
//			break;
//		case 6:
//			gisType = "MultiPolygon";
//			break;
//		}
//		return gisType;
//	}
//
//	@RequestMapping(value = "/getGeoJson",produces="text/html;charset=UTF-8")
//	@ResponseBody
//	public String getGeoJson(Integer layer) {
//		
//		ResourceExample resourceExample = new ResourceExample();
//		resourceExample.createCriteria().andTypeGreaterThan(0);
//		List<Resource> resourceList = (List<Resource>)resourceMapper.selectByExample(resourceExample);
//		
//		
//
//		// 得到相关的gisRes数据
//		GisResExample gisResExample = new GisResExample();
//		if(layer!=null){
//			gisResExample.createCriteria().andLayerEqualTo(layer);
//		}
//		List<GisRes> gisResList = gisResMapper.selectByExample(gisResExample);
//
//		/**
//		 * 组装GeoJSON数据格式 <br>
//		 * 
//		 * <pre>
//		 * { 
//		 * 	"type": "FeatureCollection", 
//		 * 	"features": [ { 
//		 * 		"type": "Feature",
//		 * 		"id": xxxx
//		 * 		"geometry": {
//		 * 			"type": "Point", 
//		 * 			"coordinates": [102.0, 0.5]
//		 * 		}, 
//		 * 		"properties":{
//		 * 			"id": "value0",
//		 * 			"resid": "资源ID",
//		 * 			"layer": "在哪个层",
//		 * 			"type": "点线面",
//		 * 			"style": "元素展示风格"
//		 * 		}
//		 * 	}]
//		 * }
//		 * 
//		 * <pre>
//		 */
//		
//		//
//		StringBuilder builder = new StringBuilder();
//		// GeoJSON数据格式
//		builder.append("{\"type\": \"FeatureCollection\", \"features\": [");
//		String data = "{\"type\": \"Feature\", \"id\": %d, "
//				+ "" +
//				"\"geometry\": {\"type\": \"%s\", \"coordinates\": %s}, "
//				+ "\"properties\": {\"id\": %d, \"resid\": %d, \"layer\": %d, \"type\": %d, \"style\": %d, \"label\": \"%s\"}},";
//		for (GisRes gis : gisResList) {
//			String label=null;
//				for(Resource resource:resourceList){
//					if(resource.getId().equals(gis.getResid())){
//						label =resource.getName();
//					}
//				}
//			String itemString = String.format(data, gis.getId(),
//					getGisType(gis.getType()), gis.getData(), gis.getId(),
//					gis.getResid(), gis.getLayer(), gis.getStyle(),
//					gis.getStyle(),label);
//
//			builder.append(itemString);
//		}
//		// 删除最后一个逗号
//		if (!gisResList.isEmpty()) {
//			builder.deleteCharAt(builder.length() - 1);
//		}
//		// 最后拼装
//		builder.append("]}");
//		return builder.toString().replace("'", "\"");
//	}
//	
//	
//	@RequestMapping(value = "/queryGisResInfoByResId",produces="text/html;charset=UTF-8")
//	@ResponseBody
//	public String queryGisResInfoByResId(Integer resId){
//		StringBuilder returnJson =new StringBuilder();
//		returnJson.append("{\"type\": \"ResCollection\", \"Resources\": [");
//		String data = "{\"id\":%d,\"resId\":%d,\"layerId\":%d},";
//		GisResExample gisResExample = new GisResExample();
//		if(resId != null){
//			gisResExample.createCriteria().andResidEqualTo(resId);
//		}
//		List<GisRes> gisResList =  (List<GisRes>)gisResMapper.selectByExample(gisResExample);
//		for(GisRes gisRes:gisResList){
//			String itemString = String.format(data, gisRes.getId(),gisRes.getResid(),gisRes.getLayer());
//			returnJson.append(itemString);
//		}
//		
//		if (!gisResList.isEmpty()) {
//			returnJson.deleteCharAt(returnJson.length() - 1);
//		}
//		returnJson.append("]}");
//		return returnJson.toString();
//	}
//}
