/**企业资质信息上传表单
 * 
 */
Ext.define('RYIVS.view.file.EnterpAptFileUpload', {
	extend : 'Ext.form.Panel',
	alias : 'widget.enterpAptFileUpload',
	width:'798',
	height:'200',
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
			fieldLabel : '资质分类',
			name:'aptitudeid',
			id:'aptitudeid',
			allowBlank : false,
			xtype : 'combo',
			editable : false,
			displayField : 'display',
			valueField : 'value',
			store : ry.constant.enterprise_aptitude_classify, //调用外部js常量
			queryMode : 'local',
			emptyText : '请选择',	
			forceSelection : true //必须选择一项
		},{
			fieldLabel : '资质等级',
//			width : 300,
			name : 'overallrank',
			allowBlank : false,
			xtype : 'combo',
			editable : false,
			displayField : 'display',
			valueField : 'value',
			store : ry.constant.enterprise_aptitude_rank, //调用外部js常量
			queryMode : 'local',
			emptyText : '请选择',	
			forceSelection : true //必须选择一项
		},{
			fieldLabel : '文件路径',
			allowBlank : false,
			id: 'form-file',
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
		itemId:'enterpAptFileUploadReset'
	},{
		text:'提交',
		itemId:'enterpAptFileUploadSubmit'
	},{
		text:'关闭',
		itemId:'enterpAptFileUploadClose'
	}]
	
});