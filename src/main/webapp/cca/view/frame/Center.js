
/**框架中间主部分显示面板
 * 
 */
Ext.define('RYIVS.view.frame.Center', {
		extend : 'Ext.tab.Panel',
		alias : 'widget.centerPanel',
		region : 'center',
		layout : 'fit',
		tabWidth : 120,
		deferredRender : false,  
 	    activeTab : 0,  
  	    resizeTabs : true, // turn on tab resizing  
 	    minTabWidth : 115,  
 	    tabWidth : 135,  
        enableTabScroll : true ,
        id :'centerPanel'  //id 属性配置,用于Ext.getCmp('centerPanel') 获得该dom对象
	}
);