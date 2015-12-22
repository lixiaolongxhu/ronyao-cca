package com.ronyao.cca.ui.extDirect;


import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ch.ralscha.extdirectspring.annotation.ExtDirectMethod;
import ch.ralscha.extdirectspring.annotation.ExtDirectMethodType;
import ch.ralscha.extdirectspring.bean.ExtDirectStoreReadRequest;
import ch.ralscha.extdirectspring.bean.ExtDirectStoreReadResult;
import com.ronyao.cca.db.dao.EnterprisePerFileMapper;
import com.ronyao.cca.db.model.EnterprisePerFile;
import com.ronyao.cca.db.model.EnterprisePerFileExample;
import com.ronyao.cca.tool.DateUtil;
import com.ronyao.cca.tool.FileUtil;

/**企业持证人员证件信息管理
 * 
 * @author user
 *
 */
@Service
public class ActionEnterpPerFile {
	@Autowired
	private EnterprisePerFileMapper  enteprEnterprisePerFileMapper;

	// 列表
	@ExtDirectMethod(value = ExtDirectMethodType.STORE_READ, group = "store")
	public ExtDirectStoreReadResult<EnterprisePerFile> read(
			ExtDirectStoreReadRequest request) {
		EnterprisePerFileExample eExample = new EnterprisePerFileExample();
		//获得前段传回参数的容器
		Map<String, Object> params = request.getParams();	
		//获得该Map的key集合
//		Set<String> keySet = params.keySet();
		
		Object  enterpriseperidObj=params.get("enterpriseperid");
		Integer enterpriseperid=0;
		if(enterpriseperidObj!=null){
			enterpriseperid=Integer.parseInt(enterpriseperidObj.toString());
		}
		eExample.createCriteria().andEnterpriseperidEqualTo(enterpriseperid);
		return new ExtDirectStoreReadResult<EnterprisePerFile>(enteprEnterprisePerFileMapper.selectByExample(eExample));
	}

	// 插入
	@ExtDirectMethod(value = ExtDirectMethodType.STORE_MODIFY, group = "store")
	public ExtDirectStoreReadResult<EnterprisePerFile> create(List<EnterprisePerFile> enterprise) {
		enterprise.get(0).setCreatetime(DateUtil.dateToString(new Date(), DateUtil.DATAFORMAT0));
		enteprEnterprisePerFileMapper.insert(enterprise.get(0));
		return new ExtDirectStoreReadResult<EnterprisePerFile>(enterprise.get(0));
	}

	// 修改
	@ExtDirectMethod(value = ExtDirectMethodType.STORE_MODIFY, group = "store")
	public int update(List<EnterprisePerFile> enterprise) {
		enterprise.get(0).setUpdatetime(DateUtil.dateToString(new Date(), DateUtil.DATAFORMAT0));
		return enteprEnterprisePerFileMapper.updateByPrimaryKey(enterprise.get(0));
	}

	// 删除
	@ExtDirectMethod(value = ExtDirectMethodType.STORE_MODIFY, group = "store")
	public int destroy(List<EnterprisePerFile> enterprises,HttpServletRequest request) {
		String saveFilePath = request.getSession().getServletContext()
				.getRealPath("/")
				+ "/res/file/";
		EnterprisePerFile  enterFile=  enteprEnterprisePerFileMapper.selectByPrimaryKey(enterprises.get(0).getId());
		
		saveFilePath=saveFilePath+enterFile.getPath();
		FileUtil.deleteFile(saveFilePath);
		return enteprEnterprisePerFileMapper.deleteByPrimaryKey(enterprises.get(0).getId());
	}
	


}
