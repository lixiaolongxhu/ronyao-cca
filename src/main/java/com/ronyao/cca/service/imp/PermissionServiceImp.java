package com.ronyao.cca.service.imp;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;


import com.ronyao.cca.constant.ConstPermission;
import com.ronyao.cca.db.dao.PermissionMapper;
import com.ronyao.cca.db.model.Permission;
import com.ronyao.cca.db.model.PermissionExample;
import com.ronyao.cca.db.model.PermissionExample.Criteria;
import com.ronyao.cca.service.PermissionService;
import com.ronyao.cca.ui.vo.TreeVo;


/**权限资源表管理
 * 
 * @author user
 *
 */
@Service
public class PermissionServiceImp implements PermissionService{

	@Resource
	private PermissionMapper   permissionMapper;
	
	public List<TreeVo> getPermissionMenuTree(TreeVo treeVo) {
		
		//查询对应父节点的下级菜单节点
		PermissionExample  perExample=new PermissionExample();
		Criteria  criPer=perExample.createCriteria();
		criPer.andTypeEqualTo(ConstPermission.MENU);
		if(treeVo.getParentId()==null){
			treeVo.setParentId(ConstPermission.ROOT_NODE_ID);
		}
		criPer.andParentidEqualTo(treeVo.getParentId());
		List<Permission> perList=permissionMapper.selectByExample(perExample);
		
		//判断查询出的节点是否存在下级节点
		List<TreeVo> treeList=new ArrayList<TreeVo>();
		if(!perList.isEmpty()){
			
			for (Permission permission : perList) {
				TreeVo    tree=new TreeVo();
				PermissionExample  childPerExample=new PermissionExample();
				childPerExample.createCriteria().andParentidEqualTo(permission.getId());
				Integer childNum=permissionMapper.countByExample(childPerExample);
				if(childNum>0){
					tree.setLeaf(false);
				}else{
					tree.setLeaf(true);
				}
				tree.setId(permission.getId());
				tree.setText(permission.getName());
				tree.setParentId(permission.getParentid());
				tree.setUrl(permission.getUrl());
				treeList.add(tree);
			}
			
		}
	
		return treeList;
	}
	
	

}
