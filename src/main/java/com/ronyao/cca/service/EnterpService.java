package com.ronyao.cca.service;

/**企业基本信息管理服务
 * 
 * @author user
 *
 */
public interface EnterpService {

	/**通过主键删除企业基本信息表,并删除关联表的相关信息
	 * @param saveFilePath 
	 * 
	 * @return
	 */
	
	int deleteByPrimaryKey(Integer id, String saveFilePath) throws Exception;

}
