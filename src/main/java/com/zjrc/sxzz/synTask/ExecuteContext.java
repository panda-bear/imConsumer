package com.zjrc.sxzz.synTask;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.zjrc.sxzz.entity.Syn;
import com.zjrc.sxzz.synTask.enumType.BusinessType;

@Component
public class ExecuteContext implements ApplicationContextAware{
	
	private Logger log = LoggerFactory.getLogger(ExecuteContext.class);
	
	private SynTask synTask;
	
	private ApplicationContext context;
	
	
	public  void executeSyn(Syn syn) throws Exception {
		switch(transferEnum(syn.getBusinessType())) {
		case HOSPITAL:
			log.info("同步线程{}:开始同步医院！" , Thread.currentThread().getName());
			synTask = (SynHospitalTask)context.getBean("synHospitalTask");
			break;
		case DEPT:
			log.info("同步线程{}:开始同步科室！" , Thread.currentThread().getName());
			synTask = (SynDeptTask)context.getBean("synDeptTask");
			break;
		case DOCTOR:
			log.info("同步线程{}:开始同步用户！" , Thread.currentThread().getName());
			synTask = (SynAccountTask)context.getBean("synAccountTask");
			break;
		}
		synTask.execute(syn);
	}
	
	private BusinessType transferEnum(String busType) {
		if (busType.equals(BusinessType.HOSPITAL.getType())) {
			return BusinessType.HOSPITAL;
		}
		if (busType.equals(BusinessType.DEPT.getType())) {
			return BusinessType.DEPT;
		}
		if (busType.equals(BusinessType.DOCTOR.getType())) {
			return BusinessType.DOCTOR;
		}
		throw new RuntimeException("businessType 业务类型错误,请检查------------>"+ busType)  ;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.context = applicationContext;
	}
}
