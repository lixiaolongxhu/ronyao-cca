
Ext.define('RYIVS.view.display.BehaviorStaLookover', {
	
	extend : 'Ext.form.Panel',
	id : 'behaviorStaLookover',  //Ext.getCmp 根据id 获取对象是,要求对象必须实例后或者已被调用实例,只被声明,是无法获取到对象的
	alias : 'widget.behaviorStaLookover',
	title : '查看详情(不良行为标准)',
	iconCls : 's_equipment',
	
	// 表单域 Fields 将被竖直排列, 占满整个宽度
    layout: 'anchor',
    defaults: {
        anchor: '100%'
    },

    // The fields  默认编辑域为文本编辑域
    defaultType: 'textfield',
    items: [
    	
    {
        fieldLabel: 'ID',
        name: 'id',
        allowBlank: false,
        disabled :true //控件不用
		
    },
    {
    	xtype : 'combo',
		listConfig : {
					emptyText : '未找到匹配值',//当值不在列表是的提示信息
					maxHeight : 60//设置下拉列表的最大高度为60像素
		},
		name:'ranktype',
		autoSelect : true,
		fieldLabel:'不良行为等级',
		triggerAction: 'all',//单击触发按钮显示全部数据
		store :ry.constant.behavior_standard_rankType, //调用外部js常量
		displayField:'province',//定义要显示的字段
		valueField:'post',//定义值字段
		queryMode: 'local',//本地模式
		forceSelection : true,//要求输入值必须在列表中存在
		typeAhead : true,//允许自动选择匹配的剩余部分文本
	//	disabled :true, //控件不用
		value:'1'//默认选择大兴
    	
    },
  
   {
    
    	xtype : 'textarea',
		fieldLabel : '诚信',
		id:'sincerity',//字段组件id
		labelSeparator :'：' //,//分隔符
		//labelWidth : 60,  //标签宽度
		//width:200
	}
	,{
    
    	xtype : 'textarea',
		fieldLabel : '安全质量',
		id:'save',//字段组件id
		labelSeparator :'：' //,//分隔符
		//labelWidth : 60,  //标签宽度
		//width:200
	},{
    
    	xtype : 'textarea',
		fieldLabel : '履约进度',
		id:'progress',//字段组件id
		labelSeparator :'：' //,//分隔符
		//labelWidth : 60,  //标签宽度
		//width:200
	},{
    
    	xtype : 'textarea',
		fieldLabel : '服务',
		id:'service',//字段组件id
		labelSeparator :'：' //,//分隔符
		//labelWidth : 60,  //标签宽度
		//width:200
	}
    ,{
    
    	xtype : 'textarea',
		fieldLabel : '其他',
		id:'other',//字段组件id
		labelSeparator :'：' //,//分隔符
		//labelWidth : 60,  //标签宽度
		//width:200
	}, {
        fieldLabel: '记录创建时间',
        name: 'createtime',
        allowBlank: false,
        disabled :true //控件不用
		
    }
    , {
        fieldLabel: '记录修改时间',
        name: 'updatetime',
        allowBlank: false,
        disabled :true //控件不用
		
    }
    
    ]
  
    
	
});
