package com.zjrc.sxzz;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zjrc.sxzz.synTask.hospital.SynCreateHospitalTask;
import com.zjrc.sxzz.synTask.hospital.SynDeleteHospitalTask;
import com.zjrc.sxzz.synTask.hospital.SynUpdateHospitalTask;

public class DeptTest extends DingTest {
	
	@Autowired
	private SynCreateHospitalTask synHosTask;
	
	@Autowired
	private SynUpdateHospitalTask updateHosTask;
	
	@Autowired
	private SynDeleteHospitalTask deleteHosTask;
	
	/**测试医院同步创建
	 * @throws InterruptedException 
	 * 
	 */
	@Test
	public void testSynHospital() throws InterruptedException {
		Thread t = new Thread(synHosTask);
		t.start();
		t.join();
		
	}
	
	/**测试医院同步更新
	 * @throws InterruptedException 
	 * 
	 */
	@Test
	public void testSynUpdateHospital() throws InterruptedException {
		Thread t = new Thread(updateHosTask);
		t.start();
		t.join();
		
	}
	
	/**测试医院同步删除
	 * @throws InterruptedException 
	 * 
	 */
	@Test
	public void testSynDeleteHospital() throws InterruptedException {
		Thread t = new Thread(deleteHosTask);
		t.start();
		t.join();
		
	}	
	
	/**测试医院同步
	 * @throws InterruptedException 
	 * 
	 */
	@Test
	public void mergeTest() throws InterruptedException {
		Thread t1 = new Thread(synHosTask);
		t1.start();
		
		
		Thread t2 = new Thread(updateHosTask);
		t2.start();
		
		Thread t3 = new Thread(deleteHosTask);
		t3.start();
		
		t1.join();
		
	}
	
	
	
}
