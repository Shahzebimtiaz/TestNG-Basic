package com.Stella.Assignment;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


//validation of Sign-on, Register, Support and Contact link done in this class
public class ValidatorClass {

	public static WebDriver driver;
	Variables V = new Variables();
	
	@BeforeClass
	public static void setup(){
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
		driver = new FirefoxDriver();
	}
	
	@Test(priority = 3)
	public void RegisterLinkValidator() throws Exception{
		driver.get(V.Url);
		System.out.println("WebSite Title = "+driver.getTitle());
		Assert.assertTrue(driver.findElement(By.linkText("REGISTER")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.linkText("REGISTER")).isEnabled());
		driver.findElement(By.linkText("REGISTER")).click();
		Thread.sleep(1000);
		V.WebSiteActualTitle = driver.getTitle();
		Assert.assertEquals(V.WebSiteActualTitle, V.RegisterExpectedTitle);
		driver.navigate().back();
	}
	
	@Test(priority = 4)
	public void SupportLinkValidator() throws Exception{
		Assert.assertTrue(driver.findElement(By.linkText("SUPPORT")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.linkText("SUPPORT")).isEnabled());
		driver.findElement(By.linkText("SUPPORT")).click();
		Thread.sleep(1000);
		V.WebSiteActualTitle = driver.getTitle();
		Assert.assertEquals(V.WebSiteActualTitle, V.SupportExpectedTitle);
		driver.navigate().back();
	}
	
	@Test(priority = 5)
	public void ContactLinkValidator() throws Exception{
		Assert.assertTrue(driver.findElement(By.linkText("CONTACT")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.linkText("CONTACT")).isEnabled());
		driver.findElement(By.linkText("CONTACT")).click();
		Thread.sleep(1000);
		V.WebSiteActualTitle = driver.getTitle();
		Assert.assertEquals(V.WebSiteActualTitle, V.ConatctExpectedTitle);
		driver.navigate().back();
	}
	
	@Test(priority = 6)
	public void SignOnLinkValidator() throws Exception{
		Assert.assertTrue(driver.findElement(By.linkText("SIGN-ON")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.linkText("SIGN-ON")).isEnabled());
		driver.findElement(By.linkText("SIGN-ON")).click();
		Thread.sleep(1000);
		V.WebSiteActualTitle = driver.getTitle();
		Assert.assertEquals(V.WebSiteActualTitle, V.SignOnExpectedTitle);
		driver.navigate().back();
	}
	
	@AfterClass
	public static void cleanup(){
		driver.quit();
	}
	
	
}
