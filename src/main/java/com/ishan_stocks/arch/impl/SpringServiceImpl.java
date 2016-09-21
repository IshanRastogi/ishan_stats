package com.ishan_stocks.arch.impl;

import org.apache.log4j.Logger;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ishan_stocks.arch.SpringService;

c class SpringServiceImpl implements SpringService {
	
	/**
	 * Logger service for the class.
	 */
	private Logger logger = Logger.getLogger(SpringServiceImpl.class);

	/**
	 * Spring context files pattern defined for the Super Simple Stocks application.  
	 */
	private static final String SPRING_CONTEXT_FILE_NAME = "classpath*:*stocks-*-context.xml";

	/**
	 * Spring context object.
	 */
	private AbstractApplicationContext springContext = null;

	/**
	 * Constructor of the class. The main purpose of the constructor is to load the Spring context for the Super Simple Stocks applicarion. 
	 */
	private SpringServiceImpl(){
		logger.info("Loading Spring Context for Super Simple Stocks.");
		springContext = new ClassPathXmlApplicationContext(SPRING_CONTEXT_FILE_NAME);
		springContext.registerShutdownHook();
		logger.info("Spring Context created !!!! Successfully !!!!");
	}
	
	
	private static class SpringServiceHolder{
		private static final SpringService INSTANCE = new SpringServiceImpl();
	}

	
	public static SpringService getInstance(){
		return SpringServiceHolder.INSTANCE;
	}	
	
	
	public <T> T getBean(String beanName, Class<T> objectClass) {
		return springContext.getBean(beanName, objectClass);
	}

	
	public <T> T getBean(Class<T> objectClass) {
		return springContext.getBean(objectClass);
	}

}
