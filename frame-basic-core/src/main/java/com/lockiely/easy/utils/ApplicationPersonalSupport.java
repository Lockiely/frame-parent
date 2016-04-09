package com.lockiely.easy.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ApplicationPersonalSupport implements ApplicationContextAware{

	private static ApplicationContext context;
	
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		context = applicationContext;
	}
	
	public static Object getBean(String beanName) {
		return context.getBean(beanName);
	}

}
