package com.zjrc.sxzz.synTask.client;

import java.util.concurrent.ConcurrentLinkedQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.zjrc.sxzz.entity.Syn;
import com.zjrc.sxzz.synTask.ExecuteContext;

/**负责同步业务数据的任务
 * @author Administrator
 *
 */
public class SynBusinessDataRunnable implements Runnable {
	
	
	private Logger log = LoggerFactory.getLogger(Runnable.class);
	
	private ConcurrentLinkedQueue<Syn> queue;
	
	@Autowired
	private ExecuteContext context;
	
	public SynBusinessDataRunnable(ConcurrentLinkedQueue<Syn> queue) {
		this.queue = queue;
	}
	
	@Override
	public void run() {
		while(true) {
			if (queue.size() > 0) {
				Syn syn = queue.poll();
				try {
					if (syn != null) {
						log.info("同步线程{} ,开始同步！当前队列实际待同步量{}" ,Thread.currentThread().getName() , queue.size());
						context.executeSyn(syn);
						log.info("同步线程{} ,完成一次同步！当前队列实际待同步量{}" ,Thread.currentThread().getName() , queue.size());
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
}
