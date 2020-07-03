package com.qa.contacts.tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.contacts.util.AppConstants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;


@Epic("Epic - 202 : Contacts Backup Restore Feature")
@Feature("US - 607 : contacts backup restore page verify")
public class BackupRestoreTest extends BaseTest{

	Logger log = Logger.getLogger(BackupRestoreTest.class);

	public void setup() {
		backupRestorePage = contactsPage.gotoBckupRestore();
	}

	@Test(priority = 1, description = "verify restore contact text.....!!!")
	@Description("verify restore contact Text....")
	@Severity(SeverityLevel.NORMAL)
	public void verifyRestoreContactsTextTest() {
		setup();
		log.info("starting--------------------->>>>>>> verifyRestoreContactsTextTest");
		String restoreText = backupRestorePage.getRestoreContactsText();
		System.out.println("Restore contacts text is : " + restoreText);
		log.info("Restore contacts text is : " + restoreText);
		Assert.assertEquals(restoreText, AppConstants.RESTORE_CONTACT_TEXT);
		log.info("ending--------------------->>>>>>> verifyRestoreContactsTextTest");
	}

	@Test(priority = 2, enabled=false, description = "verify clicking on BackupRestore test.....!!!")
	@Description("verify clicking on BackupRestore Test....")
	@Severity(SeverityLevel.NORMAL)
	public void verifyContactClickTest() {
		setup();
		log.info("starting--------------------->>>>>>> verifyContactClickTest");
		backupRestorePage.clickOnBackupContacts();
		log.info("ending--------------------->>>>>>> verifyContactClickTest");
	}

}
