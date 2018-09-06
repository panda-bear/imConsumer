package com.zjrc.sxzz;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zjrc.sxzz.dao.SynMapper;
import com.zjrc.sxzz.synTask.client.FillBusinessDataRunnable;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TestSynMapper{
	
	@Autowired
	private SynMapper synMapper;
	
	@Autowired
	private FillBusinessDataRunnable task;
	
	@Test
	public void test() throws InterruptedException {
		Thread t = new Thread(task);
		t.start();
		t.join();
	}
}
