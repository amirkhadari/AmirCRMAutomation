package com.amircrm.qa.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.amircrm.qa.testutil.Util;

public class Base {
	
	public static Properties prop;
	public static WebDriver driver;
	
	public Base() {
		try {
			FileInputStream fis = new FileInputStream("/home/innoraft/Amir/testing-workspace/"
					+ "AmirCRM_Automation/src/main/java/com/amircrm/qa/config/config.properties");
			prop = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization() {
		
		if(prop.getProperty("browser").equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/home/innoraft/Amir/chromedriver");
			driver = new ChromeDriver();
		}if(prop.getProperty("browser").equals("ff")) {
			System.setProperty("webdriver.gecko.driver", "/home/innoraft/Amir/geckodriver");
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Util.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Util.PAGE_LOAD_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
	}

}
