package com.zjrc.sxzz.synTask.client;



import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class SynBusinessDataClient {
	
	@Autowired
	private FillBusinessDataRunnable fillTask;
	
	@Autowired
	private SynBusinessDataRunnable synTask;
	
	@PostConstruct
	public void runSyn() throws InterruptedException {
		
		/*new Thread(fillTask).start();  
		new Thread(synTask).start();
		new Thread(synTask).start();
		new Thread(synTask).start();*/
		//new Thread(synTask).start();
		//new Thread(synTask).start();
	}
	
	
	
}
