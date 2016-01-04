/**左侧菜单
 * 
 */
Ext.define('RYIVS.controller.frame.LeftMenu', {
	extend : 'Ext.app.Controller',
	views : [ 'frame.LeftMenu' ],
	
	init : function() {
	 	this.control({
	 		
      		'leftMenu':{
        		itemclick : this.treeItemClick,
        		afterrender : this.onAfterrender
     		 }
   		 });
	},
	
	/**
	 * 界面建立时只调用一次
	 * 
	 * @param {}
	 *            pa
	 * @param {}
	 *            options
	 */
	onAfterrender : function(pa, options) {	
		//根据浏览器宽度 动态设置treepanel 宽度   
		var  width=document.documentElement.clientWidth*0.2;
		//alert(width);
		pa.setWidth(width);
	},
	
	/**树性菜单点击事件.
	 * 
	 * @param {} view
	 * @param {} record
	 * @param {} item
	 * @param {} index
	 * @param {} eventObj
	 */
	treeItemClick : function(view,record,item,index,eventObj){
		  //根据id属性配置获取
		  var centerPanel = Ext.getCmp('centerPanel');
		  var id =record.raw.id+record.raw.text;
		  var n = centerPanel.getComponent(id);  
		//alert(record.raw.url);
		  if (!n &&  record.raw.leaf==true) { // 判断是否已经打开该面板 (为叶子节点时执行点击事件)
                 n = centerPanel.add({  
                          'id' : id,  
                          'title' : record.raw.text, 
                           xtype :   record.raw.url,     ///record.raw.url  , //设置要显示的tab别称.
                           closable : true // 通过html载入目标页  ,显示关闭按钮
                       //  html : '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="'+record.raw.id+'"></iframe>'         
                	     
                });  
          }  
         centerPanel.setActiveTab(n);   
		
	}
});
