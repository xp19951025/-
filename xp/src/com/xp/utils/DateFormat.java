package com.xp.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.beanutils.Converter;

//时间格式化
public class DateFormat implements Converter{

	private String pa="yyyy-MM-dd";
	
	public DateFormat(String pa) {
		super();
		this.pa = pa;
	}	

	public DateFormat() {
		super();
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Object convert(Class arg0, Object arg1) {
		// TODO Auto-generated method stub
		if(arg1 == null || arg1.toString().equals("")){
			return null;
		}
		if(arg0 == Date.class){
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pa);
			
			try {
				return simpleDateFormat.parse(String.valueOf(arg1));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return null;
	}

}
