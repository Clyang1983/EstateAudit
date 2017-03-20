package com.catdog.estate.audit.agency.commission.model;

import java.util.HashSet;
import java.util.Set;

public class AgencySet{

//	private static Properties agentProperties;
//	
//	public boolean containKey()
//	{
//		return this.agentProperties.containsKey(key)
//	}
	
	public static Set<String> agentSet;
	static
	{
		agentSet=new HashSet<String>();
		agentSet.add("房房顺");
		agentSet.add("Q房网");
		agentSet.add("海睿");
		agentSet.add("家家顺");
		agentSet.add("房多多");
		agentSet.add("联盟");
		agentSet.add("链家");
		agentSet.add("平安好房");
		agentSet.add("天天乐");
		agentSet.add("中原");
		agentSet.add("搜房网");
		agentSet.add("安居客");
		agentSet.add("光昊");
		agentSet.add("卡考");
	}
	
    public static boolean containAgency(String agency)
    {
    	return agentSet.contains(agency);
    }
	
    
	
}
