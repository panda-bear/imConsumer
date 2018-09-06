package com.zjrc.sxzz.util;

import java.util.UUID;

public class UUIDUtil {
	
	
	/**去除"-"
	 * @return
	 */
	public static String getUUID() {
		String id = UUID.randomUUID().toString();
		return id.replaceAll("-", "");
	}
	
}
