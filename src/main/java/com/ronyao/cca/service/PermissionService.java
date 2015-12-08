package com.ronyao.cca.service;

import java.util.List;

import com.ronyao.cca.ui.vo.TreeVo;

/**权限资管表管理
 * 
 * @author user
 *
 */
public interface PermissionService {

	/**获取权限树菜单列表.
	 * 
	 * @param treeVo  请求查询参数
	 * @return
	 */
	List<TreeVo> getPermissionMenuTree(TreeVo treeVo);

}
