package com.zjrc.sxzz;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zjrc.sxzz.synTask.SynHospitalTask;

public class DeptTest extends DingTest {
	
	@Autowired
	private SynHospitalTask synHosTask;
	
	/**测试医院同步
	 * @throws InterruptedException 
	 * 
	 */
	@Test
	public void testSynHospital() throws InterruptedException {
		Thread t = new Thread(synHosTask);
		t.start();
		t.join();
		
	}
	
}
