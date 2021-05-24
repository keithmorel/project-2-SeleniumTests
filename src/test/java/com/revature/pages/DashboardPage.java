package com.revature.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
	
	private WebDriver driver;
	
	private By stockSymbolLocator = By.id("stockInput");
	private By addStockLocator = By.id("addStock");
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getURL() {
		return this.driver.getCurrentUrl();
	}
	
	public void typeStockSymbol(String symbol) {
		this.driver.findElement(stockSymbolLocator).sendKeys(symbol);
	}
	
	public String getStockCardId(String symbol) {
		return this.driver.findElement(By.id(symbol)).getAttribute("id");
	}
	
	public void clickAddStock() {
		this.driver.findElement(addStockLocator).click();
	}
	

}
