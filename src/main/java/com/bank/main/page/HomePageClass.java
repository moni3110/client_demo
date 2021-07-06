package com.bank.main.page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageClass {
	
public HomePageClass(WebDriver driver) {		
		this.driver=driver;		
	}
	private WebDriver driver;
	private By manager_login= By.xpath("//*[@class='btn btn-primary btn-lg' and @ng-click='manager()']");
	private By add_customer=By.xpath("//*[@ng-class='btnClass1' and @ng-click='addCust()']");
	private By F_Name=By.xpath("//input[@ng-model='fName']");
	private By L_Name=By.xpath("//input[@ng-model='lName']");
	private By Post_Codde=By.xpath("//input[@ng-model='postCd']");
	private By add_Cust= By.xpath("//button[@type='submit']");
	private By open_account=By.xpath("//*[@ng-class='btnClass2' and @ng-click='openAccount()']");
	private By customer_DD=By.name("userSelect");
	private By currency_DD=By.name("currency");
	private By process= By.xpath("//button[@type='submit']");
	private By Customerbtn = By.xpath("//*[@ng-class='btnClass3' and @ng-click='showCust()']");
	private By search=By.xpath("//input[@type='text' and @placeholder ='Search Customer']");
	private By first_name_data=By.xpath("//table[@class='table table-bordered table-striped']/tbody/tr/td[1]");
	
    public void addCustomer(String fName,String lName,String pin) throws Exception {		
		findAnElement(manager_login).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		findAnElement(add_customer).click();		
		findAnElement(F_Name).sendKeys(fName);		
		findAnElement(L_Name).sendKeys(lName);		
		findAnElement(Post_Codde).sendKeys(pin);		
		findAnElement(add_Cust).click();
		}
		
   public void openAccount(String val,String currency) throws Exception {
	
	    findAnElement(open_account).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);		
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(customer_DD));
		Select sel =new Select(findAnElement(customer_DD));				
		sel.selectByVisibleText(val);	
		WebDriverWait wait1 = new WebDriverWait(driver, 10);		
		wait1.until(ExpectedConditions.presenceOfAllElementsLocatedBy(currency_DD));
		Select sel2 =new Select(findAnElement(currency_DD));
		sel2.selectByVisibleText(currency);			
		findAnElement(process).click();			
	}
   public String searchCustomer(String fName) throws Exception
   {
	   findAnElement(Customerbtn).click();	 
	   findAnElement(search).sendKeys(fName);	  
	   String test = findAnElement(first_name_data).getText();	
	   return test;
   }
   public WebElement findAnElement(By element) {
		 
		 return driver.findElement(element);
		
	}
	
}
