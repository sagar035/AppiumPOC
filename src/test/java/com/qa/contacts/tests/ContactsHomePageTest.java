package com.qa.contacts.tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Epic("Epic - 101 : Contacts Manager Home Page Feature")
@Feature("US - 501 : contacts manager home page verify")
public class ContactsHomePageTest extends BaseTest{

	Logger log = Logger.getLogger(ContactsHomePageTest.class);

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
	@Description("verify backup restore click Test....")
	@Severity(SeverityLevel.BLOCKER)
	public void goToBackUpRestoreTest() {
		log.info("starting--------------------->>>>>>> goToBackUpRestoreTest");
		backupRestorePage = contactsPage.gotoBckupRestore();
		log.info("ending--------------------->>>>>>> goToBackUpRestoreTest");
	}

	@Test(priority = 4, enabled=true)
	@Description("verify contactus click Test.....")
	@Severity(SeverityLevel.BLOCKER)
	public void goToContactUsTest() {
		log.info("starting--------------------->>>>>>> goToContactUsTest");
		contactusPage = contactsPage.gotoContactUsPage();
		log.info("ending--------------------->>>>>>> goToContactUsTest");
	}

}
