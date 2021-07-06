package com.bank.main.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonCode {
private WebDriver driver;
	
	public WebDriver getDriver()
	{
		return driver;
	}
	private void setDriver()
	{		
			driver =initChromeDrievr();
	}
	
	private static WebDriver initChromeDrievr()
	{
		System.out.println("Launching google chrome with new profile..");
		WebDriverManager.chromedriver().setup();
		System.out.println("Browser executable path is set as :- "+System.getProperty("webdriver.chrome.driver"));
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.way2automation.com/angularjs-protractor/banking/#/login");
		return driver;
	}
	public void handleAlert() {	
		driver.switchTo().alert().accept();	
	}  
	
	@BeforeClass
	public void initializeTestBaseSetUp()
	{
		try {
			setDriver();
		}
		catch (Exception e) {
			System.out.println("Error....." + e.getStackTrace());
		}
	 
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}


