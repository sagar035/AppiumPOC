package com.qa.contacts.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class JavaScriptUtil {

	public AppiumDriver<MobileElement> driver;

	public JavaScriptUtil(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
	}

	/**
	 * this method is used to flash on an element
	 * @param locator
	 * @return 
	 */
	public void flash(WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String bgcolor = element.getCssValue("backgroundColor");
		for (int i = 0; i < 10; i++) {
			changeColor("rgb(0,200,0)", element);// 1
			changeColor(bgcolor, element);// 2
		}
	}

	/**
	 * this method is used to change color on an element
	 * @param locator
	 * @return 
	 */
	private void changeColor(String color, WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
		}
	}

}
