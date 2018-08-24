package com.zjrc.sxzz.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class JsonStrUtil {
	
	
	public static String getStrValueByKeyForDing(String jsonStr , String key) {
		JSONObject o = JSON.parseObject(jsonStr);
		String errcode = o.getString("errcode");
		if (!"0".equals(errcode)) {
			throw new RuntimeException(o.getString("errmsg"));
		}
		return o.getString(key);
	}
	
}
