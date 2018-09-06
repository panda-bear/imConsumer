package com.zjrc.sxzz.synTask.client;

import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.zjrc.sxzz.dao.SynMapper;
import com.zjrc.sxzz.entity.Syn;
import com.zjrc.sxzz.util.ConfigUtil;

/**负责往队列中添加待同步数据syn
 * @author Administrator
 *
 */
public class FillBusinessDataRunnable implements Runnable {
	
	private Logger log = LoggerFactory.getLogger(Runnable.class);
	
	private ConcurrentLinkedQueue<Syn> queue;
	
	@Autowired
	private SynMapper synMapper;
	
	public FillBusinessDataRunnable(ConcurrentLinkedQueue<Syn> queue) {
		this.queue = queue;
	}
	
	@Override
	public void run() {
		int remain = Integer.valueOf(ConfigUtil.getInstance().getString("remain"));
		int delNums = Integer.valueOf(ConfigUtil.getInstance().getString("delNums"));
		while(true) {
			if (queue.size() < remain) {
				List<Syn> syns = synMapper.getWaitBusinessDatas(delNums);
				queue.addAll(syns);
				log.info("填充线程{}：队列下限阈值{}---队列实际剩余量{} , 批量获取同步量上限阈值{}-----实际获取同步量{}" ,Thread.currentThread().getName() ,remain , queue.size() , delNums , syns.size() );
			}
			try {
				int waitTime = Integer.valueOf(ConfigUtil.getInstance().getString("waitTime"));
				log.info("填充线程{}：等待同步线程同步........{}毫秒后开始继续填充" ,Thread.currentThread().getName(), waitTime);
				Thread.sleep(waitTime);//等待15s
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}








