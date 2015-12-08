/**
 * 自定义field验证
 */
Ext.apply(Ext.form.field.VTypes, {
	/**
	 * @config vtype:check2compare
	 * @config  check2Text is required
	 * @param {} val
	 * @param {} field
	 * @return {Boolean}
	 */
	check2compare : function(val, field) {
		var res = true;
		if (field.check2Text == "first") {
            var second = field.ownerCt.down("timefield[check2Text=second]");
            if(field.value && field.maxValue) {
        		res = !(field.value > field.maxValue);
            }
            second.setMinValue(val);
        }else if (field.check2Text == "second") {
            var first = field.ownerCt.down("timefield[check2Text=first]");
            if(field.value && field.minValue) {
            	res = !(field.value < field.minValue);
            }
            first.setMaxValue(val);
        }
        return res;
	},
	check2compareText : '开始时间必须小于结束时间！',
	
	
	/**
	 * 验证日期
	 * @param {} val
	 * @param {} field
	 * @return {Boolean}
	 */
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
        return true;
    },

    daterangeText: '开始日期必须小于结束日期！'
});