package com.qa.contacts.tests;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.contacts.base.BasePage;
import com.qa.contacts.page.BackupRestorePage;
import com.qa.contacts.page.ContactsPage;
import com.qa.contacts.page.ContactusPage;
import com.qa.contacts.util.AppConstants;
import com.qa.contacts.util.ExcelUtil;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class ContactusTest {
	
@Epic("Epic - 203 : ContactUs Feature")
@Feature("US - 814 : contact us verify")
public class BackupRestoreTest {

	AppiumDriver<MobileElement> driver;
	BasePage basePage;
	Properties prop;
	ContactsPage contactsPage;
	ContactusPage contactusPage;
	BackupRestorePage backupRestorePage;
	
	Logger log = Logger.getLogger(ContactusTest.class);
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		basePage = new BasePage();
		prop = basePage.init_properties();
		driver = basePage.launchApp();
		log.info("Launching app");
		contactsPage = new ContactsPage(driver);
		contactusPage = contactsPage.gotoContactUsPage();
		Thread.sleep(5000);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 1, description = "verify contactus header test.....!!!")
	@Description("verify contactus header Test....")
	@Severity(SeverityLevel.NORMAL)
	public void verifyContactUsHeaderTest() {
	   log.info("starting--------------------->>>>>>> verifyContactUsHeaderTest");	
	   Assert.assertTrue(contactusPage.checkContactsUsHeader());
	   log.info("ending--------------------->>>>>>> verifyContactUsHeaderTest");
	}
	
	@DataProvider
	public Object[][] getContactusData(){
		Object[][] data = ExcelUtil.getTestData(AppConstants.CONTACTUS_SHEET_NAME);
		return data;
	}

	@Test(priority = 2, dataProvider= "getContactusData",description = "Verify adding new contact us request")
	@Description("verify adding new contactus request....")
	@Severity(SeverityLevel.CRITICAL)
	public void newContactUsRequestTest(String name, String contactNumber, String emailAddress) {
		log.info("starting--------------------->>>>>>> newContactUsRequestTest");
		contactusPage.newContactUsRequest(name, contactNumber, emailAddress);
		log.info("ending--------------------->>>>>>> newContactUsRequestTest");
	}

}


}
