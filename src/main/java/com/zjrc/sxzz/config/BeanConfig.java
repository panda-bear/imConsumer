package com.zjrc.sxzz.config;

import java.util.concurrent.ConcurrentLinkedQueue;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.zjrc.sxzz.entity.Syn;
import com.zjrc.sxzz.pattern.factory.ImClientFactory;
import com.zjrc.sxzz.pattern.factory.ImClientProduct;
import com.zjrc.sxzz.synTask.client.FillBusinessDataRunnable;
import com.zjrc.sxzz.synTask.client.SynBusinessDataRunnable;
import com.zjrc.sxzz.util.ConfigUtil;

@Configuration
public class BeanConfig {
	
	/**
	 * 放置待同步数据的队列
	 */
	private ConcurrentLinkedQueue<Syn> queue = new ConcurrentLinkedQueue<>();
	
	@Bean
	public ImClientProduct imClientProduct() throws Exception {
		ImClientFactory factory = (ImClientFactory)Class.forName(ConfigUtil.getInstance().getString("concreteFactory")).newInstance();
		return factory.createImClientProduct(); 
	}
	@Bean
	public FillBusinessDataRunnable fillBusinessDataRunnable() {
		FillBusinessDataRunnable task = new FillBusinessDataRunnable(queue);
		return task;
	}
	@Bean
	public SynBusinessDataRunnable synBusinessDataRunnable() {
		SynBusinessDataRunnable task = new SynBusinessDataRunnable(queue);
		return task;
	}
}
