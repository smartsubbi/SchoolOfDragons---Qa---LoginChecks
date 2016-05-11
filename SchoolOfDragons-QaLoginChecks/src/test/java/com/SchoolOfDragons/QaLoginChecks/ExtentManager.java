package com.SchoolOfDragons.QaLoginChecks;

import java.net.InetAddress;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager 
{
	static DateFormat dateFormat = new SimpleDateFormat("E.MMMM.yyyy_HH.mm.ss[a]");
	static Date date = new Date();
	static String finalPath;	
	
	public static ExtentReports Instance() throws Throwable 
	{
		String userDirectory =  System.getProperty("user.dir");
		ExtentReports report;
		InetAddress address = InetAddress.getLocalHost(); 
		String hostIP = address.getHostAddress();	 	        
	    String splitDir[] = userDirectory.split(":");				
		finalPath = "\\\\"+hostIP+splitDir[1]+"\\ExtentReports\\SchoolOfDragonsLive_" +dateFormat.format(date) + ".html";	
		report = new ExtentReports(finalPath, false);
		report.config().documentTitle("Automation Report").reportName("Regression");
		return report;
	}		
}