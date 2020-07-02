package com.qa.contacts.tests;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.qa.contacts.base.BasePage;
import com.qa.contacts.page.BackupRestorePage;
import com.qa.contacts.page.ContactsHomePage;
import com.qa.contacts.page.ContactusPage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class BaseTest {

	public AppiumDriver<MobileElement> driver;
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
	}

	@AfterMethod
	public void tearDown() {
		if(driver!=null)
			driver.quit();
	}
}
