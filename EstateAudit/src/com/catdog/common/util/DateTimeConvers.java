package com.catdog.common.util;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeConvers {

	
	String time1="2016/7/12 9:40:10";
	String time2s="2016/7/12 10:40:10";
	
	 Date currentTime = new Date();
	   
	   
	   public static long strToLong(String timeStr,String formatStr) throws ParseException
	   {
		   
		   SimpleDateFormat formatter = new SimpleDateFormat(formatStr);
		   return formatter.parse(timeStr).getTime()/1000;
		   
		   
	   }
	   
	   public static Date strToDate(String timeStr,String formatStr) throws ParseException
	   {
		   
		   SimpleDateFormat formatter = new SimpleDateFormat(formatStr);
		   return formatter.parse(timeStr);
		   
		   
	   }
}
