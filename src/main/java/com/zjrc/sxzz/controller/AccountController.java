package com.zjrc.sxzz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zjrc.sxzz.ImClientResponse;
import com.zjrc.sxzz.service.AccountService;

@RestController
public class AccountController {
	
	
	@Autowired
	private AccountService accountService;
	
	@GetMapping("/getToken")
	public Object getToken(String code) {
		return accountService.getTokenByCode(code);
	}
	
}
