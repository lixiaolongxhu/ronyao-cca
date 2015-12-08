/**
 * author : tqd
 * model : 联动动作ptzpos
 */
Ext.define('RYIVS.model.video.RuleActionPtzPos', {
	extend : 'Ext.data.Model',
	fields : [ 
		{name: 'id', type: 'int'},
        {name: 'resid', type: 'int'},
        {name: 'parm1', type: 'string', mapping : 'pos'},
        {name: 'parm1Name', type: 'string', mapping : 'name'}
	]
});