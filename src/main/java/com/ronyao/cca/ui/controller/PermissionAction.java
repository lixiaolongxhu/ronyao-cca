package com.ronyao.cca.ui.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ronyao.cca.service.PermissionService;
import com.ronyao.cca.ui.vo.TreeVo;



/**权限资源(菜单)基本信息管理.
 * 
 * @author user
 *
 */
@Controller
public class PermissionAction {

	@Resource
	private PermissionService permissionService;
	
	@RequestMapping(value="/permissionMenuTree")
	public @ResponseBody List<TreeVo> getPermissionMenuTree(TreeVo treeVo){


		return permissionService.getPermissionMenuTree(treeVo);
	}
}
