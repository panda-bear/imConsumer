package com.zjrc.sxzz.synTask;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zjrc.sxzz.dao.HospitalMapper;
import com.zjrc.sxzz.entity.Hospital;
import com.zjrc.sxzz.pattern.factory.ImClientProduct;
import com.zjrc.sxzz.util.ConfigUtil;

/**同步医院任务
 * @author Administrator
 *
 */
@Component
public class SynHospitalTask implements Runnable {
	
	private Logger log = LoggerFactory.getLogger(SynHospitalTask.class);
	
	@Autowired
	private HospitalMapper hospitalMapper;
	
	@Autowired
	private ImClientProduct imClient;
	
	@SuppressWarnings({ "incomplete-switch", "static-access" })
	@Override
	public void run() {
		while(true) {
			//获取待同步的医院集(未同步 和 同步失败且次数小于3的医院)
			List<Hospital> hospitals = hospitalMapper.getWaitSynHospitals();
			log.info("待同步医院数量-------->{}" , hospitals.size());
			//遍历同步，并更新状态 
			for(Hospital hos : hospitals) {
				JSONObject obj = new JSONObject();
				obj.put("name", hos.getName());
				obj.put("parentid", "1");
				obj.put("createDeptGroup", true);
				String res = imClient.createDept(obj.toJSONString());
				log.info("钉钉响应-------{}" , res);
				JSONObject re = JSON.parseObject(res);
				if ("0".equals(re.getString("errcode"))) {//同步成功
					hos.setHospitalIdDing(re.getString("id"));
					hos.setIsSynCreated(SynStatus.SUCCESS.getStatus());
					hospitalMapper.updateByPrimaryKeySelective(hos);
					log.info("{} 医院同步成功！" , hos.getName());
				} else {//同步失败
					//判断设置对应失败状态
					String failStatus = hos.getIsSynCreated();
					switch(transfer(failStatus)) {
					case WAIT:
							hos.setIsSynCreated(SynStatus.FAIL_ONE.getStatus());
							hospitalMapper.updateByPrimaryKeySelective(hos);
							log.info("{}医院同步失败第一次 , 失败原因{}"   , hos.getName() , re.get("errmsg"));
							break;
					case FAIL_ONE:
							hos.setIsSynCreated(SynStatus.FAIL_TWO.getStatus());
							hospitalMapper.updateByPrimaryKeySelective(hos);
							log.info("{}医院同步失败第二次 , 失败原因{}"   , hos.getName() , re.get("errmsg"));
							break;
					case FAIL_TWO:
							hos.setIsSynCreated(SynStatus.FAIL_THREE.getStatus());
							hospitalMapper.updateByPrimaryKeySelective(hos);
							log.info("{}医院同步失败第三次 , 失败原因{}"   , hos.getName() , re.get("errmsg"));
							break;
					}
				}
				//控制调用同步接口频率不可超过1500次/分 
				Long sleepTime = Long.parseLong(ConfigUtil.getInstance().getString("sleepTime"));
				try {
					Thread.currentThread().sleep(sleepTime);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			//定时检测间隔
			Long sleepTime = Long.parseLong(ConfigUtil.getInstance().getString("detectionInterval"));
			try {
				Thread.currentThread().sleep(sleepTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private SynStatus transfer(String status) {
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
