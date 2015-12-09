package com.ronyao.cca.tool;


/**异常信息处理的工具类.
 * 
 * @author lixiaolong
 *
 */
public final  class ExceptionUtil {
	
	/**私有构造函数.
	 * 
	 */
	private ExceptionUtil(){
		
	}

	/**获取exception详情信息.
	 * @param e 异常信息对象
	 * @param description  异常描述
	 * @return  将异常对象转换为字符串
	 */
	public static String getExceptionDetail(Exception e, String description) {

		StringBuffer msg = new StringBuffer("");
		if (e != null) {
			msg = new StringBuffer(description);
			msg.append("---");

			String message = e.toString();

			int length = e.getStackTrace().length;

			if (length > 0) {

				msg.append(message + "\n");

				for (int i = 0; i < length; i++) {

					msg.append("\t" + e.getStackTrace()[i] + "\n");

				}
			} else {

				msg.append(message);
			}

		}
		return msg.toString();

	}

	/**获取exception详情信息.
	 * @param e 异常信息对象
	 * @return  将异常对象转换为字符串
	 */
	public static String getExceptionDetail(Exception e) {
		return getExceptionDetail(e, "");
	}
}
