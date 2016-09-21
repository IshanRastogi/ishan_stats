package com.ishan_stocks.arch.utils.impl;

import java.util.Calendar;
import java.util.Date;

import com.ishan_stocks.arch.utils.DatesUtils;


public class DatesUtilsImpl implements DatesUtils {

	/**
	 * Constructor of the class.
	 */
	public DatesUtilsImpl(){
		
	}
	
	public Date getNowMovedMinutes(int minutes){
		Calendar now = Calendar.getInstance();
		now.add(Calendar.MINUTE, minutes);
		return now.getTime();
	}
}
