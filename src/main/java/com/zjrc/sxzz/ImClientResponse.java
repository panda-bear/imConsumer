package com.zjrc.sxzz;

import com.alibaba.fastjson.JSONObject;

public class ImClientResponse {
	
	private String errcode;
	
	private String errmsg;
	
	private JSONObject object;
	
	public ImClientResponse(String errcode , String errmsg , JSONObject jo) {
		this.errcode = errcode;
		this.errmsg = errmsg;
		this.object = jo;
	}

	public String getErrcode() {
		return errcode;
	}

	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public JSONObject getObject() {
		return object;
	}

	public void setObject(JSONObject object) {
		this.object = object;
	}

	
	
	
}
