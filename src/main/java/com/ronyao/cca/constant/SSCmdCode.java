package com.ronyao.cca.constant;

public interface SSCmdCode {

	int SS_REGISTER_CODE = 1;      //注册
	int SS_GET_DETAIL_CODE = 2;    //根据资源ID 获取设备详情
	 
	int SS_HEART_BEAT_CODE = 5;    //ss心跳
	int SS_STORE_MSG_CODE = 8;     //ss存储消息
	int SS_DEVICE_MSG_CODE = 9;    //ss设备消息
	int SS_CHANNEL_MSG_CODE = 10;  //ss通道消息
	
	
	//MC->SS
	int SS_QUERY_VIDEO_CODE = 105; //查询历史文件
	int SS_GET_SINGLE_VIDEO_CODE = 106;//获得单个录像
	int SS_DELETE_VIDEO_CODE = 107;//删除视频命令
	int SS_GET_VIDEO_COUNT_CODE = 108;//获取有视频的资源ID
	int SS_ADD_CHANNEL_CODE = 109;    //添加通道
}


