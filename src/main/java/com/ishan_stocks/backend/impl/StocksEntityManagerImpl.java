package com.ishan_stocks.backend.impl;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;

import com.ishan_stocks.backend.StocksEntityManager;
import com.ishan_stocks.model.Stock;
import com.ishan_stocks.model.Trade;

public class StocksEntityManagerImpl implements StocksEntityManager {

	/**
	 *
	 */
	private Logger logger = Logger.getLogger(StocksEntityManagerImpl.class);

	/**
	 * 
	 */
	private HashMap<String, Stock> stocks = null;

	/**
	 * 
	 */
	private ArrayList<Trade> trades = null;

	/**
	 * 
	 */
	public StocksEntityManagerImpl(){
		trades = new ArrayList<Trade>();
		stocks = new HashMap<String, Stock>();
	}


	public HashMap<String, Stock> getStocks() {
		return stocks;
	}

	/**
	 * 
	 * @param stocks
	 */
	public void setStocks(HashMap<String, Stock> stocks) {
		this.stocks = stocks;
	}


	public ArrayList<Trade> getTrades() {
		return trades;
	}

	/**
	 * 
	 * @param trades
	 */
	public void setTrades(ArrayList<Trade> trades) {
		this.trades = trades;
	}


	public boolean recordTrade(Trade trade) throws Exception{
		boolean result = false;
		try{
			result = trades.add(trade);
		}catch(Exception exception){
			throw new Exception("An error has occurred recording a trade in the system's backend.", exception);
		}
		return result;
	}


	public int getTradesNumber() {
		return trades.size();
	}

	
	public Stock getStockBySymbol(String stockSymbol){
		Stock stock = null;
		try{
			if(stockSymbol!=null){
				stock = stocks.get(stockSymbol);
			}
		}catch(Exception exception){
			logger.error("An error has occurred recovering the stock object for the stock symbol: "+stockSymbol+".", exception);
		}
		return stock;
	}



}
