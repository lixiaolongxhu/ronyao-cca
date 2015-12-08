//Model
Ext.define('RYIVS.model.editor.RuleAction', {
	extend : 'Ext.data.Model',
	fields : [ 'id', 'rule', 'action', 'target', 'delay', 'parm1', 'parm2'],
	proxy : {
		type : 'direct',
		api : {
			read : actionRuleAction.read,
			create : actionRuleAction.create,
			update : actionRuleAction.update,
			destroy : actionRuleAction.destroy
		},
		reader : {
			type : 'json',
			root : 'records',
		},

		writer : {
			type : 'json'
		}
	}
});