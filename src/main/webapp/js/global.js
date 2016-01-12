Ext.require([ 'Ext.Date' ]);


//注册全局ajax请求返回事件
Ext.Ajax.on('requestcomplete', function(conn, response, options, e) {
			var rst = response.responseText;
			// session 过期处理
			if (rst.indexOf("{timeout:", 0) != -1) {
					window.location.href = "index.jsp";
			}
		}); 




// 服务器返回参数配置--对应jsp/WebConfig.jsp

var appCfg = {

	uname : '',
	uid : 0,
	utype : 0,
	debugLevel : 0
};

//var timelineSelectIndex = null;

// 通用日志函数
/*
 * 日志级别 0：调试消息 1：一般消息 2：普通异常 3：重要异常
 */
var logMessage = function(obj, level, msg) {
	var time = Ext.Date.format(new Date(), 'Y-m-d G:i:s');
	if (level >= appCfg.debugLevel) {
		console.log(time + ' -- ' + obj + ' : ' + msg);
	}
}

// 控制器全局对象
var controller = {

}

// 锁定整个界面
function freezeUI(freeze) {
	Ext.ComponentQuery.query("viewport")[0].setLoading(freeze);
}

// ----------------------------常量  begin-----------------------------
Ext.namespace('ry.constant');

// 把Index翻译成对应的字符串
ry.constant.trans = function(index, type) {
	for ( var i = 0; i < type.length; i++) {
		if (type[i][0] == index) {
			return type[i][1];
		}
	}
	return 0;
}


// 企业性质
ry.constant.enterprise_property = [[ 1, '全民' ], [ 2, '集体' ] ];

// 企业岗位: 是否允许其他岗位进行兼职
ry.constant.post_classify_job =[[1,"不允许"],[2,'允许']];

// 线路专业  设备承载距离计算方式
ry.constant.equipment_lineType =[[1,'单回'],[2,'双回']]


// 施工项目类型
ry.constant.project_type =[[1,'线路工程项目'],[2,'变电工程项目']]

// 不良行为等级分类
ry.constant.behavior_standard_rankType =[[1,'严重不良行为'],[2,'一般不良行为']]

// 施工企业评估分类: 类别
ry.constant.enterprise_assess_category =[['A类','A类'],['B类','B类'],['C类','C类'],['D类','D类'],['E类','E类'],['F类','F类']
										,['G类','G类'],['H类','H类'],['I类','I类'],['J类','J类'],['K类','K类']
										]

// 企业持证人员分类
ry.constant.enterprise_per_file_classify =[['国家注册建造师','国家注册建造师'],['中级以上职称人员','中级工以上技术人员']]

// 企业持证人员分类等级
ry.constant.enterprise_per_file_rank =[['一级','一级'],['二级','二级'],['中级','中级'],['高级','高级'],['技师','技师'],['高级技师','高级技师']]


////联动-空调控制
//ry.constant.link_air = [
//    {parm1:"0", parm1Name:"关闭"},
//    {parm1:"1", parm1Name:"制冷"},
//    {parm1:"2", parm1Name:"制热"},
//    {parm1:"3", parm1Name:"除湿"}
//]
//
////联动-开关量
//ry.constant.link_switch = [
//    {parm1:"0", parm1Name:"关闭"},
//    {parm1:"1", parm1Name:"开启"}
//]
//
//


// ----------------------------常量   end-----------------------------


/**
 * 常用方法类
 */
Ext.namespace('ry.util');
ry.constant.sendtypestore = [ [ 1, "短信" ], [ 2, "电话" ], [3, "电话与短信"] ];
ry.constant.errtype = '<font color=red>类型不存在</font>';
ry.constant.yntypestore = [ [ 1, "是" ], [ 0, "否" ] ];
ry.constant.yntype = [ [ 0, '<span style="background-color: #992124;">&nbsp;&nbsp;&nbsp;&nbsp;</span>' ],
		[ 1, '<span style="background-color: #4c8e0e;">&nbsp;&nbsp;&nbsp;&nbsp;</span>' ] ];

// 得到资源对应的CSS Class
ry.util.getResCssClass = function(val) {
	return '<div class=resType' + val + '></div>';
}
