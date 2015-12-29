package com.ronyao.cca.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ronyao.cca.db.dao.BehaviorMapper;
import com.ronyao.cca.db.dao.EnterpriseEquipmentMapper;
import com.ronyao.cca.db.dao.EnterpriseFileMapper;
import com.ronyao.cca.db.dao.EnterpriseMapper;
import com.ronyao.cca.db.dao.EnterprisePerFileMapper;
import com.ronyao.cca.db.dao.EnterprisePerManageMapper;
import com.ronyao.cca.db.dao.EnterprisePersonMapper;
import com.ronyao.cca.db.dao.ProjectBuildMapper;
import com.ronyao.cca.db.model.BehaviorExample;
import com.ronyao.cca.db.model.EnterpriseEquipmentExample;
import com.ronyao.cca.db.model.EnterpriseFile;
import com.ronyao.cca.db.model.EnterpriseFileExample;
import com.ronyao.cca.db.model.EnterprisePerFile;
import com.ronyao.cca.db.model.EnterprisePerFileExample;
import com.ronyao.cca.db.model.EnterprisePerManageExample;
import com.ronyao.cca.db.model.EnterprisePerson;
import com.ronyao.cca.db.model.EnterprisePersonExample;
import com.ronyao.cca.db.model.ProjectBuildExample;
import com.ronyao.cca.service.EnterpService;
import com.ronyao.cca.tool.FileUtil;

/**企业基本信息
 * 
 * @author user
 *
 */
@Service
public class EnterpServiceImp implements EnterpService {

	@Resource
	private EnterpriseMapper enterpriseMapper;
	
	@Resource
	private EnterprisePersonMapper enterprisePersonMapper;
	
	@Resource
	private EnterprisePerFileMapper enterprisePerFileMapper;
	
	@Resource
	private EnterprisePerManageMapper enterprisePerManageMapper;
	
	@Resource
	private ProjectBuildMapper projectBuildMapper;
	
	@Resource
	private EnterpriseEquipmentMapper enterpriseEquipmentMapper;
	
	@Resource
	private BehaviorMapper behaviorMapper;
	
	@Resource
	private EnterpriseFileMapper  enterpriseFileMapper;
	
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
	public int deleteByPrimaryKey(Integer id, String saveFilePath) throws Exception {
		
		EnterprisePersonExample  epExample=new EnterprisePersonExample();
		epExample.createCriteria().andEnterpriseidEqualTo(id);
		List<EnterprisePerson> epList=enterprisePersonMapper.selectByExample(epExample);
		if(!epList.isEmpty()){
			for (EnterprisePerson enterprisePerson : epList) {
				//删除企业持证人员管理的附件信息
				EnterprisePerFileExample epfExample=new EnterprisePerFileExample();
				epfExample.createCriteria().andEnterpriseperidEqualTo(enterprisePerson.getId());
				
				List<EnterprisePerFile>  epfList=enterprisePerFileMapper.selectByExample(epfExample);
				
				if(!epfList.isEmpty()){
					for (EnterprisePerFile enterprisePerFile : epfList) {
						saveFilePath=saveFilePath+enterprisePerFile.getPath();
						FileUtil.deleteFile(saveFilePath);
						enterprisePerFileMapper.deleteByPrimaryKey(enterprisePerFile.getId());
					}
				}
			}
		}
		
		
		//删除企业基本信息关联的持证人员信息
		enterprisePersonMapper.deleteByExample(epExample);
		
		//删除企业基本信息关联的现场管理人员
		EnterprisePerManageExample  epmExample=new EnterprisePerManageExample();
		epmExample.createCriteria().andEnterpriseidEqualTo(id);
		enterprisePerManageMapper.deleteByExample(epmExample);
		
		//删除企业基本信息关联  在建工程与中标未开工工程信息
		ProjectBuildExample  pbExample=new ProjectBuildExample();
		pbExample.createCriteria().andEnterpriseidEqualTo(id);
		projectBuildMapper.deleteByExample(pbExample);
		
	
		//删除关联的设备信息
		EnterpriseEquipmentExample  eeExample=new EnterpriseEquipmentExample();
		eeExample.createCriteria().andEnterpriseidEqualTo(id);
		enterpriseEquipmentMapper.deleteByExample(eeExample);
		
		//删除关联的不良行为
		BehaviorExample  bExample=new BehaviorExample();
		bExample.createCriteria().andEnterpriseidEqualTo(id);
		behaviorMapper.deleteByExample(bExample);
		
		//删除关联的企业资质证件
		EnterpriseFileExample efExample=new EnterpriseFileExample();
		efExample.createCriteria().andEnterpriseidEqualTo(id);
		List<EnterpriseFile>  eeList=enterpriseFileMapper.selectByExample(efExample);
		if(!eeList.isEmpty()){
			for (EnterpriseFile enterpriseFile : eeList) {
				saveFilePath=saveFilePath+enterpriseFile.getPath();
				FileUtil.deleteFile(saveFilePath);
				enterpriseFileMapper.deleteByPrimaryKey(enterpriseFile.getId());
			}
		}
		//默认只有运行时异常,才会进行事物回滚
//		throw new  RuntimeException("事物异常测试");
		return enterpriseMapper.deleteByPrimaryKey(id);
	}

}
