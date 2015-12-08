package com.ronyao.cca.ui.extDirect;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

import ch.ralscha.extdirectspring.annotation.ExtDirectMethod;
import ch.ralscha.extdirectspring.annotation.ExtDirectMethodType;
import ch.ralscha.extdirectspring.bean.ExtDirectFormPostResult;
import ch.ralscha.extdirectspring.bean.ExtDirectStoreReadRequest;
import ch.ralscha.extdirectspring.bean.ExtDirectStoreReadResult;

import com.ronyao.cca.db.dao.UserMapper;
import com.ronyao.cca.db.model.User;
import com.ronyao.cca.db.model.UserExample;

@Service
public class ActionUser {
	@Autowired
	UserMapper userMapper;

	// 列表
	@ExtDirectMethod(value = ExtDirectMethodType.STORE_READ, group = "store")
	public ExtDirectStoreReadResult<User> read(
			ExtDirectStoreReadRequest request) {
		UserExample uExample = new UserExample();
		uExample.createCriteria().andIdGreaterThan(0);
		return new ExtDirectStoreReadResult<User>(
				
				userMapper.selectByExample(uExample));
	}

	// 插入
	@ExtDirectMethod(value = ExtDirectMethodType.STORE_MODIFY, group = "store")
	public ExtDirectStoreReadResult<User> create(List<User> users) {
		userMapper.insert(users.get(0));
		return new ExtDirectStoreReadResult<User>(users.get(0));
	}

	// 修改
	@ExtDirectMethod(value = ExtDirectMethodType.STORE_MODIFY, group = "store")
	public int update(List<User> users) {
		return userMapper.updateByPrimaryKey(users.get(0));
	}

	// 删除
	@ExtDirectMethod(value = ExtDirectMethodType.STORE_MODIFY, group = "store")
	public int destroy(List<User> users) {
		return userMapper.deleteByPrimaryKey(users.get(0).getId());
	}
	
	//修改密码
	@ExtDirectMethod(value = ExtDirectMethodType.FORM_POST, group = "form")
	public ExtDirectFormPostResult updatePwd(@Validated User user, BindingResult result) {
		User new_user = userMapper.selectByPrimaryKey(user.getId());
		new_user.setPassword(user.getPassword());
		int res = userMapper.updateByPrimaryKey(new_user);
		if(res > 0) {
			return new ExtDirectFormPostResult(true);
		}
        return new ExtDirectFormPostResult(false);
    }
}
