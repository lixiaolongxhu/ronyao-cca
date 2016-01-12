/* 通用编辑器(显示使用)
 * 初始化需要
 
 */



Ext.define('RYIVS.lib.GridEditBaseDisNoToolbar', {
	extend : 'Ext.grid.Panel',
	alias : 'widget.gridEditBaseDisNoToolbar',
	
	//居中布局
	region : 'center',
	// 定义 autoload
	autoload : false,
	//'true'使用溢出：'自动'的组件布局元素，并在必要时自动显示滚动条
	autoScroll :true, 
	//True 为 Panel 填充画面,默认为false.
	frame : true, 
	//设 置为true，则强制列自适应成可用宽度
	forceFit :false, 
	//是否显示列分割线，默认为false
	columnLines : true, 
	
	//设置没有数据显示文本
	viewConfig: {
		emptyText:'<div style="text-align:center; padding:50px; color:gray">没有数据可显示</div>',
        deferEmptyText:false,
        //ExtJS如果设置表格行高，不要改公用样式只是针对当前表格
        getRowClass:function(){
             // 在这里添加自定样式 改变这个表格的行高
        	
             return 'x-grid-row custom-grid-row';
         }
    },

    //引入grid 特征 - 列求和
	features: [{
        ftype: 'summary'
    }],
    
	

	initComponent : function() {
	
		this.callParent(arguments);
	
	}


});
