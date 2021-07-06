package com.bank.main.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.bank.main.base.CommonCode;

import com.bank.main.page.HomePageClass;

public class AddCustomer extends CommonCode {
	private WebDriver driver;
	private HomePageClass obj1;
	@BeforeClass
	public void setUp() {
		driver=getDriver();
	}
	@Test(priority =1)
	public void homePageTest() throws Exception
	{		
		obj1= new HomePageClass(driver);		
		obj1.addCustomer("Reena", "Rai", "244001");		
		handleAlert();		
	}
	@Test(priority =2)
	public void openAccountTest() throws Exception
	{
		obj1.openAccount("Reena Rai", "Rupee");
		handleAlert();		
	}
	@Test (priority =3)
	public void searchCustomerTest() throws Exception
	{
		String str=obj1.searchCustomer("Reena");		
		Assert.assertEquals(str, "Reena");
	}
	
}
