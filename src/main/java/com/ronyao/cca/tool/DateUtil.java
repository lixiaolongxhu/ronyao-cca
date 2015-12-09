package com.ronyao.cca.tool;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




/**时间操作工具类.
 * @author lixiaolong
 * @version datetime：2015年6月19日  下午2:03:07
 */
public final  class DateUtil {
	
	/**日志记录.
	 */
	private static final Logger LOG = LoggerFactory.getLogger(DateUtil.class);
	
	/**工具类，私有构造函数.
	 * 
	 */
	private DateUtil() {
		
	}
	
	
	/**时间格式指定为yyyy-MM-dd HH:mm:ss.
	 */
	public static final  String  	DATAFORMAT0 = "yyyy-MM-dd HH:mm:ss";
	
	/**时间格式指定yyyy-MM-dd.
	 */
	public static final  String  	DATAFORMAT1 = "yyyy-MM-dd";
	
	/**时间格式指定yyyy-MM-dd HH:mm:ss E.
	 */
	public static final  String  	DATAFORMAT2 = "yyyy-MM-dd HH:mm:ss E";
	
	/**时间格式指定yyyy-MM-dd HH:mm:ss.SSS.
	 */
	public static final  String  	DATAFORMAT3 = "yyyy-MM-dd HH:mm:ss.SSS";
	
	/**时间格式指定yyyy.
	 */
	public static final  String  	DATAFORMAT4 = "yyyy";
	
	/**时间格式指定yyyyMMddHHmmssSSS.
	 */
	public static final  String  	DATAFORMAT5 = "yyyyMMddHHmmssSSS";
	
	/**时间格式指定yyyy-MM.
	 */
	public static final  String  	DATAFORMAT6 = "yyyy-MM";

	/**毫秒转换为秒的技术单位.
	 */
	public static final  Integer    MS_SECOND_UNIT = 1000;
	
	/**秒转换为分的计算单位.
	 */
	public static final  Integer   	SECOND_MINUTE_UNIT = 60;
	
	/**分钟转换为小时计算单位.
	 * 
	 */
	public static final  Integer    MINUTE_HOUR_UNIT = 60;
	
	/**小时转换为天数计算单位.
	 * 
	 */
	public static final  Integer    HOUR_DAY_UNIT = 24;
	
	
	
	
	
	/**时间对象转换为指定格式的字符串.
	 * @param date 时间对象
	 * @param format 转换格式类型 
	 * @return  返回指定格式转换的时间字符串
	 */
	public static String dateToString(final Date date, final String format) {
		SimpleDateFormat sdf = null;
		if (date != null && format != null) {
			sdf = new SimpleDateFormat(
					format);
		}
		return sdf.format(date);

	}
	
	/**时间字符串转换为指定格式的对象.
	 * @param dateStr 时间字符串
	 * @param format 转换格式类型 
	 * @return  返回指定格式转换的时间对象
	 */
	public static Date stringToDate(final String dateStr, final String format) {
		SimpleDateFormat sdf = null;
		if (dateStr != null && format != null) {
			sdf = new SimpleDateFormat(
					format);
		}
		Date date = null;
		try {
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			LOG.error(ExceptionUtil.getExceptionDetail(e, "ParseException"));
		}
		return date;
		
	}
	
	/**比较两个时间相差的分钟数.
	 * @param start  比较的开始时间
	 * @param end    比较的结算时间
	 * @return  end-start=minute
	 */
	public static long diffMinutes(final Date start, final Date end) {		
		long diff = end.getTime() - start.getTime();
		long minute = diff / (MS_SECOND_UNIT * SECOND_MINUTE_UNIT);
		return minute;
	}
	
	/**比较两个时间相差的分钟数.
	 * @param start  比较的开始时间
	 * @param end    比较的结算时间
	 * @return  end-start=minute
	 */
	public static long diffMinutes(final String start, final String end) {	
		Date endDate = stringToDate(end, DATAFORMAT0);
		Date startDate = stringToDate(start, DATAFORMAT0);
		return diffMinutes(startDate, endDate);
	}
	
	/**比较两个时间相差的天数.
	 * @param start 比较的起始时间
	 * @param end   比较的结束时间
	 * @return  end-start=day
	 */
	public static long diffDays(final Date start, final Date end) {
		long diff = end.getTime() - start.getTime();
		long minuteUnit = MS_SECOND_UNIT * SECOND_MINUTE_UNIT;
		long dayUnit = minuteUnit * MINUTE_HOUR_UNIT * HOUR_DAY_UNIT;
		long days = diff / dayUnit;
		return days;
	}
	
	
	/**比较两个时间相差的天数.
	 * @param start 比较的起始时间
	 * @param end   比较的结束时间
	 * @return  end-start=day
	 */
	public static long diffDays(final String start, final String end) {
		Date endDate = stringToDate(end, DATAFORMAT0);
		Date startDate = stringToDate(start, DATAFORMAT0);
		return diffDays(startDate, endDate);
	}
	
	
	/**判断字符串是否满足时间格式.
	 * 
	 * @param dateString  时间是否串
 	 * @param format  指定时间格式
	 * @return  返回状态，如果是指定时间格式的字符串返回true；否则 返回false
	 */
	public static boolean isDate(final String dateString, final String format) {
		if (dateString!=null) {
			SimpleDateFormat formatter = new SimpleDateFormat(format);
			formatter.setLenient(false);
			try {
				formatter.format(formatter.parse(dateString));
			} catch (Exception e) {
				LOG.error(ExceptionUtil.getExceptionDetail(e, "时间格式校验异常"));
				return false;
			}
			return true;
		}
		return false;

	}
	
	
	
	/**判断某时间在某时间之前.
	 * 
	 * @param compare  被比较的时间字符串
	 * @param when     比较的时间字符串
	 * @param format   时间字符串的格式
	 * @return    when在compare 之前 返回 true ,反之返回false
	 */
	public static boolean isBefore(final String when , final String compare,
			final String format) {

		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date dateWhen = null;
		Date dateCom = null;
		try {
			dateWhen = sdf.parse(when);
			dateCom = sdf.parse(compare);
		} catch (ParseException e) {
			LOG.error(ExceptionUtil.getExceptionDetail(e, "ParseException"));
		}
		return dateWhen.before(dateCom);

	}

	

	/**判断某时间在某时间之后.
	 * @param compare  被比较的时间字符串
	 * @param when     比较的时间字符串
	 * @param format   时间字符串的格式
	 * @return   when 在 compare 在之后  返回 true ,反之返回false
	 */
	public static boolean isAfter(final String when , final String compare,
			final String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date dateWhen = null;
		Date dateCom = null;
		try {
			dateWhen = sdf.parse(when);
			dateCom = sdf.parse(compare);
		} catch (ParseException e) {
			LOG.error(ExceptionUtil.getExceptionDetail(e, "ParseException"));
		}
		return dateWhen.after(dateCom);
		
	}
	
	/**获取当天开始时间比如：2015-08-04 00:00:00.
	 * @return  返回当天的开始时间字符串
	 * @author lpx
	 * @date 创建时间：2015年8月4日 下午2:40:52
	 */
	public static String getDayStartTime() {  
		Calendar currentDate = new GregorianCalendar();   
		currentDate.set(Calendar.HOUR_OF_DAY, 0);  
		currentDate.set(Calendar.MINUTE, 0); 
		currentDate.set(Calendar.SECOND, 0);
		Date currentTime = currentDate.getTime();
		String startTime = dateToString(currentTime, DateUtil.DATAFORMAT0);
        return startTime;
    }  
      
    /**获取当天结束时间比如：2015-08-04 23:59:59.
     * @return  返回当前结束时间字符串
     * @author lpx
     * @date 创建时间：2015年8月4日 下午2:47:32
     */
    public static String getDayEndTime() {  
    	Calendar currentDate = new GregorianCalendar();   
    	currentDate.set(Calendar.HOUR_OF_DAY, HOUR_DAY_UNIT - 1);  
    	currentDate.set(Calendar.MINUTE, MINUTE_HOUR_UNIT - 1);  
    	currentDate.set(Calendar.SECOND, SECOND_MINUTE_UNIT - 1);
    	Date currentTime = currentDate.getTime();
    	String endTime = dateToString(currentTime, DateUtil.DATAFORMAT0);
        return endTime;
    }  
  
    /**校验时分秒格式：00:00:00.
     * 
     * @param time  待校验的时间
     * @return  返回是否满足要求的格式
     */
    public static boolean checkIsNotTime(String time) {
		  String regex = "^([0-1]?[0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])$";
		  Pattern p = Pattern.compile(regex);
		  Matcher m = p.matcher(time);
		  return !m.matches();
	}
    
    /**校验时分秒格式：00:00:00.
     * 
     * @param time  待校验的时间
     * @return  返回是否满足要求的格式
     */
    public static boolean checkIsTime(String time) {
		  String regex = "^([0-1]?[0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])$";
		  Pattern p = Pattern.compile(regex);
		  Matcher m = p.matcher(time);
		  return m.matches();
	}
    
    /**得到几天前的时间.
     *  
     * @param d 起送时间
     * @param day  相隔的天数
     * @return   返回几天前的时间
     */  
    public static Date getDateBefore(Date d, int day) {  
        Calendar now = Calendar.getInstance();  
        now.setTime(d);  
        now.set(Calendar.DATE, now.get(Calendar.DATE) - day);  
        return now.getTime();  
    }   
    
    /**得到几天后的时间.
     *  
     * @param d  开始时间
     * @param day  相隔的时间
     * @return  返回几天后的时间
     */  
    public static Date getDateAfter(Date d, int day) {  
        Calendar now = Calendar.getInstance();  
        now.setTime(d);  
        now.set(Calendar.DATE, now.get(Calendar.DATE) + day);  
        return now.getTime();  
    }
    
   /**测试.
    *  
    * @param args 参数.
    */
   public static void main(String[] args) {
//	  System.out.println(DateUtil.dateToString(new Date(), DateUtil.DATAFORMAT0));
//	  System.out.println(getDateAfter(new Date(),1));
//	  System.out.println(getDateAfter(new Date(),2));
   }
}
