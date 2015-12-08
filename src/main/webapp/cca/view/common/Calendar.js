/*
 * 告警事件查询
 */

// Don't forget to reconfigure!
Extensible.calendar.data.EventModel.reconfigure();

Ext.define('RYIVS.view.common.Calendar', {
	extend : 'Extensible.calendar.CalendarPanel',
	requires : [ 'Extensible.calendar.data.MemoryCalendarStore', 'Extensible.calendar.data.EventStore' ],
	alias : 'widget.eventCalendar',
	title : '历史事件查询',
	iconCls : 's_history',
	showDayView : false,
	showWeekView : false,
	showMultiWeekView : false,
	showNavJump : false,
	monthText : '月视图',
	todayText : '今天',
	readOnly : true,

	initComponent : function() {

		// -----------------------------------------------------------
		Extensible.calendar.data.EventMappings = {
			EventId : {
				name : 'ID',
				mapping : 'aid',
				type : 'int'
			}, // int by default
			CalendarId : {
				name : 'Type',
				mapping : 'atype',
				type : 'int'
			}, // int by default

			Title : {
				name : 'Title',
				mapping : 'title'
			},

			StartDate : {
				name : 'StartDt',
				mapping : 'atimeS',
				type : 'date',
				dateFormat : 'c'
			},
			EndDate : {
				name : 'EndDt',
				mapping : 'atimeS',
				type : 'date',
				dateFormat : 'c'
			},
			// ----------------------------------
			RRule : {
				name : 'RecurRule',
				mapping : 'recur_rule'
			},
			Location : {
				name : 'Location',
				mapping : 'location'
			},
			Notes : {
				name : 'Desc',
				mapping : 'full_desc'
			},
			Url : {
				name : 'LinkUrl',
				mapping : 'link_url'
			},
			IsAllDay : {
				name : 'AllDay',
				mapping : 'all_day',
				type : 'boolean'
			},
			Reminder : {
				name : 'Reminder',
				mapping : 'reminder'
			},

			// We can also add some new fields that do not exist in the standard
			// EventRecord:
			CreatedBy : {
				name : 'CreatedBy',
				mapping : 'created_by'
			},
			IsPrivate : {
				name : 'Private',
				mapping : 'private',
				type : 'boolean'
			}
		};
		
		Extensible.calendar.data.EventModel.reconfigure();

		// ---------------------------------------------------
		this.eventStore = Ext.create('Extensible.calendar.data.EventStore', {
			autoLoad : true,
			proxy : {
				type : 'direct',
				api : {
					read : actionCalendar.read
				},
				noCache : false,

				reader : {
					type : 'json',
					root : 'records'
				},

				listeners : {
					exception : function(proxy, response, operation, options) {
						var msg = response.message ? response.message : Ext.decode(response.responseText).message;
						// ideally an app would provide a less intrusive message
						// display
						Ext.Msg.alert('Server Error', msg);
					}
				}
			},

			// It's easy to provide generic CRUD messaging without having to
			// handle events on every individual view.
			// Note that while the store provides individual add, update and
			// remove events, those fire BEFORE the
			// remote transaction returns from the server -- they only signify
			// that records were added to the store,
			// NOT that your changes were actually persisted correctly in the
			// back end. The 'write' event is the best
			// option for generically messaging after CRUD persistence has
			// succeeded.
			listeners : {
				'write' : function(store, operation) {
					var title = Ext.value(operation.records[0].data[Extensible.calendar.data.EventMappings.Title.name], '(No title)');
					switch (operation.action) {
					case 'create':
						// Extensible.example.msg('Add', 'Added "' + title +
						// '"');
						break;
					case 'update':
						// Extensible.example.msg('Update', 'Updated "' + title
						// + '"');
						break;
					case 'destroy':
						// Extensible.example.msg('Delete', 'Deleted "' + title
						// + '"');
						break;
					}
				}
			}
		});

		// -----------------------------------------------------------------------

		this.calendarStore = Ext.create('Extensible.calendar.data.MemoryCalendarStore', {
			autoLoad : true,
			proxy : {
				type : 'ajax',
				url : '/lib/extensible/examples/calendar/data/calendars.json',
				noCache : false,

				reader : {
					type : 'json',
					root : 'calendars'
				}
			}
		});

		this.callParent(arguments);
	}
});
