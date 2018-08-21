package com.zjrc.sxzz.pattern.factory;

import com.zjrc.sxzz.util.ConfigUtil;

public class DingImClientFactory extends ImClientFactory {
	
	private static DingImClientProduct imClient = new DingImClientProduct(ConfigUtil.getInstance().getString("ding_urlPrefix"));
	
	@Override
	public ImClientProduct createImClientProduct() {
		
		return imClient;
	}

}
