package com.catdog.estate.audit.agency.commission.model;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.catdog.common.util.DateTimeConvers;

public class ShortMsgRecord {

	private  Date msgDate;
	
	private String agencyCorp;
	
	private List<String> customerPhone;
	
	private String msgDetail;
	
	private final static int COL_YEAR=0;
	
	private final static int COL_DATE=1;
	
	private final static int COL_MSG=2;
	
	
	
	private static String DATE_FORMAT="yyyy/MM/dd HH:mm:ss";
	

	public ShortMsgRecord(String[] strs) throws ParseException{

		msgDate=DateTimeConvers.strToDate(strs[COL_YEAR]+" "+strs[COL_DATE], DATE_FORMAT);
		msgDetail=strs[COL_MSG];
		customerPhone=splitCustormerPhone(msgDetail);
		agencyCorp=splitAgency(msgDetail);
	}
	
	private List<String> splitCustormerPhone(String str)
	{
		
		List<String> phoneList=new ArrayList<String>();
		
		String regEx="1[0-9]{2}[\\*\\-\\+…，.x×X\\#—\\/ %^~、¥～。✘@＊⋯$]{1,8}[0-9]{4}";   
		Pattern p = Pattern.compile(regEx);   
		Matcher m = p.matcher(str.trim());
		while(m.find())
		{
			phoneList.add( m.group());
		}
		return phoneList;
		
		
	}
	
	private String splitAgency(String str)
	{
		String agency="未能识别";
		
		
		for(String eachStr:AgencySet.agentSet)
		{
			if(str.indexOf(eachStr)!=-1)
			{
				agency=eachStr;
				break;
			}
		}
		
		return agency;
		
	}
	
	
	public Date getMsgDate() {
		return msgDate;
	}


	public String getAgencyCorp() {
		return agencyCorp;
	}


	public List<String> getCustomerPhone() {
		return customerPhone;
	}


	public String getMsgDetail() {
		return msgDetail;
	}


	public static void main(String[] args) throws Exception
	{
//		
//		String time1="2016/7/12 9:40:10";
//		String time2s="2016/7/12 10:40:10";
//		
//		 Date currentTime = new Date();
//		   SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//		   String dateString = formatter.format(currentTime);
//		   ParsePosition pos = new ParsePosition(8);
//		   Date currentTime_2 = formatter.parse(dateString, pos);
//		   System.out.println(dateString);
//		   
//		   System.out.println(formatter.parse(time1).getTime());
//		   System.out.println(formatter.parse(time2s).getTime());
		   
		
	}
	
	public String toString()
	{
		return msgDate+" " +agencyCorp + " phone:"+customerPhone.toString();
	}

}
