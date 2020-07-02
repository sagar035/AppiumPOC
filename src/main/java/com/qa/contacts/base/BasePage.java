package com.qa.contacts.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import com.qa.contacts.util.AppConstants;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class BasePage {

	public static AppiumDriver<MobileElement> driver;
	public Properties prop;
	public static boolean highlighElement;
	public String platformName;
	
	public AppiumDriver<MobileElement> launchApp() throws InterruptedException{
		//File app = new File(AppConstants.APK_PATH);
		DesiredCapabilities caps = new DesiredCapabilities();
		platformName = AppConstants.PLATFORM_NAME;

		caps.setCapability("deviceName", AppConstants.DEVICE_NAME);
		caps.setCapability("udid", AppConstants.UDID); 
		caps.setCapability("platformName", AppConstants.PLATFORM_NAME);
		caps.setCapability("platformVersion", AppConstants.PLATFORM_VERSION);
		caps.setCapability("automationName", AppConstants.AUTOMATION_NAME);
		caps.setCapability("appPackage", AppConstants.APP_PACKAGE);
		caps.setCapability("appActivity",AppConstants.APP_ACTIVITY);
		caps.setCapability("noReset", AppConstants.NO_RESET);
		//caps.setCapability("app", app.getAbsolutePath());

		try {
			if (platformName.equals("Android")) {
				driver = new AndroidDriver<MobileElement>(new URL(AppConstants.HUB_URL), caps);			
			}
			else if (platformName.equals("iOS")) {
				driver = new IOSDriver<MobileElement>(new URL(AppConstants.HUB_URL), caps);
			}
			else {
				System.out.println("Platform Name " + platformName + " is not found, please pass the correct browser");
			}

		} catch (MalformedURLException e) {
			Assert.fail("Application did not launch"+ e.getMessage());
		}

		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(5000);

		return driver;
	}
	
	public static AppiumDriver<MobileElement> getDriver() {
		return driver;
	}

	public Properties init_properties() {
		prop = new Properties();
		String path = "./src/main/java/com/qa/contacts/config/config.properties";

		try {
			FileInputStream ip = new FileInputStream(path);
			prop.load(ip);
		} catch (FileNotFoundException e) {
			System.out.println("some issue with config properties....Please correct your config...");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;
	}

	/**
	 * take screenshot
	 */

	public String getScreenshot() {

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);

		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			System.out.println("screenshot captured failed...");
		}

		return path;

	}

}
