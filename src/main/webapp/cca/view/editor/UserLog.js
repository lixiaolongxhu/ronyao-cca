/**
 * 用户日志的视图
 */
var selModel = Ext.create('Ext.selection.CheckboxModel', {
 listeners: {
        selectionchange: function(sm, selections) {
        	var removeButton = Ext.ComponentQuery.query('gridEditUserLog')[0].query('button[itemId=removeButton]')[0];
            removeButton.setDisabled(selections.length === 0);
        }
    }
});

// Add the additional 'advanced' VTypes
Ext.apply(Ext.form.field.VTypes, {
    daterange: function(val, field) {
        var date = field.parseDate(val);

        if (!date) {
            return false;
        }
        if (field.startDateField && (!this.dateRangeMax || (date.getTime() != this.dateRangeMax.getTime()))) {
            var start = field.up('toolbar').down('#' + field.startDateField);
            start.setMaxValue(date);
            start.validate();
            this.dateRangeMax = date;
        }
        else if (field.endDateField && (!this.dateRangeMin || (date.getTime() != this.dateRangeMin.getTime()))) {
            var end = field.up('toolbar').down('#' + field.endDateField);
            end.setMinValue(date);
            end.validate();
            this.dateRangeMin = date;
        }
        /*
         * Always return true since we're only using this vtype to set the
         * min/max allowed values (these are tested for after the vtype test)
         */
        return true;
    },

    daterangeText: 'Start date must be less than end date',

    password: function(val, field) {
        if (field.initialPassField) {
            var pwd = field.up('form').down('#' + field.initialPassField);
            return (val == pwd.getValue());
        }
        return true;
    },

    passwordText: 'Passwords do not match'
});


Ext.define('RYIVS.view.editor.UserLog', {
	extend : 'Ext.grid.Panel',
	alias : 'widget.gridEditUserLog',
	title : '日志管理',
	iconCls : 's_userLog',
	store:'editor.UserLog',
	collapsible:false,
	viewConfig: {
		emptyText:'<div style="text-align:center; padding:50px; color:gray">没有数据可显示</div>',
        deferEmptyText:false
    },
	// 定义 colums
	columns : [{
		text : 'ID',
		sortable : true,
		dataIndex : 'id',
		flex : 1
		}, {
		text : '用户姓名',
//				sortable : true,
		dataIndex : 'uid',
		flex : 1,
		queryMode : 'local',
		valueField : 'uid',
		lazyRender : true,
		displayField : 'uname',
		renderer : function(value) {
			var res = Ext.getStore('editor.User').data.getByKey(value);
			if (res) {
				return res.data.uname;
			} else {
				return '系统内部联动！';
			}
		}
		}, {
		header : '用户行为',
		dataIndex : 'userAction',
		flex : 3
		}, {
		text : '操作时间',
		dataIndex : 'operateTime',
		flex : 1,
		renderer : function(value) {
			var date = new Date(value);
			return Ext.Date.format(date, 'Y-m-d G:i:s');
		}
		}, {
		text : 'IP地址',
		sortable : true,
		dataIndex : 'ipAddress',
		flex : 1
		}, {
		header : '备注信息',
		dataIndex : 'commentInfo',
		flex : 1
	}],
	
	bbar : {
		xtype : 'pagingtoolbar',
		id:'pagingtool',
		store : 'editor.UserLog',
		displayerInfo : true
	},
	
	frame:true,
	columnLines: true,
	selModel: selModel,
	
	dockedItems: [{
   	 	xtype: 'toolbar',
   	 	items: [{
	        itemId: 'removeButton',
	        width:50,
	        icon : 'res/icon/delete.png',
	        text:'删除',
	        tooltip:'删除所有选中的日志记录',
	        iconCls:'remove',
	        disabled: true
	    },'-',{
	        itemId: 'refreshButton',
	        width:50,
	        icon : 'res/icon/sync.png',
	        text:'刷新',
	        tooltip:'刷新日志记录'
	    },'-',{disabled:true},'开始日期:',{
	        xtype: 'datefield',
			editable:false,
			format:'Y-m-d',
			id: 'begin_time',
			itemId: 'begin_time',
			maxValue : new Date(),
			endDateField: 'end_time',
            vtype: 'daterange'
	    },'-',{disabled:true},'结束日期:',{
	        xtype: 'datefield',
			editable:false,
			format:'Y-m-d',
			id: 'end_time',
			maxValue : new Date(),
			itemId: 'end_time',
			startDateField: 'begin_time',
            vtype: 'daterange'
	    },'-',{
	    	itemId: 'searchButton',
	    	icon : 'res/icon/query.png',
	        text:'查询',
	        tooltip:'search some rows',
	        iconCls:'add'
	    },'-',{
	    	itemId: 'clearnButton',
	    	icon : 'res/icon/clear.png',
	        text:'清空查询条件',
	        tooltip:'clear'
	    } ]
    }],
	
	initComponent:function(){
		this.callParent(arguments);
	}
});
