package com.catdog.estate.audit.agency.commission;

import java.io.FileInputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.catdog.common.util.ExcelReadAndWrite;
import com.catdog.estate.audit.agency.commission.model.CustomerComeRecord;
import com.catdog.estate.audit.agency.commission.model.CustomerSubscriptionRecord;
import com.catdog.estate.audit.agency.commission.model.ShortMsgRecord;

public class AuditMgr {

	
	private static Logger logger = Logger.getLogger(AuditMgr.class);  
	
	
	private static String MSG_RECORD_FILE = "msg.xlsx";
	
	private static String MSG_SHEET_NAME = "短信合集";

	private static int MSG_COL_NUM=4;
	
	private static String COME_SHEET_NAME = "明源来电来访";

	private static int COME_COL_NUM=28;
	
	private static String CUST_SUB_RECORD_FILE = "sub.xlsx";

	private static String CUST_COME_RECORD_FILE = "come.xlsx";
	
	private static String BASE_PATH="./files/";

	private static String encoding = "UTF8";
	
//	private static String 
	
	private List<ShortMsgRecord> msgList;
	
	private List<CustomerComeRecord>  comeRecordList;
	
	private List<CustomerSubscriptionRecord>  subRecordList;
	
	

	public AuditMgr() throws Exception {
		logger.info("开始读取excel数据...");
		readRecords();

	}
	
	

	private void readRecords() throws Exception{
//		msgList=readShortMsg();
//		comeRecordList=readComeRecord();
//		subRecordList=readSubscription();
	}

	private List<ShortMsgRecord> readShortMsg() throws Exception{

		logger.info("读取报备信息中...");
		
		List<String[]> msgs=ExcelReadAndWrite.readerExcel(BASE_PATH+MSG_RECORD_FILE, MSG_SHEET_NAME, MSG_COL_NUM);
		List<ShortMsgRecord> list=new ArrayList<ShortMsgRecord>();
		int count=msgs.size();
		ShortMsgRecord msgRecord;
		int errorCount=0;
		for(int i=1;i<=count;i++)
		{
			try{
			msgRecord=new ShortMsgRecord(msgs.get(i-1));
			list.add(msgRecord);
			if(msgRecord.getCustomerPhone().size()==0)
			{
			logger.info(msgRecord.getMsgDetail());
			errorCount++;
			}
			}
			catch(ParseException e)
			{
				logger.error("日期不规范的记录："+msgs.get(i-1));
			}
			
			
		}
		
		
		logger.info("未识别的号码数"+errorCount);
		
		
		logger.info("报备文件读取完毕。记录条数:"+(count-1));
		return list;
	}
	
	
	
	
	//TODO 
	private List<CustomerComeRecord> readComeRecord() throws Exception{

		logger.info("读取客户来电来访信息中...");
		List<String[]> comeRecords=ExcelReadAndWrite.readerExcel(BASE_PATH+CUST_COME_RECORD_FILE, COME_SHEET_NAME, COME_COL_NUM);
		List<CustomerComeRecord> list=new ArrayList<CustomerComeRecord>();
		int count=comeRecords.size();
		CustomerComeRecord comeRecord;
		int errorCount=0;
		for(int i=1;i<=count;i++)
		{
				comeRecord=new CustomerComeRecord(comeRecords.get(i-1));
			list.add(comeRecord);
			
			
		}
		
		
		
		
		logger.info("客户来电来访读取完毕。记录条数:"+(count-1));
		
		
		
		
		
		logger.info("报备文件读取完毕。记录条数:"+(count-1));
		return list;
	}
	
	
	
	private List<CustomerSubscriptionRecord> readSubscription() throws Exception{

		System.out.print("读取转介信息中...");
		XSSFWorkbook w=null;
		Sheet sheet=null;
		List<CustomerSubscriptionRecord> list=null;
		try {
			w = new XSSFWorkbook(new FileInputStream(BASE_PATH+CUST_SUB_RECORD_FILE));
			sheet=w.getSheetAt(0);
		} 
		catch(Exception e)
		{
			System.err.println("转介信息读取错误，请确认文件名是否是"+MSG_RECORD_FILE+"，并且放在files文件下下面");
			throw e;
		}
		
		finally {
			if (w != null) {
				w.close();
			}
		}
		list=new ArrayList<CustomerSubscriptionRecord>();
		int count=sheet.getLastRowNum();
		Row row=null;	
		for(int i=1;i<=count;i++)
		{
			row=sheet.getRow(i);
			
			list.add(new CustomerSubscriptionRecord(row));
		}
		
		
		
		logger.info("转介信息读取完毕。记录条数:"+(count-1));
		return list;
	}
	
	
	public void audit()
	{
		logger.info("开始审计...");
//		for()
		
		
		
		
	}
	
	
	
	


}
