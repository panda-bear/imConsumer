package com.zjrc.sxzz.synTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zjrc.sxzz.pattern.factory.ImClientProduct;
import com.zjrc.sxzz.util.ConfigUtil;

/**同步任务父类 ，公共属性，公共行为
 * @author Administrator
 *
 */
@Component
public class SynTask {
	
	@Autowired
	protected ImClientProduct imClient;
	
	
	/**控制任务再次被线程驱动去检测的时间间隔
	 * 
	 */
	@SuppressWarnings("static-access")
	protected void detectionInterval() {
		Long sleepTime = Long.parseLong(ConfigUtil.getInstance().getString("detectionInterval"));
		try {
			Thread.currentThread().sleep(sleepTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
	}
	
	/**控制调用同步接口频率不可超过1500次/分 
	 * 
	 */
	@SuppressWarnings("static-access")
	protected void sleepInterval() {
		//控制调用同步接口频率不可超过1500次/分 
		Long sleepTime = Long.parseLong(ConfigUtil.getInstance().getString("sleepTime"));
		try {
			Thread.currentThread().sleep(sleepTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
	}
	
	/**根据状态自动转换对应枚举类型
	 * @param status
	 * @return
	 */
	protected  SynStatus transfer(String status) {
		if (status.equals(SynStatus.WAIT.getStatus())) {
			return SynStatus.WAIT;
		}
		
		if (status.equals(SynStatus.FAIL_ONE.getStatus())) {
			return SynStatus.FAIL_ONE;
		}
		
		if (status.equals(SynStatus.FAIL_TWO.getStatus())) {
			return SynStatus.FAIL_TWO;
		}
		
		if (status.equals(SynStatus.FAIL_THREE.getStatus())) {
			return SynStatus.FAIL_THREE;
		}
		throw new RuntimeException("内部数据错误!");
	}	
}
