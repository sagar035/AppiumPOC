package com.qa.contacts.tests;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.qa.contacts.base.BasePage;
import com.qa.contacts.page.BackupRestorePage;
import com.qa.contacts.page.ContactsHomePage;
import com.qa.contacts.page.ContactusPage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.screenrecording.CanRecordScreen;

public class BaseTest {

	public static AppiumDriver<MobileElement> driver;
	public Properties prop;
	public BasePage basePage;
	public ContactsHomePage contactsPage;
	public BackupRestorePage backupRestorePage;
	public ContactusPage contactusPage;

	Logger log = Logger.getLogger(BaseTest.class);

	@BeforeMethod
	public void setUp() throws InterruptedException {
		basePage = new BasePage();
		prop = basePage.init_properties();
		driver = basePage.launchApp();
		log.info("Launching app");
		contactsPage = new ContactsHomePage(driver);
		Thread.sleep(5000);
		System.out.println("screen record started");
		((CanRecordScreen) driver).startRecordingScreen();
	}


	@AfterMethod
	public void tearDownVideo(ITestResult result) {

		FileOutputStream stream;
		String media = ((CanRecordScreen) driver).stopRecordingScreen();

		String dir = "screenRecords" + File.separator + result.getTestClass().getRealClass().getSimpleName();
		System.out.println("Directory is " +dir);
		File videoDir = new File(dir);
		if (!videoDir.exists()) {
			videoDir.mkdirs();
		}

		try{
			stream = new FileOutputStream(videoDir + File.separator + result.getName() + ".mp4");
			stream.write(Base64.decodeBase64(media));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}

		if(driver!=null)
			driver.quit();	
	}

	//	@BeforeMethod
	//	public void setUp() throws InterruptedException {
	//		basePage = new BasePage();
	//		prop = basePage.init_properties();
	//		driver = basePage.launchApp();
	//		log.info("Launching app");
	//		contactsPage = new ContactsHomePage(driver);
	//		Thread.sleep(5000);
	//	    
	//	}
	//
	//	@AfterMethod
	//	public void tearDown() {	
	//		if(driver!=null)
	//			driver.quit();	
	//	}


}
