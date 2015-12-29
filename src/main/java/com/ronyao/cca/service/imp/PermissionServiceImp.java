package com.ronyao.cca.service.imp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import com.ronyao.cca.constant.ConstDictionary;
import com.ronyao.cca.constant.ConstPermission;
import com.ronyao.cca.db.dao.PermissionMapper;
import com.ronyao.cca.db.dao.RoleMapper;
import com.ronyao.cca.db.dao.RolePermissionLinkMapper;
import com.ronyao.cca.db.dao.UserRoleLinkMapper;
import com.ronyao.cca.db.model.Permission;
import com.ronyao.cca.db.model.PermissionExample;
import com.ronyao.cca.db.model.RolePermissionLink;
import com.ronyao.cca.db.model.RolePermissionLinkExample;
import com.ronyao.cca.db.model.User;
import com.ronyao.cca.db.model.UserRoleLink;
import com.ronyao.cca.db.model.UserRoleLinkExample;
import com.ronyao.cca.service.PermissionService;
import com.ronyao.cca.ui.vo.TreeVo;


/**权限资源表管理
 * 
 * @author user
 *
 */
@Service
public class PermissionServiceImp implements PermissionService{


	private static final Logger LOG=org.slf4j.LoggerFactory.getLogger(PermissionServiceImp.class);
	
	@Resource
	private PermissionMapper  permissionMapper;
	
	@Resource
	private ConstDictionary  constDictionary;
	
	@Autowired
	private  RoleMapper roleMapper;
	
	@Autowired
	private UserRoleLinkMapper userRoleLinkMapper;
	@Autowired
	private RolePermissionLinkMapper rolePermissionLinkMapper;
	

	/**权限资源,根据用户id,查询对应用户的权限菜单信息
	 * 
	 */
	@SuppressWarnings("unchecked")
	private Map<Integer, List<Permission>> getPermissionMenuParentIdMap() {
	
		Map<Integer, List<Permission>>	permissionMenuParentIdMap=new HashMap<Integer, List<Permission>>();
		
//	           获取session
		HttpSession session = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession();
		User user=(User) session.getAttribute("loginUser");
		if(user==null || user.getId()==null){
			return permissionMenuParentIdMap;
		}
		permissionMenuParentIdMap=(Map<Integer, List<Permission>>) session.getAttribute("permissionMenuParentIdMap");
		if(	permissionMenuParentIdMap!=null){
			return permissionMenuParentIdMap;
		}else{
			LOG.debug("初始权限菜单列表,并保存到session,  loginName="+user.getLoginname());
			permissionMenuParentIdMap=new HashMap<Integer, List<Permission>>();
		}
		
		//查询用户对应的角色
		UserRoleLinkExample  urlExample=new UserRoleLinkExample();
		urlExample.createCriteria().andUseridEqualTo(user.getId());
		List<UserRoleLink>  userRoleLinkList=userRoleLinkMapper.selectByExample(urlExample);
		if(userRoleLinkList.isEmpty()){
			return  permissionMenuParentIdMap;
		}
		List<Integer>   roleIdList=new ArrayList<Integer>();
		for (UserRoleLink userRoleLink : userRoleLinkList) {
			roleIdList.add(userRoleLink.getRoleid());
			
		}
		RolePermissionLinkExample rolePermissionLinkExample  =new RolePermissionLinkExample();
		
		rolePermissionLinkExample.createCriteria().andRoleidIn(roleIdList);
		List<RolePermissionLink>  rpList=rolePermissionLinkMapper.selectByExample(rolePermissionLinkExample);
		if(rpList.isEmpty()){
			return permissionMenuParentIdMap;
		}
		List<Integer>  permissionIdList=new ArrayList<Integer>();
		for (RolePermissionLink rolePermissionLink : rpList) {
			permissionIdList.add(rolePermissionLink.getPermissionid());
		}
		
		//权限菜单资源
		PermissionExample  permissionExample=new PermissionExample();
		permissionExample.createCriteria().andTypeEqualTo(ConstPermission.MENU).andIdIn(permissionIdList);
		List<Permission>  permissionMenuList=permissionMapper.selectByExample(permissionExample);
		
		if(!permissionMenuList.isEmpty()){
			
				for (Permission permission : permissionMenuList) {
						List<Permission>  perMapList=permissionMenuParentIdMap.get(permission.getParentid());
						if(perMapList==null){
							perMapList=new ArrayList<Permission>();
						}else{
							perMapList=permissionMenuParentIdMap.get(permission.getParentid());
						}
						perMapList.add(permission);
						permissionMenuParentIdMap.put(permission.getParentid(), perMapList);
					}
		}
		session.setAttribute("permissionMenuParentIdMap", permissionMenuParentIdMap);
		return permissionMenuParentIdMap;
	}
	
	public List<TreeVo> getPermissionMenuTree(TreeVo treeVo) {
		

	
		//查询对应父节点的下级菜单节点
		if(treeVo.getParentId()==null){
			treeVo.setParentId(ConstPermission.ROOT_NODE_ID);
		}
		
		Map<Integer, List<Permission>>  permissionMenuParentIdMap=getPermissionMenuParentIdMap();
		
		List<Permission> perList=permissionMenuParentIdMap.get(treeVo.getParentId());
		
	
		List<TreeVo> treeList=new ArrayList<TreeVo>();
		if(perList==null || perList.isEmpty()){
			return treeList;
		}
		//判断查询出的节点是否存在下级节点
		for (Permission permission : perList) {
			TreeVo    tree=new TreeVo();
			List<Permission >  childPermisssionList= permissionMenuParentIdMap.get(permission.getId());
			if(childPermisssionList!=null && !childPermisssionList.isEmpty()){
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
		return treeList;
		
		
	
//		//查询对应父节点的下级菜单节点
//		PermissionExample  perExample=new PermissionExample();
//		Criteria  criPer=perExample.createCriteria();
//		criPer.andTypeEqualTo(ConstPermission.MENU);
//		if(treeVo.getParentId()==null){
//			treeVo.setParentId(ConstPermission.ROOT_NODE_ID);
//		}
//		criPer.andParentidEqualTo(treeVo.getParentId());
//		List<Permission> perList=permissionMapper.selectByExample(perExample);
//		
//		//判断查询出的节点是否存在下级节点
//		List<TreeVo> treeList=new ArrayList<TreeVo>();
//		if(!perList.isEmpty()){
//			
//			for (Permission permission : perList) {
//				TreeVo    tree=new TreeVo();
//				PermissionExample  childPerExample=new PermissionExample();
//				childPerExample.createCriteria().andParentidEqualTo(permission.getId());
//				Integer childNum=permissionMapper.countByExample(childPerExample);
//				if(childNum>0){
//					tree.setLeaf(false);
//				}else{
//					tree.setLeaf(true);
//				}
//				tree.setId(permission.getId());
//				tree.setText(permission.getName());
//				tree.setParentId(permission.getParentid());
//				tree.setUrl(permission.getUrl());
//				treeList.add(tree);
//			}
//			
//		}
	}
	
	

}
