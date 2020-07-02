package com.qa.contacts.page;

import org.openqa.selenium.By;

import com.qa.contacts.base.BasePage;
import com.qa.contacts.util.ElementUtil;
import com.qa.contacts.util.JavaScriptUtil;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class ContactusPage extends BasePage{

	public AppiumDriver<MobileElement> driver;
	ElementUtil elementUtil;
	JavaScriptUtil jsUtil;

	public ContactusPage(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
		jsUtil = new JavaScriptUtil(driver);
	}

	// locators - By
	By contactUsHeader = By.id("in.smartappcart.contactmanager:id/texttitle1");
	By name = By.id("in.smartappcart.contactmanager:id/crname");
	By contactNumber = By.id("in.smartappcart.contactmanager:id/crcontact");
	By emailAddress = By.id("in.smartappcart.contactmanager:id/cremail");
	By submit = By.id("in.smartappcart.contactmanager:id/crsubmit2");


	// page actions:
	public boolean checkContactsUsHeader(){
		elementUtil.waitForElementPresent(contactUsHeader);
		return elementUtil.doIsDisplayed_Android(contactUsHeader);
	}

	public void newContactUsRequest(String nm, String cNumber, String eAddress) {

		elementUtil.waitForElementPresent(name);
		elementUtil.doSendKeys(name, nm);

		elementUtil.doSendKeys(contactNumber, cNumber);

		elementUtil.doSendKeys(emailAddress, eAddress);

		elementUtil.doClick_Android(submit);

	}

}
