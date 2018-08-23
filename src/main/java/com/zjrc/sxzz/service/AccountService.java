package com.zjrc.sxzz.service;

import com.zjrc.sxzz.ImClientResponse;

public interface AccountService {
	
	/**获取app服务登录的token
	 * @param code
	 * @return
	 */
	ImClientResponse getTokenByCode(String code);
}
