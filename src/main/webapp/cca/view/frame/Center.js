
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
        //Ext.getCmp 根据id 获取对象是,要求对象必须实例后或者已被调用实例,只被声明,是无法获取到对象的
        id :'centerPanel'  //id 属性配置,用于Ext.getCmp('centerPanel') 获得该dom对象 
	}
);