package com.zjrc.sxzz.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zjrc.sxzz.ImClientResponse;
import com.zjrc.sxzz.dao.AccountMapper;
import com.zjrc.sxzz.entity.Account;
import com.zjrc.sxzz.pattern.factory.ImClientProduct;
import com.zjrc.sxzz.service.AccountService;
import com.zjrc.sxzz.util.ConfigUtil;
import com.zjrc.sxzz.util.HttpClientUtil;
import com.zjrc.sxzz.util.JsonStrUtil;

@Service
public class AccountServiceImpl implements AccountService {
	
	private Logger log = LoggerFactory.getLogger(AccountServiceImpl.class);
	
	@Autowired
	private AccountMapper accountMapper;
	
	@Autowired
	private ImClientProduct imClient;
	
	@Override
	public ImClientResponse getTokenByCode(String code) {
		String res = imClient.getUserIdByCode(code);
		log.info("钉钉响应------------>{}" , res);
		String userId = JsonStrUtil.getStrValueByKeyForDing(res, "userid");
		log.info("根据code:{}  ,从钉钉获取到userId: {}" , code , userId);
		Account account = accountMapper.selectByPrimaryKey(Integer.valueOf(userId));
		
		//登录App服务获取token
		JSONObject o = new JSONObject();
		o.put("account", account.getMobile());
		o.put("password", account.getPassword());
		res = HttpClientUtil.doPost(ConfigUtil.getInstance().getString("appLogin"), o.toJSONString());
		log.info("从app服务获取到当前用户登录的信息: {}" , res);
		
		return new ImClientResponse("0" , "" , JSON.parseObject(res));
	}

}











































