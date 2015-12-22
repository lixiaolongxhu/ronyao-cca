
Ext.define('RYIVS.view.file.EnterpPerFileUpload', {
	extend : 'Ext.form.Panel',
	alias : 'widget.enterpPerFileUpload',
	width:'798',
	height:'200',
	title :'企业持证人员文件上传',
	frame:true,
	fileUpload : true,
	bodyPadding:5,
	items:[{
		xtype:'fieldset',
		defaults:{
			labelSeparator:':',
			labelAlign : 'right',
			labelWidth:80,
			width:350
		},
		defaultType:'textfield',
		items:[{
			fieldLabel : '持证人员分类',
			name:'classify',
//			id:'classify',
			allowBlank : false,
			xtype : 'combo',
			editable : false,
			displayField : 'display',
			valueField : 'value',
			store : ry.constant.enterprise_per_file_classify, //调用外部js常量
			queryMode : 'local',
			emptyText : '请选择',	
			forceSelection : true //必须选择一项
		},{
			fieldLabel : '等级',
//			width : 300,
			name : 'rank',
			allowBlank : false,
			xtype : 'combo',
			editable : false,
			displayField : 'display',
			valueField : 'value',
			store : ry.constant.enterprise_per_file_rank, //调用外部js常量
			queryMode : 'local',
			emptyText : '请选择',	
			forceSelection : true //必须选择一项
		},{
			fieldLabel : '文件路径',
			allowBlank : false,
	//		id: 'form-file',
			name:'files',
			xtype:'fileuploadfield',
			emptyText: '请您选择文件',
			buttonText: '选择文件',
			buttonConfig: {
         		iconCls: 'upload-icon'
        	}
		}]
	}],
	buttons:[{
		text:'清空表单',
		itemId:'enterpPerFileUploadReset'
	},{
		text:'提交',
		itemId:'enterpPerFileUploadSubmit'
	},{
		text:'关闭',
		itemId:'enterpPerFileUploadClose'
	}]
	
});