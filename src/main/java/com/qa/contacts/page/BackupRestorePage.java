package com.qa.contacts.page;

import org.openqa.selenium.By;

import com.qa.contacts.util.ElementUtil;
import com.qa.contacts.util.JavaScriptUtil;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class BackupRestorePage {

	AppiumDriver<MobileElement> driver;
	ElementUtil elementUtil;
	JavaScriptUtil jsUtil;

	public BackupRestorePage(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
		jsUtil = new JavaScriptUtil(driver);
	}


	// 1. locators - By
	By backUpContactsLink = By.xpath("//*[contains(@text,'BackUp Contacts')]");
	By restoreContactsLink = By.id("in.smartappcart.contactmanager:id/brtextView2");

	// page actions:
	public String getRestoreContactsText() {
		elementUtil.waitForElementPresent(restoreContactsLink);
		return elementUtil.doGetText_Android(restoreContactsLink);	
	}

	public void clickOnBackupContacts() {
		elementUtil.waitForElementPresent(backUpContactsLink);
		elementUtil.doClick_Android(backUpContactsLink);
	}



}
