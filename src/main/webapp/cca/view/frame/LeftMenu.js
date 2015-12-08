


/**主界面左菜单
 * 
 */
Ext.define('RYIVS.view.frame.LeftMenu', {
	
	extend : 'Ext.tree.Panel',
	alias : 'widget.leftMenu',
	region : 'center',
	title : '菜单',
    	border: false,  //边框
		enableDD: true,
		rootVisible: false,  //隐藏根节点
		useArrows:true, //树节点使用箭头
		containerScroll: true,
		collapsible: false,
		autoScroll: false, 
		store : Ext.create('Ext.data.TreeStore', {
				// 数据代理
			    nodeParam : 'parentId',  //这个属性是异步加载主要特征，通过该节点去请求子节点
				// 根节点的参数值是0
				defaultRootId : 0,
				proxy : {
						type : 'ajax',
						url : 'ui/permissionMenuTree',
						folderSort: true,
					    sorters: [{
					             property: 'name',
					            direction: 'ASC'
					      }],
					    reader : {
								      type:'json'
						},
						expanded :true
				},
			
				// 设置根节点
				root : {
					//默认展开			   
				    expanded : true
				}
								
	    }),

	    initComponent : function() {
			this.callParent(arguments);
		
		}
})


