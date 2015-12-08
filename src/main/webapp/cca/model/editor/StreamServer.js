/**
 * 流媒体服务器
 */
Ext.define('RYIVS.model.editor.StreamServer', {
	extend : 'Ext.data.Model',
	fields : [ 'id', 'name', 'ip', 'port', 'comment' ],
	validations : [{
		type : 'length',
		field : 'port',
		min : 1
	}, {
		type : 'length',
		field : 'name',
		min : 1
	}, {
		type : 'format',
		field : 'ip',
		matcher : /^((25[0-5])|(2[0-4]\d)|(1\d\d)|([1-9]\d)|\d)(\.((25[0-5])|(2[0-4]\d)|(1\d\d)|([1-9]\d)|\d)){3}$/
	}],
	proxy : {
		type : 'direct',
		api : {
			read : actionStreamServer.read,
			create : actionStreamServer.create,
			update : actionStreamServer.update,
			destroy : actionStreamServer.destroy
		},

		reader : {
			type : 'json',
			root : 'records'
		},

		writer : {
			type : 'json'
		}
	}
});
