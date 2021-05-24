package com.revature.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	
	private WebDriver driver;
	
	private By usernameLocator = By.id("usernameInput");
	private By passwordLocator = By.id("passwordInput");
	private By loginLocator = By.id("submitButton");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void typeUsername(String username) {
		this.driver.findElement(usernameLocator).sendKeys(username);
	}
	
	public void typePassword(String password) {
		this.driver.findElement(passwordLocator).sendKeys(password);
	}
	
	public void clickSubmit() {
		this.driver.findElement(loginLocator).click();
	}
	
}
