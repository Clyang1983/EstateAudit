package com.catdog.estate.audit.agency.commission;

import java.util.regex.Pattern;

import org.apache.log4j.Logger;

public class Main {
	private static Logger logger = Logger.getLogger(Main.class);  
	
	private static boolean isMacAddress(String macAddress){
//        String reg = "^([0-9a-fA-F]){2}([:][0-9a-fA-F]{2}){5}";
		 String reg = "^4([0-9]){4}";
        return Pattern.compile(reg).matcher(macAddress).find();
    }
	
	public static void main(String[] args) throws Exception
	{
		logger.info("房地产审计开始..");
		

//		
		AuditMgr mgr=new AuditMgr();
		mgr.audit();
//		mgr.testWorkBook();
		
		
		
		
		
		
	}
}
