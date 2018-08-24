package com.zjrc.sxzz.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.zjrc.sxzz.ImClientResponse;
import com.zjrc.sxzz.pattern.factory.ImClientProduct;
import com.zjrc.sxzz.util.JsonUtil;

@RestController
public class ImController {
	
	private static Logger log = LoggerFactory.getLogger(ImController.class);
	
	@Autowired
	private ImClientProduct imClient;
	
	/**根据code响应userId
	 * @param code
	 * @return
	 */
	@GetMapping("/getUserId")
	public Object getUserId(String code) {
		String res = imClient.getUserIdByCode(code);
		log.info("钉钉响应------------>{}" , res);
		String userId = JsonUtil.getStrValueByKeyForDing(res, "userid");
		
		JSONObject object = new JSONObject();
		object.put("userId", userId);
		return new ImClientResponse("0" , "" , object );
	}
	
}
