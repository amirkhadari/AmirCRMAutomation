package com.amircrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amircrm.qa.testbase.Base;

public class LoginPage extends Base{
	
	@FindBy(id = "login:usernameDecorate:username")
	WebElement UserName;
	
	@FindBy(id = "login:passwordDecorate:password")
	WebElement PassWord;
	
	@FindBy(id = "login:login")
	WebElement login;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validatePageTitle() {
		return driver.getTitle();
	}
	
	public HomePage login(String UN, String PWD) {
		UserName.sendKeys(UN);
		PassWord.sendKeys(PWD);
		login.click();
		return new HomePage();
	}

}
