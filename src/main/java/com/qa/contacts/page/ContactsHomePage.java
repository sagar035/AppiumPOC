package com.qa.contacts.page;

import org.openqa.selenium.By;

import com.qa.contacts.base.BasePage;
import com.qa.contacts.util.ElementUtil;
import com.qa.contacts.util.JavaScriptUtil;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class ContactsPage extends BasePage{

		AppiumDriver<MobileElement> driver;
	    ElementUtil elementUtil;
		JavaScriptUtil jsUtil;

		public ContactsPage(AppiumDriver<MobileElement> driver) {
			this.driver = driver;
			elementUtil = new ElementUtil(driver);
			jsUtil = new JavaScriptUtil(driver);
		}
		
		// 1. locators - By
		By contactManagerText = By.id("in.smartappcart.contactmanager:id/textView1");
		By setPasswordLink = By.id("in.smartappcart.contatmanager:id/ll1");
		By contactsBackRestoreLink = By.id("in.smartappcart.contactmanager:id/ll1ss");
		By contactUsLink = By.id("in.smartappcart.contactmanager:id/ll2");
		
		// page actions:
		public boolean checkContactsManagerHeader(){
			return elementUtil.doIsDisplayed_Android(contactManagerText);
		}
		
		public boolean checkSetPasswordLink(){
			return elementUtil.doIsDisplayed_Android(setPasswordLink);
		}
		
		public BackupRestorePage doBackupRestore(){
			elementUtil.waitForElementPresent(contactsBackRestoreLink);
			elementUtil.doClick_Android(contactsBackRestoreLink);
			return new BackupRestorePage(driver);
		}
		
		public ContactusPage gotoContactUsPage() {
			elementUtil.waitForElementPresent(contactUsLink);
			elementUtil.doClick_Android(contactUsLink);
			return new ContactusPage(driver);
		}
		
}

	