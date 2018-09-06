package com.zjrc.sxzz;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zjrc.sxzz.entity.Syn;
import com.zjrc.sxzz.synTask.ExecuteContext;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TestSynTask extends DingTest {
	
	@Autowired
	private ExecuteContext context;
	
	@Test
	public void testSynHos() throws Exception {
		context.executeSyn(getSyn());
	}
	
	
	private Syn getSyn() {
		Syn syn = new Syn();
		syn.setId(13);
		syn.setBusinessId("057102");
		syn.setBusinessName("杭州市中医院22");
		syn.setBusinessType("1");
		syn.setSynState("0");
		syn.setSynNums(0);
		return syn;
	}
	
}
