package com.ronyao.cca.ui.extDirect;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ch.ralscha.extdirectspring.annotation.ExtDirectMethod;
import ch.ralscha.extdirectspring.annotation.ExtDirectMethodType;
import ch.ralscha.extdirectspring.bean.ExtDirectStoreReadRequest;
import ch.ralscha.extdirectspring.bean.ExtDirectStoreReadResult;

import com.ronyao.cca.constant.ConstBehavior;
import com.ronyao.cca.db.dao.BehaviorMapper;
import com.ronyao.cca.db.model.Behavior;
import com.ronyao.cca.db.model.BehaviorExample;
import com.ronyao.cca.tool.DateUtil;


/**施工企业不良行为
 * 
 * @author user
 *
 */
@Service
public class ActionBehavior {
	
	
	private static final  Logger  LOG=LoggerFactory.getLogger(ActionBehavior.class);
	
	@Autowired
	private BehaviorMapper behaviorMapper;
	
	
	private List<Behavior>  behaviorList;
	
	/**计算不良行为修正系统,公式: 不良行为修正系数=(不良行为公式常数5-(严重不良行为数+一般不良行为/3))/不良行为公式常数5
	 * 
	 * @param behavior
	 */
	private  void  correction(Behavior  behavior){
		Byte seriousbadnum=behavior.getSeriousbadnum();
		if(behavior.getGeneralbadnum()>=ConstBehavior.GENERAL_TO_BAD){
			seriousbadnum= (byte) (seriousbadnum+behavior.getGeneralbadnum()/ConstBehavior.GENERAL_TO_BAD);
		}
		float coefficient=(ConstBehavior.CONST-seriousbadnum)/ConstBehavior.CONST;
		behavior.setCorrection(new BigDecimal(coefficient) );
	}
	
	public List<Behavior>  getBehaviorList(){
		if(behaviorList==null){
			BehaviorExample eExample = new BehaviorExample();
			behaviorList=behaviorMapper.selectByExample(eExample);
		}
		return behaviorList;
	}
	
	
	// 列表
	@ExtDirectMethod(value = ExtDirectMethodType.STORE_READ, group = "store")
	public ExtDirectStoreReadResult<Behavior> read(
			ExtDirectStoreReadRequest request) {
		BehaviorExample eExample = new BehaviorExample();
		behaviorList=behaviorMapper.selectByExample(eExample);
		return new ExtDirectStoreReadResult<Behavior>(behaviorList);
	}

	// 插入
	@ExtDirectMethod(value = ExtDirectMethodType.STORE_MODIFY, group = "store")
	public ExtDirectStoreReadResult<Behavior> create(List<Behavior> enterprisePerStaList) {
		Behavior  ep = enterprisePerStaList.get(0);
		ep.setCreatetime(DateUtil.dateToString(new Date(), DateUtil.DATAFORMAT0));
		//计算修改系数
		correction(ep);
		try{
			behaviorMapper.insert(ep);	
		}catch (Exception e){
			LOG.warn("施工企业装备添加: 不允许添加重复的(同一企业),添加失败!");
		}
		
		return new ExtDirectStoreReadResult<Behavior>(ep);
		
	}

	// 修改
	@ExtDirectMethod(value = ExtDirectMethodType.STORE_MODIFY, group = "store")
	public int update(List<Behavior> enterprisePerStaList) {
		
		Behavior  ep = enterprisePerStaList.get(0);
		ep.setUpdatetime(DateUtil.dateToString(new Date(), DateUtil.DATAFORMAT0));
		//计算修改系数
		correction(ep);
		try{
			return behaviorMapper.updateByPrimaryKey(ep);
		}catch (Exception e){
			LOG.warn("施工企业装备修改: 不允许修改为已有的(同一企业),修改失败!");
			return 0;
		}
	}


	// 删除
	@ExtDirectMethod(value = ExtDirectMethodType.STORE_MODIFY, group = "store")
	public int destroy(List<Behavior> enterprisesAptitude) {
		return behaviorMapper.deleteByPrimaryKey(enterprisesAptitude.get(0).getId());
	}
	

}
