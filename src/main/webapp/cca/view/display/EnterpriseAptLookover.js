
Ext.define('RYIVS.view.display.EnterpriseAptLookover', {
	
	extend : 'Ext.form.Panel',
	id : 'enterpriseAptLookover',  //Ext.getCmp 根据id 获取对象是,要求对象必须实例后或者已被调用实例,只被声明,是无法获取到对象的
	alias : 'widget.enterpriseAptLookover',
	title : '查看详情(企资质标准分类)',
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
		name:'aptitudeid',
		autoSelect : true,
		fieldLabel:'企业资质',
		triggerAction: 'all',//单击触发按钮显示全部数据
		store : ry.constant.enterprise_aptitude_classify, //调用外部js常量
		displayField:'province',//定义要显示的字段
		valueField:'post',//定义值字段
		queryMode: 'local',//本地模式
		forceSelection : true,//要求输入值必须在列表中存在
		typeAhead : true,//允许自动选择匹配的剩余部分文本
	//	disabled :true, //控件不用
		value:'1'//默认选择大兴
    	
    },
    {
    	xtype : 'combo',
		listConfig : {
					emptyText : '未找到匹配值',//当值不在列表是的提示信息
					maxHeight : 60//设置下拉列表的最大高度为60像素
		},
		name:'aptituderank',
		autoSelect : true,
		fieldLabel:'等级',
		triggerAction: 'all',//单击触发按钮显示全部数据
		store : ry.constant.enterprise_aptitude_rank, //调用外部js常量
		displayField:'province',//定义要显示的字段
		valueField:'post',//定义值字段
		queryMode: 'local',//本地模式
		forceSelection : true,//要求输入值必须在列表中存在
		typeAhead : true,//允许自动选择匹配的剩余部分文本
		//disabled :true, //控件不用
		value:'1'//默认选择大兴
    	
    }
    ,{
    	xtype :'textfield',
        fieldLabel: '资质要求',
        name: 'qualifications',
        allowBlank: false
      
    },{
    
    	xtype : 'textarea',
		fieldLabel : '执业资格<br/>(企业人员)',
		id:'practicing',//字段组件id
		labelSeparator :'：' //,//分隔符
		//labelWidth : 60,  //标签宽度
		//width:200
	}
	,{
    
    	xtype : 'textarea',
		fieldLabel : '技术负责人<br/>(企业人员)',
		id:'charge',//字段组件id
		labelSeparator :'：' //,//分隔符
		//labelWidth : 60,  //标签宽度
		//width:200
	},{
    
    	xtype : 'textarea',
		fieldLabel : '技术人员<br/>(企业人员)',
		id:'technical',//字段组件id
		labelSeparator :'：' //,//分隔符
		//labelWidth : 60,  //标签宽度
		//width:200
	},{
    
    	xtype : 'textarea',
		fieldLabel : '技能人员<br/>(企业人员)',
		id:'skills',//字段组件id
		labelSeparator :'：' //,//分隔符
		//labelWidth : 60,  //标签宽度
		//width:200
	}
    ,{
    
    	xtype : 'textarea',
		fieldLabel : '承包范围',
		id:'jobrange',//字段组件id
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
