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

/**同步删除医院任务
 * @author Administrator
 *
 */
@Component
public class SynDeleteHospitalTask extends SynTask implements Runnable{
	
	private Logger log = LoggerFactory.getLogger(SynDeleteHospitalTask.class);
	
	@Autowired
	private HospitalMapper hospitalMapper;
	
	@SuppressWarnings("incomplete-switch")
	@Override
	public void run() {
		while(true) {
			List<Hospital> hospitals = hospitalMapper.getWaitSynDeleteHospitals();
			log.info("待同步删除医院数量-------->{}" , hospitals.size());
			//遍历同步，并更新状态 
			for(Hospital hos : hospitals) {
				String res = imClient.deleteDept(hos.getHospitalIdDing());
				log.info("钉钉响应-------{}" , res);
				JSONObject re = JSON.parseObject(res);
				if ("0".equals(re.getString("errcode"))) {//同步成功
					hos.setIsSynDeleated(SynStatus.SUCCESS.getStatus());
					hospitalMapper.updateByPrimaryKeySelective(hos);
					log.info("{} 医院同步删除成功！" , hos.getName());
				} else {//同步失败
					//判断设置对应失败状态
					String failStatus = hos.getIsSynDeleated();
					switch(transfer(failStatus)) {
					case WAIT:
							hos.setIsSynDeleated(SynStatus.FAIL_ONE.getStatus());
							hospitalMapper.updateByPrimaryKeySelective(hos);
							log.info("{}医院同步删除失败第一次 , 失败原因{}"   , hos.getName() , re.get("errmsg"));
							break;
					case FAIL_ONE:
							hos.setIsSynDeleated(SynStatus.FAIL_TWO.getStatus());
							hospitalMapper.updateByPrimaryKeySelective(hos);
							log.info("{}医院同步删除失败第二次 , 失败原因{}"   , hos.getName() , re.get("errmsg"));
							break;
					case FAIL_TWO:
							hos.setIsSynDeleated(SynStatus.FAIL_THREE.getStatus());
							hospitalMapper.updateByPrimaryKeySelective(hos);
							log.info("{}医院同步删除失败第三次 , 失败原因{}"   , hos.getName() , re.get("errmsg"));
							break;
					}
				}
				super.sleepInterval();
			}
			super.detectionInterval();
		}
	}
	
	
}
