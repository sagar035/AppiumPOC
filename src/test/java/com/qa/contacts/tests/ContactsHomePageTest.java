package com.qa.contacts.tests;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.contacts.base.BasePage;
import com.qa.contacts.page.BackupRestorePage;
import com.qa.contacts.page.ContactsPage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Epic("Epic - 101 : Contacts Manager Home Page Feature")
@Feature("US - 501 : contacts manager home page verify")
public class ContactsHomePageTest{
	
	AppiumDriver<MobileElement> driver;
	BasePage basePage;
	Properties prop;
	ContactsPage contactsPage;
	BackupRestorePage backupRestorePage;
	
	Logger log = Logger.getLogger(ContactsHomePageTest.class);


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

	@Test(priority = 1, description = "verify contact header test.....!!!")
	@Description("verify contact header Test....")
	@Severity(SeverityLevel.NORMAL)
	public void verifyContactHeaderTest() {
	   log.info("starting--------------------->>>>>>> verifyContactHeaderTest");	
	   Assert.assertTrue(contactsPage.checkContactsManagerHeader());
	   log.info("ending--------------------->>>>>>> verifyContactHeaderTest");
	}

	@Test(priority = 2, enabled=true)
	@Description("verify set password link Test....")
	@Severity(SeverityLevel.NORMAL)
	public void verifySetPasswordTest() {
		log.info("starting--------------------->>>>>>> verifySetPasswordTest");
		Assert.assertTrue(contactsPage.checkSetPasswordLink());
		log.info("ending--------------------->>>>>>> verifySetPasswordTest");
	}

	@Test(priority = 3, enabled=true)
	@Description("verify back up restore click Test....")
	@Severity(SeverityLevel.BLOCKER)
	public void goToBackUpRestoreTest() {
		log.info("starting--------------------->>>>>>> goToBackUpRestoreTest");
		backupRestorePage = contactsPage.doBackupRestore();
		log.info("ending--------------------->>>>>>> goToBackUpRestoreTest");
	}


}
