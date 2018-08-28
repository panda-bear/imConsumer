package com.zjrc.sxzz.synTask.hospital;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zjrc.sxzz.dao.HospitalMapper;
import com.zjrc.sxzz.entity.Hospital;
import com.zjrc.sxzz.synTask.SynStatus;
import com.zjrc.sxzz.synTask.SynTask;

/**同步创建医院任务
 * @author Administrator
 *
 */
@Component
public class SynCreateHospitalTask extends SynTask implements Runnable{
	
	private Logger log = LoggerFactory.getLogger(SynCreateHospitalTask.class);
	
	@Autowired
	private HospitalMapper hospitalMapper;
	
	@SuppressWarnings("incomplete-switch")
	@Override
	public void run() {
		while(true) {
			List<Hospital> hospitals = hospitalMapper.getWaitSynCreateHospitals();
			log.info("待同步创建医院数量-------->{}" , hospitals.size());
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
					//首次同步创建时,更新 和删除 状态默认为1
					hos.setIsSynUpdated(SynStatus.SUCCESS.getStatus());
					hos.setIsSynDeleated(SynStatus.SUCCESS.getStatus());
					hospitalMapper.updateByPrimaryKeySelective(hos);
					log.info("{} 医院同步创建成功！" , hos.getName());
				} else {//同步失败
					//判断设置对应失败状态
					String failStatus = hos.getIsSynCreated();
					switch(transfer(failStatus)) {
					case WAIT:
							hos.setIsSynCreated(SynStatus.FAIL_ONE.getStatus());
							hospitalMapper.updateByPrimaryKeySelective(hos);
							log.info("{}医院同步创建失败第一次 , 失败原因{}"   , hos.getName() , re.get("errmsg"));
							break;
					case FAIL_ONE:
							hos.setIsSynCreated(SynStatus.FAIL_TWO.getStatus());
							hospitalMapper.updateByPrimaryKeySelective(hos);
							log.info("{}医院同步创建失败第二次 , 失败原因{}"   , hos.getName() , re.get("errmsg"));
							break;
					case FAIL_TWO:
							hos.setIsSynCreated(SynStatus.FAIL_THREE.getStatus());
							hospitalMapper.updateByPrimaryKeySelective(hos);
							log.info("{}医院同步创建失败第三次 , 失败原因{}"   , hos.getName() , re.get("errmsg"));
							break;
					}
				}
				super.sleepInterval();
			}
			super.detectionInterval();
		}
	}
	
	
}
