package com.revature;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.revature.pages.DashboardPage;
import com.revature.pages.LoginPage;

@TestMethodOrder(OrderAnnotation.class)
class MyAutomationTest {
	
	private static WebDriver driver;
	
	private static LoginPage loginPage;
	private static DashboardPage dashboardpage;
	
	@BeforeAll
	static void setUpBeforeClass() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\yoyos\\OneDrive\\Desktop\\springworkspace\\project-2-Selenium\\src\\main\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://ec2-54-82-79-227.compute-1.amazonaws.com:8080/SuperStocker");
		loginPage = new LoginPage(driver);
		dashboardpage = new DashboardPage(driver);
	}
	
	@AfterAll
	static void tearDown() {
		driver.quit();
	}
	
	@Test
	@Order(0)
	void test_login_success() throws InterruptedException {
		loginPage.typeUsername("selenium");
		loginPage.typePassword("password");
		
		loginPage.clickSubmit();
		
		WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("addStock")));
		
		assertEquals("http://ec2-54-82-79-227.compute-1.amazonaws.com:8080/dashboard", dashboardpage.getURL());
	}
	
	@Test
	@Order(1)
	void test_addStockToPortfolio_success() {
		dashboardpage.typeStockSymbol("AAPL");
		
		dashboardpage.clickAddStock();
		
		WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("AAPL")));
		
		assertEquals("AAPL", dashboardpage.getStockCardId("AAPL"));
	}

}
