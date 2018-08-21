package com.zjrc.sxzz.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


public class ConfigUtil {

	private static Logger log = LoggerFactory.getLogger(ConfigUtil.class);

	private static ConfigUtil configUtil = new ConfigUtil();
	private Properties properties = new Properties();
	private static final String CONF_FILE_PATH = "/imClient.properties";

	public static ConfigUtil getInstance() {
		return configUtil;
	}

	private ConfigUtil() {
		init();
	}

	private void init() {
		try {
			//this.properties.load(super.getClass().getResourceAsStream(CONF_FILE_PATH));
			Resource resource = new ClassPathResource(CONF_FILE_PATH);
			InputStream is = resource.getInputStream();
			BufferedReader bf = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			properties.load(bf);
		} catch (IOException e) {
			log.error("配置文件加载错误[" + CONF_FILE_PATH + "]", e);
		}
	}

	public String getString(String key) {
		return this.properties.getProperty(key);
	}
}
