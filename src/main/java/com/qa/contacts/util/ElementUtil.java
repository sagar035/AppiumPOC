package com.qa.contacts.util;

import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.qa.contacts.base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class ElementUtil extends BasePage{

	public AppiumDriver<MobileElement> driver;
	WebDriverWait wait;
	JavaScriptUtil jsUtil;
	Properties prop;

	public ElementUtil(AppiumDriver<MobileElement> driver) {
		prop = super.prop;
		this.driver = driver;
		wait = new WebDriverWait(driver, AppConstants.DEFAULT_TIME_OUT);
		jsUtil = new JavaScriptUtil(driver);
	}

	/**
	 * this method is used to wait for an element
	 * @param locator
	 * @return 
	 */
	public boolean waitForElementPresent(By locator) {
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return true;
	}

	/**
	 * this method is used to wait for an element to be visible
	 * @param locator
	 * @return 
	 */
	public boolean waitForElementVisible(By locator) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return true;
	}

	/**
	 * this method is used to create the webelement on the basis of By locator
	 * @param locator
	 * @return element
	 */
	public WebElement getElement(By locator) {
		WebElement element = null;
		try {	
			// if(waitForElementPresent(locator));
			element = driver.findElement(locator);
			if(highlighElement){
				jsUtil.flash(element);
			}

		} catch (Exception e) {
			System.out.println("some exception got occurred while creating the web element.....");
		}
		return element;
	}

	/**
	 * this method is used to check element is displayed or not
	 * @param locator
	 * @return true if element is displayed otherwise false
	 */
	public boolean doIsDisplayed_Android(By locator) {
		try {
			waitForElementPresent(locator);
			return getElement(locator).isDisplayed();
		} catch (Exception e) {
			System.out.println("some exception got occurred while checking element is displayed or not.....");
		}
		return false;
	}

	/**
	 * this method is used to click on an element
	 * @param locator
	 * @return 
	 */
	public void doClick_Android(By locator) {
		try {
			waitForElementPresent(locator);
			getElement(locator).click();
		} catch (Exception e) {
			System.out.println("some exception got occurred while clicking on the web element.....");

		}
	}

	/**
	 * this method is used to send value to the field
	 * @param locator
	 * @return 
	 */
	public void doSendKeys(By locator, String value) {
		try {
			//wait visible
			WebElement ele = getElement(locator);
			ele.clear();
			ele.sendKeys(value);
		} catch (Exception e) {
			System.out.println("some exception got occurred while entering value in a field.....");

		}
	}

	/**
	 * this method is used to get text on an element
	 * @param locator
	 * @return text of element
	 */
	public String doGetText_Android(By locator) {
		try {
			waitForElementPresent(locator);
			return getElement(locator).getText();
		} catch (Exception e) {
			System.out.println("some exception got occurred while getting the text from a webelement.....");
		}
		return null;
	}

}
