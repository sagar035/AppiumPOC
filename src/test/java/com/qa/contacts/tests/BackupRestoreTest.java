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
import com.qa.contacts.util.AppConstants;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;


@Epic("Epic - 202 : Contacts Backup Restore Feature")
@Feature("US - 607 : contacts backup restore page verify")
public class BackupRestoreTest {

	AppiumDriver<MobileElement> driver;
	BasePage basePage;
	Properties prop;
	ContactsPage contactsPage;
	BackupRestorePage backupRestorePage;
	
	Logger log = Logger.getLogger(BackupRestoreTest.class);
	
	@BeforeMethod
	//@Parameters(value={"browser"})
	public void setUp() throws InterruptedException {
		basePage = new BasePage();
		prop = basePage.init_properties();
		driver = basePage.launchApp();
		log.info("Launching app");
		contactsPage = new ContactsPage(driver);
		backupRestorePage = contactsPage.doBackupRestore();
		Thread.sleep(5000);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 1, description = "verify restore contact text.....!!!")
	@Description("verify restore contact Text....")
	@Severity(SeverityLevel.NORMAL)
	public void verifyRestoreContactsTextTest() {
		log.info("starting--------------------->>>>>>> verifyRestoreContactsTextTest");
		String restoreText = backupRestorePage.getRestoreContactsText();
		System.out.println("Restore contacts text is : " + restoreText);
		log.info("Restore contacts text is : " + restoreText);
		Assert.assertEquals(restoreText, AppConstants.RESTORE_CONTACT_TEXT);
		log.info("ending--------------------->>>>>>> verifyRestoreContactsTextTest");
	}

	@Test(priority = 2, description = "verify clicking on BackupRestore test.....!!!")
	@Description("verify clicking on BackupRestore Test....")
	@Severity(SeverityLevel.NORMAL)
	public void verifyContactClickTest() {
		log.info("starting--------------------->>>>>>> verifyContactClickTest");
		backupRestorePage.clickOnBackupContacts();
		log.info("ending--------------------->>>>>>> verifyContactClickTest");
	}

}
