package com.zjrc.sxzz;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zjrc.sxzz.cache.ITokenCache;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EhcaheTokenTest {
	
	@Autowired
	private ITokenCache tokenCache;
	
	@Test
	public void getToken() throws InterruptedException {
		String token = tokenCache.getToken();
		Thread.currentThread().sleep(3000);
		String token2 = tokenCache.getToken();
		Assert.assertEquals(token, token2);
		
		System.out.println(tokenCache.getToken());
		System.out.println(tokenCache.getToken());
		System.out.println(tokenCache.getToken());
		System.out.println(tokenCache.getToken());
		System.out.println(tokenCache.getToken());
	}

}
