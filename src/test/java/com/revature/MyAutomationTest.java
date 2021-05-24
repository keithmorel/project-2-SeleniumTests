package com.revature;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
		driver.get("http://localhost:4200/");
		loginPage = new LoginPage(driver);
		dashboardpage = new DashboardPage(driver);
	}
	
	@AfterAll
	static void tearDown() {
		driver.quit();
	}
	
	@Test
	@Order(0)
	void test_login_success() {
		loginPage.typeUsername("username");
		loginPage.typePassword("password");
		
		loginPage.clickSubmit();
		
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		assertEquals("http://localhost:4200/dashboard", dashboardpage.getURL());
	}
	
	@Test
	@Order(1)
	void test_addStockToPortfolio_success() {
		dashboardpage.typeStockSymbol("GOOG");
		
		dashboardpage.clickAddStock();
		
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		assertEquals("GOOG", dashboardpage.getStockCardId("GOOG"));
	}

}
