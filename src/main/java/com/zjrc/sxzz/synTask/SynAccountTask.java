package com.zjrc.sxzz.synTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zjrc.sxzz.dao.AccountMapper;
import com.zjrc.sxzz.dao.DeptMapper;
import com.zjrc.sxzz.entity.Account;
import com.zjrc.sxzz.entity.Syn;
import com.zjrc.sxzz.synTask.enumType.SynType;

@Component
public class SynAccountTask extends SynTask {
	
	@Autowired
	private AccountMapper acountMapper;
	
	@Autowired
	private DeptMapper deptMapper;
	
	@SuppressWarnings("incomplete-switch")
	@Override
	protected String synBusinessData(Syn syn) {
		Account account = acountMapper.selectByPrimaryKey(Integer.valueOf(syn.getBusinessId()));
		JSONObject obj = new JSONObject();
		switch(transferStr(syn.getSynType())) {
		case CREATE:
			log.info("同步线程{}：开始进行同步创建用户{}{}----------" ,Thread.currentThread().getName(), syn.getBusinessId() , syn.getBusinessName());
			obj.put("userid", syn.getBusinessId());
			obj.put("name", account.getName());
			obj.put("department", deptMapper.getDeptIdDingsByAccountId(Integer.valueOf(syn.getBusinessId())));
			obj.put("mobile", account.getMobile());
			return imClient.createAccount(obj.toJSONString());
		case UPDATE:
			log.info("同步线程{}：开始进行同步更新用户{}{}----------" ,Thread.currentThread().getName(), syn.getBusinessId() , syn.getBusinessName());
			obj.put("userid", syn.getBusinessId());
			obj.put("name", account.getName());
			obj.put("department", deptMapper.getDeptIdDingsByAccountId(Integer.valueOf(syn.getBusinessId())));
			obj.put("mobile", account.getMobile());
			return imClient.updateAccount(obj.toJSONString());
		case DELETE:
			log.info("同步线程{}：开始进行同步删除用户{}{}----------" ,Thread.currentThread().getName(), syn.getBusinessId() , syn.getBusinessName());
			return imClient.deleteAccount(syn.getBusinessId());
		}
		throw new RuntimeException("同步用户时,同步类型错误异常！");
	}

	@Override
	protected void decideSynType(Syn syn) {
		String res = imClient.selectAccountById(syn.getBusinessId());
		JSONObject obj =  JSON.parseObject(res);
		if ("0".equals(obj.getString("errcode"))) {
			Account account = acountMapper.selectByPrimaryKey(Integer.valueOf(syn.getBusinessId()));
			if ("0".equals(account.getStatus())) {
				//同步更新
				syn.setSynType(SynType.UPDATE.getType());
				return;
			} else {
				//同步删除
				syn.setSynType(SynType.DELETE.getType());
				return;
			}
		} else {
			//同步创建
			syn.setSynType(SynType.CREATE.getType());
			return;
		}

	}
	

}
