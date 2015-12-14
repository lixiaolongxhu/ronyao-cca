package com.ronyao.cca.constant;

/**不良行为表常量
 */
public class ConstBehavior {
	
	/**不良行为修正系数常数.
	 * 
	 */
	public static final Float     CONST=5f;

	/**一般不良行为转换为严重不良行为常数, 规则: 一个自然年内在公司系统中发送3及以上的一般不良行为,则视为一次严重不良行为.
	 * 
	 * 
	 */
	public static final Float    GENERAL_TO_BAD=3f;
	
	/**一般不良行为转换为严重不良行为的次数规则常量.
	 * 
	 */
	public static final Float    GENERAL_TO_BAD_CONST=1f;
	
}
