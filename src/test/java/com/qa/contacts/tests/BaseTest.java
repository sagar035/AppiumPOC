package com.qa.contacts.tests;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.qa.contacts.base.BasePage;
import com.qa.contacts.page.ContactsPage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class BaseTest {
	
	AppiumDriver<MobileElement> driver;
	BasePage basePage;
	Properties prop;
	ContactsPage contactsPage;
	//Credentials userCred;

	Logger log = Logger.getLogger(BaseTest.class);

	@BeforeMethod
	//@Parameters(value={"browser"})
	public void setUp() throws InterruptedException {
		basePage = new BasePage();
		prop = basePage.init_properties();
		driver = basePage.launchApp();
		log.info("Launching app");
		contactsPage = new ContactsPage(driver);
		Thread.sleep(5000);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
