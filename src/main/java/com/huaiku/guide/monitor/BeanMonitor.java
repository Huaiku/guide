package com.huaiku.guide.monitor;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class BeanMonitor implements ApplicationContextAware {
	
	private static final Logger logger = LoggerFactory.getLogger(BeanMonitor.class);
	private static ApplicationContext context = null;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		logger.info("注入SpringContext...");
		BeanMonitor.context = applicationContext;
	}
	
	/**
	 * i. list all registered bean
	 */
	public void listAllBeans() {
		logger.info("打印所有已经注册得bean.....");
		Arrays.asList(context.getBeanDefinitionNames()).forEach(logger::info);
	}
}
