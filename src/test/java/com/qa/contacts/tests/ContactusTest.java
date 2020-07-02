package com.qa.contacts.tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.contacts.util.AppConstants;
import com.qa.contacts.util.ExcelUtil;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Epic("Epic - 203 : ContactUs Feature")
@Feature("US - 814 : contact us verify")
public class ContactusTest extends BaseTest{

	Logger log = Logger.getLogger(ContactusTest.class);

	public void setup() {
		contactusPage = contactsPage.gotoContactUsPage();
	}

	@Test(priority = 1, description = "verify contactus header test.....!!!")
	@Description("verify contactus header Test....")
	@Severity(SeverityLevel.NORMAL)
	public void verifyContactUsHeaderTest() {
		setup();
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
		setup();
		log.info("starting--------------------->>>>>>> newContactUsRequestTest");
		contactusPage.newContactUsRequest(name, contactNumber, emailAddress);
		log.info("ending--------------------->>>>>>> newContactUsRequestTest");
	}
}

