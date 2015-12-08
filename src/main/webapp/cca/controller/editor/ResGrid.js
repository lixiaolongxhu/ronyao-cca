/**
 * 资源列表，用于配置页面
 */
Ext.define('RYIVS.controller.editor.ResGrid', {
	extend : 'Ext.app.Controller',
	models : [ 'common.ResGrid', 'gis.GisEditor' ],
	views : [ 'common.ResGrid', 'gis.GisEditor' ],

	refs : [ {
		selector : 'resGrid',
		ref : 'resGrid'
	}, {
		selector : 'gisEditor > gridEditBase[isMaster=false]',
		ref : 'gridEditBase'
	}, {
		selector : 'winPlayer ptzPos',
		ref : 'ptzPos'
	} ],

	init : function() {
		this.control({
			'resGrid' : {
				onDragDrop : this.onDragDrop,
				itemclick : this.itemClick,
				itemdblclick : this.itemDblClick,
				render : this.afterRender,
				selectionchange : this.onSelection
			},

			'resGrid>gridview' : {
				itemremove : this.itemRemove
			}
		});

		controller.resGrid = this;
	},

	// 得到Res的Store
	getResStore : function() {
		return this.getResGrid().store;
	},

	// 界面准备完成后的事件，只调用一次
	afterRender : function(panel, eOpts) {
		// 设定Resource Store的事件
		this.getResGrid().store.on("refresh", this.onResourceRefresh, this);
		this.getResGrid().store.on("remove", this.onResourceRemove, this);
		this.getResGrid().store.on("update", this.onResourceUpdate, this);

		Ext.direct.Manager.on('event', this.onDirectEvent, this);
	},

	// 远程数据存储后的回调
	onDirectEvent : function(event, provider, eOpts) {

		// 添加一个新资源
		if (event.action == 'actionResource' && event.method == "create" && event.result.success) {

			controller.resGrid.getResGrid().store.load();

			switch (event.result.records[0].type) {
			case 1:
				// 摄像机通道resid更新
				controller.encoder.slaverReload();
				break;
			case 9:
				// 定位点添加
				controller.rfid.refresh();
				break;
			default:
				// 控制器通道resid更新
				controller.controller.slaverReload();
				break;
			}
		}

		// 删除一个资源
		if (event.action == 'actionResource' && event.method == "destroy" && event.result) {
			controller.encoder.slaverReload();
			controller.rfid.refresh();
			controller.controller.slaverReload();
		}

	},
	// 资源刷新
	onResourceRefresh : function(store, eOpts) {

	},

	// 资源删除
	onResourceRemove : function(store, record, index, eOpts) {

	},

	// 资源更改（添加）
	onResourceUpdate : function(store, record, operation, modifiedFieldNames, eOpts) {

	},

	// 拖动控制
	onDragDrop : function(data, targetNode, position) {

		var record = data.records[0].data;

		// 对应的源控件
		if (record.resid) {
			Ext.Msg.alert('该资源已经添加', '该资源已经添加，你不需要重新添加！');
			return;
		}

		// 根据源数据进行相应的资源添加
		// 利用 state 来传递 Encoder、Controller、RFID的相关ID
		var insertData = {
			id : null,
			pid : 1,
			class : 1,
			type : 1,
			name : '',
			state : record.id,
			ord : 1
		};

		switch (data.view.ownerCt.dropClass) {
		// 添加视频资源
		case 1:
			insertData.type = 1;
			insertData.name = record.name;
			break;
		// 添加控制器资源
		case 2:
			insertData.type = record.type;
			insertData.name = record.name;
			break;
		// 手持定位设备
		case 3:
			insertData.type = 9;
			insertData.name = record.name;
			break;
		}

		// 添加资源
		this.getResGrid().store.insert(0, insertData);

	},

	// 删除后的事件
	itemRemove : function(record, index, eOpts) {

	},

	// 单击事件
	itemClick : function(view, record, item, index, e, eOpts) {

	},

	// 双击一个资源的时候
	itemDblClick : function(Eview, record, htmlItem, index, e, eOpts) {
		switch (record.data.type) {
			case 1: {
				var player = Ext.create('RYIVS.view.video.PlayerWin');
				player.resid = record.data.id;
				player.show();
				this.getPtzPos().store.proxy.setExtraParam("resid",player.resid);
				this.getPtzPos().store.load();
				break;
			}
		}
	},

	// 当一个项目选择改变的时候
	onSelection : function(view, selections, options) {
		// 如果没有选择，就退出
		if (selections[0] == undefined) {
			// 屏蔽 GIS 编辑
			ronyao.gis.ctlEdit.deactivate();
			return;
		}

		var record = selections[0];
		var resId = record.data.id;
		// 更新GIS子表
		ronyao.gis.ctlEdit.activate();
		controller.gisEditor.loadByResid(record.data.id,record.data.type);
		setTimeout( function(){
			if(controller.gisEditor.getGridEditorGis().getStore().data.items.length>0){
				var id = controller.gisEditor.getGridEditorGis().getStore().data.items[0].data.id;
				var resId = controller.gisEditor.getGridEditorGis().getStore().data.items[0].data.resid;
				var layer = controller.gisEditor.getGridEditorGis().getStore().data.items[0].data.layer;
				ronyao.gis.useResId=1;
				ronyao.gis.highLightByIdAndLayer(resId,layer);
			}else{
				ronyao.gis.layerLight.destroyFeatures();
			}
		}, 500);
	}
});
