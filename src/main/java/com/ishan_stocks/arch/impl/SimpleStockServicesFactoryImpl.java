package com.ishan_stocks.arch.impl;

import com.ishan_stocks.arch.SimpleStockServicesFactory;
import com.ishan_stocks.arch.SpringService;
import com.ishan_stocks.services.SimpleStockService;

/**
 * Implementation of the Factory of the services in the Super Simple Stock application. 
 * 
 * As design decision, all possible external systems or high level layers in the application 
 * will access to the services through this factory and because of that it is implemented 
 * as a singleton, following the singleton pattern proposed by Bill Pugh.

 *
 */
public class SimpleStockServicesFactoryImpl implements SimpleStockServicesFactory {

	/**
	 * Private constructor for the factory which prevents new instance
	 */
	private SimpleStockServicesFactoryImpl(){
			
		SpringService.INSTANCE.getClass();
	}

	
	private static class SimpleStockServicesFactoryHolder{
		private static final SimpleStockServicesFactory INSTANCE = new SimpleStockServicesFactoryImpl();
	}

	
	public static SimpleStockServicesFactory getInstance(){
		return SimpleStockServicesFactoryHolder.INSTANCE;
	}
	
	
	public SimpleStockService getSimpleStockService(){
		return SpringService.INSTANCE.getBean("simpleStocksService", SimpleStockService.class);
	}


}
