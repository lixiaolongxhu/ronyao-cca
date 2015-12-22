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
import com.ronyao.cca.db.dao.EnterpriseFileMapper;
import com.ronyao.cca.db.model.EnterpriseFile;
import com.ronyao.cca.db.model.EnterpriseFileExample;
import com.ronyao.cca.tool.DateUtil;
import com.ronyao.cca.tool.FileUtil;

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
		//获得前段传回参数的容器
		Map<String, Object> params = request.getParams();	
		//获得该Map的key集合
//		Set<String> keySet = params.keySet();
		
		Object  enterpriseidObj=params.get("enterpriseid");
		Integer enterpriseid=0;
		if(enterpriseidObj!=null){
			enterpriseid=Integer.parseInt(enterpriseidObj.toString());
		}
		eExample.createCriteria().andEnterpriseidEqualTo(enterpriseid);
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
	public int destroy(List<EnterpriseFile> enterprises,HttpServletRequest request) {
		String saveFilePath = request.getSession().getServletContext()
				.getRealPath("/")
				+ "/res/file/";
		EnterpriseFile  enterFile=  enteprEnterpriseFileMapper.selectByPrimaryKey(enterprises.get(0).getId());
		
		saveFilePath=saveFilePath+enterFile.getPath();
		FileUtil.deleteFile(saveFilePath);
		return enteprEnterpriseFileMapper.deleteByPrimaryKey(enterprises.get(0).getId());
	}
	

//	private boolean DeleteFolder(String sPath) {  
//	  Boolean  flag = false;  
//	   File file = new File(sPath);  
//	    // 判断目录或文件是否存在  
//	    if (!file.exists()) {  // 不存在返回 false  
//	        return flag;  
//	    } else {  
//	        // 判断是否为文件  
//	        if (file.isFile()) {  // 为文件时调用删除文件方法  
//	            return deleteFile(sPath);  
//	        } else {  // 为目录时调用删除目录方法  
//	            return deleteDirectory(sPath);  
//	        }  
//	    }  
//	}  
	
  
	
//	/** 
//	 * 删除目录（文件夹）以及目录下的文件 
//	 * @param   sPath 被删除目录的文件路径 
//	 * @return  目录删除成功返回true，否则返回false 
//	 */  
//	public boolean deleteDirectory(String sPath) {  
//	    //如果sPath不以文件分隔符结尾，自动添加文件分隔符  
//	    if (!sPath.endsWith(File.separator)) {  
//	        sPath = sPath + File.separator;  
//	    }  
//	    File dirFile = new File(sPath);  
//	    //如果dir对应的文件不存在，或者不是一个目录，则退出  
//	    if (!dirFile.exists() || !dirFile.isDirectory()) {  
//	        return false;  
//	    }  
//	    flag = true;  
//	    //删除文件夹下的所有文件(包括子目录)  
//	    File[] files = dirFile.listFiles();  
//	    for (int i = 0; i < files.length; i++) {  
//	        //删除子文件  
//	        if (files[i].isFile()) {  
//	            flag = deleteFile(files[i].getAbsolutePath());  
//	            if (!flag) break;  
//	        } //删除子目录  
//	        else {  
//	            flag = deleteDirectory(files[i].getAbsolutePath());  
//	            if (!flag) break;  
//	        }  
//	    }  
//	    if (!flag) return false;  
//	    //删除当前目录  
//	    if (dirFile.delete()) {  
//	        return true;  
//	    } else {  
//	        return false;  
//	    }  
//	}
//	
}
