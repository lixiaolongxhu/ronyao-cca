Ext.define('RYIVS.view.gis.FileUpload', {
	extend : 'Ext.window.Window',
	alias : 'widget.fileUpload',
	title : '图片上传',
    items : [{
		xtype : 'form',
		bodyPadding: '10 10 0',
		items :[{
			xtype : 'textfield',
			fieldLabel : '图层名',
			labelAlign : 'right',
			name : 'fname'
		},{
			xtype: 'filefield',
       		id: 'form-file',
       		labelAlign : 'right',
       		emptyText: '请选择文件',
       		fieldLabel: '文件名',
      		name: 'file',
       		buttonText: '选择文件',
       		buttonConfig: {
         		iconCls: 'upload-icon'
        	}
		}],
		buttons : [{
			text : '上传',
			xtype : 'button',
			btn : 1
		}]
	}]
	
})