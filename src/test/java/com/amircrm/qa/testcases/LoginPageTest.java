package com.amircrm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amircrm.qa.pages.HomePage;
import com.amircrm.qa.pages.LoginPage;
import com.amircrm.qa.testbase.Base;

public class LoginPageTest extends Base{
	
	LoginPage loginp;
	HomePage homepage;
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUP() {
		initialization();
		loginp = new LoginPage();
	}	
	
	@Test(priority=01)
	public void PageTitleTest() {
		String ActualTitle = loginp.validatePageTitle();
		String ExpectedTitle = "innoraft CRM";
		Assert.assertEquals(ActualTitle, ExpectedTitle);
	}
	@Test(priority=02)
	public void loginTest() {
		homepage = loginp.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
