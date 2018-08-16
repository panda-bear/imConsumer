package com.zjrc.sxzz.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zjrc.sxzz.service.UserService;

@RestController
public class SampleController {
	
	private Logger log = LoggerFactory.getLogger(SampleController.class);
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/test")
	public Object test(String mobile) {
		/*User user = new User();
		user.setName("zzj");*/
		log.debug("..........debug...........");
		log.info(".............info...........");
		log.warn(".............warn...........");
		log.error("............error...........");
		return userService.getUserByMobile(mobile);
	}
}
