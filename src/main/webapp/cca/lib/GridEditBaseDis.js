/* 通用编辑器(显示使用)
 * 初始化需要
 
 */



Ext.define('RYIVS.lib.GridEditBaseDis', {
	extend : 'Ext.grid.Panel',
	alias : 'widget.gridEditBaseDis',
	
	//设置没有数据显示文本
	viewConfig: {
		emptyText:'<div style="text-align:center; padding:50px; color:gray">没有数据可显示</div>',
        deferEmptyText:false
    },

    //引入grid 特征 - 列求和
	features: [{
        ftype: 'summary'
    }],
    
    
	// 工具条
	tbar : [ {
		itemId : 'buttonRefresh',
		text : '刷新',
		icon : 'res/icon/sync.png',
		handler : function() {
			this.ownerCt.ownerCt.store.load();
		}
	} 
	, {
		itemId : 'buttonExporterExcel',
		text : '导出Excel',
		icon : 'res/icon/export.gif'	
    }],

	listeners : {
		'selectionchange' : function(view, records) {
//			this.down('#buttonDelete').setDisabled(!records.length);
		}
	},

	

	initComponent : function() {
		
		



		this.callParent(arguments);
	
	}


});
