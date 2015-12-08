/**
 * GIS-Store
 * @author LW
 * @date 2012-5-29
 */
Ext.define('RYIVS.store.gis.GisEdit', {
	extend : 'Ext.data.Store',
	model : 'RYIVS.model.gis.GisEdit',
	fields : ['id', 'resid', 'layer', 'type', 'style', 'data'],
	autoLoad : ry.constant.autoLoad,
	remoteSort : ry.constant.remoteSort,
	pageSize : ry.constant.pageSize,
	autoSync : ry.constant.autoSync,
	sorters : [{
		property : 'id',
		direction : 'ASC'
	}],
})