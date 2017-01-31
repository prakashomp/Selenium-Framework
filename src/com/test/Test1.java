package com.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.generic.Asserts;
import com.generic.Selenium;
import com.generic.WebDriverUtil;


public class Test1 {
	public WebDriver driver;
	private WebDriverUtil common;
	public Asserts asserts;
	@BeforeClass(alwaysRun = true)
	@Parameters({"browser"})
	public void setUp(@Optional("chrome") String browser) {

		Selenium MSOSelenium = new Selenium(browser);
		driver=MSOSelenium.getDriver();
		common = new WebDriverUtil(driver);
		asserts = new Asserts(Test1.class);
		
	}
	@Test
	public void login() throws InterruptedException{
		driver.get("https://www.google.co.in/");
	}
}
