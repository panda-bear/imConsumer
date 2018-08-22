package com.zjrc.sxzz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zjrc.sxzz.pattern.factory.ImClientFactory;
import com.zjrc.sxzz.pattern.factory.ImClientProduct;
import com.zjrc.sxzz.util.ConfigUtil;

@Configuration
public class BeanConfig {
	
	@Bean
	public ImClientProduct imClientProduct() throws Exception {
		ImClientFactory factory = (ImClientFactory)Class.forName(ConfigUtil.getInstance().getString("concreteFactory")).newInstance();
		return factory.createImClientProduct(); 
	}
}
