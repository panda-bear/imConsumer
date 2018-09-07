package com.zjrc.sxzz;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zjrc.sxzz.cache.ITokenCache;
import com.zjrc.sxzz.pattern.imClientFactory.ImClientProduct;



@RunWith(SpringRunner.class)
@SpringBootTest
public class DingTest {
	
	protected Logger log = LoggerFactory.getLogger(DingTest.class);
	
	@Autowired
	protected ITokenCache tokenCache;
	
	@Autowired
	protected ImClientProduct imclient;
	
	protected String token;
	
	@Before
	public void init() {
		token = tokenCache.getToken();
	}
	
}
