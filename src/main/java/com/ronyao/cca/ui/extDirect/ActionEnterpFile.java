package com.ronyao.cca.ui.extDirect;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ch.ralscha.extdirectspring.annotation.ExtDirectMethod;
import ch.ralscha.extdirectspring.annotation.ExtDirectMethodType;
import ch.ralscha.extdirectspring.bean.ExtDirectStoreReadRequest;
import ch.ralscha.extdirectspring.bean.ExtDirectStoreReadResult;

import com.ronyao.cca.db.dao.EnterpriseFileMapper;
import com.ronyao.cca.db.model.EnterpriseFile;
import com.ronyao.cca.db.model.EnterpriseFileExample;
import com.ronyao.cca.tool.DateUtil;

/**企业基本信息.对应资质信息的附件
 * 
 * @author user
 *
 */
@Service
public class ActionEnterpFile {
	@Autowired
	private EnterpriseFileMapper  enteprEnterpriseFileMapper;

	// 列表
	@ExtDirectMethod(value = ExtDirectMethodType.STORE_READ, group = "store")
	public ExtDirectStoreReadResult<EnterpriseFile> read(
			ExtDirectStoreReadRequest request) {
		EnterpriseFileExample eExample = new EnterpriseFileExample();
		return new ExtDirectStoreReadResult<EnterpriseFile>(enteprEnterpriseFileMapper.selectByExample(eExample));
	}

	// 插入
	@ExtDirectMethod(value = ExtDirectMethodType.STORE_MODIFY, group = "store")
	public ExtDirectStoreReadResult<EnterpriseFile> create(List<EnterpriseFile> enterprise) {
		enterprise.get(0).setCreatetime(DateUtil.dateToString(new Date(), DateUtil.DATAFORMAT0));
		enteprEnterpriseFileMapper.insert(enterprise.get(0));
		return new ExtDirectStoreReadResult<EnterpriseFile>(enterprise.get(0));
	}

	// 修改
	@ExtDirectMethod(value = ExtDirectMethodType.STORE_MODIFY, group = "store")
	public int update(List<EnterpriseFile> enterprise) {
		enterprise.get(0).setUpdatetime(DateUtil.dateToString(new Date(), DateUtil.DATAFORMAT0));
		return enteprEnterpriseFileMapper.updateByPrimaryKey(enterprise.get(0));
	}

	// 删除
	@ExtDirectMethod(value = ExtDirectMethodType.STORE_MODIFY, group = "store")
	public int destroy(List<EnterpriseFile> enterprises) {
		return enteprEnterpriseFileMapper.deleteByPrimaryKey(enterprises.get(0).getId());
	}
	

}
