package com.qa.contacts.util;

public class AppConstants {

	// App parameters
	//public static final String APK_PATH = System.getProperty("user.dir")+"\\src\\test\\java\\apk\\ContactManager.apk";
//	public static final String DEVICE_NAME = "Android Emulator";
//	public static final String UDID = "emulator-5554";
//	public static final String PLATFORM_NAME = "Android";
//	public static final String PLATFORM_VERSION = "8.0";
//	public static final String AUTOMATION_NAME = "uiautomator2";
//	public static final String APP_PACKAGE = "in.smartappcart.contactmanager";
//	public static final String APP_ACTIVITY = "in.smartappcart.contactmanager.Sactivity";
//	public static final String NO_RESET = "true";
	
	public static final String DEVICE_NAME = "Moto G5 Plus";
	public static final String UDID = "ZY2245MSZC";
	public static final String PLATFORM_NAME = "Android";
	public static final String PLATFORM_VERSION = "8.1.0";
	public static final String AUTOMATION_NAME = "UiAutomator2";
	public static final String APP_PACKAGE = "in.smartappcart.contactmanager";
	public static final String APP_ACTIVITY = "in.smartappcart.contactmanager.Sactivity";
	public static final String NO_RESET = "true";
	
	//http://localhost:4444/wd/hub
	public static final String HUB_URL = "http://127.0.0.1:4723/wd/hub";

	public static final String XLS_PATH = System.getProperty("user.dir")+"//src//main//java//com/qa//contacts//testdata//ContactsTestData.xlsx";
	public static final String CONTACTUS_SHEET_NAME = "contactus";
	
	
	//*****************TimeOuts ********************
	public static int DEFAULT_TIME_OUT = 20;


	//*****************Page Constants ********************
	public final static String RESTORE_CONTACT_TEXT = "Restore Contats";
	
}
