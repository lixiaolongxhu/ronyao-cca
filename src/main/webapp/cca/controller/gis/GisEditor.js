//GIS编辑
Ext.define('RYIVS.controller.gis.GisEditor', {
	extend : 'Ext.app.Controller',
	models : [ 'gis.GisEditor' ],
	views : [ 'gis.GisView', 'gis.GisEditor' ],

	refs : [ {
		selector : 'gisEditor gridEditBase',
		ref : 'gridEditorGis'
	} ],

	init : function() {
		this.control({
			//给图层管理注册单击事件
			'gisEditor button[itemId=gisLayerManager]':{
				click:this.onLayerManagerClick
			},
			// 整个TAB的事件
			'gisEditor' : {
				activate : this.onActivate,
				deactivate : this.onDeactivate,
				afterrender : this.afterRender
			},

			// GIS元素编辑表格的事件
			'gisEditor > gridEditBase' : {
				selectionchange : this.onGisItemSelect
			}
		});

		controller.gisEditor = this;
		
		// 使能Gis的相关控件
		ronyao.gis.ctlDrag.activate();
	},

	onGisItemSelect : function(view, records) {
		if (!records.length) {
			return;
		}

		var item = records[0];
		ronyao.gis.useResId=0;
		ronyao.gis.highLightByIdAndLayer(item.data.id,item.data.layer);

	},

	// 只调用一次
	afterRender : function(panel, eOpts) {
		Ext.direct.Manager.on('event', this.onDirectEvent, this);
	},

	onDirectEvent : function(event, provider, eOpts) {
		// 刷新GIS
		if ((event.action == "actionGisRes") && (event.method == "destroy")) {
			this.getGridEditorGis().store.load();
			ronyao.gis.layerRes.refresh();
		}
		
		if ((event.action == "actionResource") && (event.method == "destroy")) {
			this.getGridEditorGis().store.load();
			ronyao.gis.layerRes.refresh();
		}
	},

	// 激活后加载数据
	onActivate : function(pa, options) {
		this.getGridEditorGis().store.on("datachanged", this.onUpdate, this);
		controller.resGrid.getResGrid().enableDrag(false);
	},

	onDeactivate : function(pa, options) {
		controller.resGrid.getResGrid().enableDrag(true);
	},

	onUpdate : function(store, eOpts) {
		
	},

	// 当前选择的资源ID和类型
	resid : 0,
	type : 0,

	// 加载对应RESID的GIS数据
	loadByResid : function(resid,type) {
		this.resid = resid;
		this.type = type;
		this.getGridEditorGis().loadByMasterId(this.resid,"resid");
	},
	
	//根据layerId加载GisRes数据
	loadGisResByLayerId : function(layerId) {
		this.layerId = layerId;
		//this.type = type;
		this.loadByLayerId(this.layerId,"layerid");
	},
	
		
	//发起对后台的请求以获取GisRes数据
	loadByLayerId : function(layerId, type) {
		var store = this.getGridEditorGis().store;
		if (layerId) {
			store.proxy.extraParams.masterId = layerId;
		}
		if (type) {
			store.proxy.extraParams.type = type;
		}

		if (store.proxy.extraParams.masterId && store.proxy.extraParams.type) {
			store.load();
		}
	},

	// 保存GIS数据
	saveFeature : function(data) {
		this.getGridEditorGis().store.insert(0, data);
	},

	// 更新GIS数据
	updateFeature : function(data) {
		actionGisRes.update(data);
	},
	
	onLayerManagerClick:function(){
		Ext.create("RYIVS.view.gis.GisLayerManager").show();
	}

});
