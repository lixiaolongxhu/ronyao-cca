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
			fieldLabel : '图层ID',
			allowBlank : true,
			name:'detailLayerId',
			readOnly:true,
			id:'detailLayerId'
		},{
			fieldLabel : '图层名称',
			name:'detailLayerName',
			allowBlank : false,
			id:'detailLayerName'
		},{
			fieldLabel : '图层路径',
			readOnly:true,
			name:'detailLayerFilePath',
			allowBlank : true,
			id:'detailLayerFilePath'
		},{
			fieldLabel : '上传路径',
			allowBlank : true,
			id: 'form-file',
			name:'detailLayerNewFilePath',
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
		itemId:'gisLayerDetailReset'
	},{
		text:'提交',
		itemId:'gisLayerDetailSubmit'
	},{
		text:'关闭',
		itemId:'gisLayerWindowClose'
	}]
	
});