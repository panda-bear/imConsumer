package com.zjrc.sxzz.synTask;

import java.text.SimpleDateFormat;
import java.util.Date;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zjrc.sxzz.dao.SynMapper;
import com.zjrc.sxzz.entity.Syn;
import com.zjrc.sxzz.pattern.factory.ImClientProduct;
import com.zjrc.sxzz.synTask.enumType.SynResult;
import com.zjrc.sxzz.synTask.enumType.SynState;
import com.zjrc.sxzz.synTask.enumType.SynType;
import com.zjrc.sxzz.util.ConfigUtil;


public abstract class SynTask {
	
	protected Logger log = LoggerFactory.getLogger(SynTask.class);
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@Autowired
	protected ImClientProduct imClient;
	
	@Autowired
	protected SynMapper synMapper;
	
	/**同步业务类型数据(医院或科室或医生) 
	 * @return
	 */
	protected  abstract String synBusinessData(Syn syn);
	
	/**提供完整同步流程 --模板模式
	 * @param syn
	 * @throws InterruptedException 
	 * @throws NumberFormatException 
	 */
	@SuppressWarnings("static-access")
	@Transactional(isolation=Isolation.READ_UNCOMMITTED)
	public void execute(Syn syn) throws NumberFormatException, InterruptedException {
		if (syn.getSynNums() > 2) {
			return;
		}
		
		decideSynType(syn);
		//控制调用钉钉接口频率
		int waitTime = Integer.valueOf(ConfigUtil.getInstance().getString("sleepTime"));
		log.info("同步线程{}： 等待{}ms,再开始调用钉钉接口",Thread.currentThread().getName() , waitTime);
		Thread.currentThread().sleep(waitTime);
		String res = synBusinessData(syn);
		log.info("同步线程{}：同步业务数据{} ,钉钉响应结果---------------->{}" ,Thread.currentThread().getName(), syn , res);
		JSONObject obj = JSON.parseObject(res);
		if ("0".equals(obj.getString("errcode"))) {
			log.info("同步线程{}：更新同步数据结果为成功" ,Thread.currentThread().getName());
			syn.setSynResult(SynResult.SUCCESS.getResult());
		} else {
			log.info("同步线程{}：更新同步数据结果为失败" ,Thread.currentThread().getName());
			syn.setSynResult(SynResult.FAIL.getResult());
		}
		syn.setSynState(SynState.HAS.getState());
		syn.setSynNums(syn.getSynNums() + 1);
		syn.setSynResponse(res);
		syn.setSynDate(sdf.format(new Date()));
		synMapper.updateByPrimaryKeySelective(syn);
	}
	
	/**以钉钉数据为基准,设置同步类型
	 * @param syn
	 */
	protected abstract void decideSynType(Syn syn);
	
	protected SynType transferStr(String synTypeStr) {
		
		if (synTypeStr.equals(SynType.CREATE.getType())) {
			return SynType.CREATE;
		}
		if (synTypeStr.equals(SynType.UPDATE.getType())) {
			return SynType.UPDATE;
		}
		if (synTypeStr.equals(SynType.DELETE.getType())) {
			return SynType.DELETE;
		}
		throw new RuntimeException("synTypeStr 只能是 1 2 3");
	}
	
	
}

































