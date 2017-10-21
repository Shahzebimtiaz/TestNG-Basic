package com.Stella.Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//Validation of title check after login and search flight
//Validation of sign-in feature
// Validation of searching and buying ticket done in this class

public class ValidatorClass2 {
	public static WebDriver driver;
	Variables V = new Variables();
	
	@BeforeClass
	public static void setup(){
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
		driver = new FirefoxDriver();
	}
	
	@Test(priority = 0)
	public void NewUserRegistration() throws Exception{
		driver.get(V.Url);
		driver.findElement(By.linkText("REGISTER")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("firstName")).sendKeys(V.FirstName);
		driver.findElement(By.name("lastName")).sendKeys(V.LastName);
		driver.findElement(By.name("phone")).sendKeys(V.PhoneNumber);
		driver.findElement(By.id("userName")).sendKeys(V.Email);
		driver.findElement(By.name("address1")).sendKeys(V.Address);
		driver.findElement(By.name("city")).sendKeys(V.City);
		driver.findElement(By.name("state")).sendKeys(V.State);
		driver.findElement(By.name("postalCode")).sendKeys(V.PostalCode);
		driver.findElement(By.name("country")).sendKeys("PAKISTAN");
		driver.findElement(By.id("email")).sendKeys(V.UserName);
		driver.findElement(By.name("password")).sendKeys(V.UserPassword);
		driver.findElement(By.name("confirmPassword")).sendKeys(V.ConfirmPassword);
		driver.findElement(By.xpath("//input[@name='register']")).click();
		Thread.sleep(5000);
	}
	
	@Test(priority = 1)
	public void SignInValidator() throws Exception{
		driver.findElement(By.linkText("Home")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("userName")).sendKeys(V.UserName);
		driver.findElement(By.name("password")).sendKeys(V.UserPassword);
		driver.findElement(By.xpath("//input[@name='login']")).click();
		Thread.sleep(5000);
		V.WebSiteActualTitle = driver.getTitle();
		Assert.assertEquals(V.WebSiteActualTitle, V.TitleAfterLogin);	
	}
	
	@Test(priority = 2)
	public void FlightSearchingAndBooking() throws Exception{
		driver.findElement(By.xpath("//input[@value='oneway']")).click();
		driver.findElement(By.name("fromPort")).sendKeys(V.DepartingFrom);
		driver.findElement(By.name("fromMonth")).sendKeys(V.FromMonth);
		driver.findElement(By.name("toPort")).sendKeys(V.ArrivingIN);
		driver.findElement(By.name("toMonth")).sendKeys(V.ToMonth);
		driver.findElement(By.xpath("//input[@value='Business']")).click();
		driver.findElement(By.name("airline")).sendKeys(V.Airline);
		driver.findElement(By.xpath("//input[@name='findFlights']")).click();
		Thread.sleep(5000);
		
		V.WebSiteActualTitle = driver.getTitle();
		Assert.assertEquals(V.WebSiteActualTitle, V.SelectFlight);
		
		driver.findElement(By.xpath("//input[@value='Unified Airlines$363$281$11:24']")).click();
		driver.findElement(By.xpath("//input[@value='Unified Airlines$633$303$18:44']")).click();
		driver.findElement(By.xpath("//input[@name='reserveFlights']")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.name("passFirst0")).sendKeys(V.FirstName);
		driver.findElement(By.name("passLast0")).sendKeys(V.LastName);
		driver.findElement(By.name("pass.0.meal")).sendKeys(V.Meal);
		driver.findElement(By.name("creditCard")).sendKeys(V.CardType);
		driver.findElement(By.name("creditnumber")).sendKeys(V.PhoneNumber);
		driver.findElement(By.name("cc_exp_dt_mn")).sendKeys(V.ExpMonth);
		driver.findElement(By.name("cc_exp_dt_yr")).sendKeys(V.ExpYear);
		driver.findElement(By.name("cc_frst_name")).sendKeys(V.FirstName);
		driver.findElement(By.name("cc_mid_name")).sendKeys(V.FirstName);
		driver.findElement(By.name("cc_last_name")).sendKeys(V.LastName);
		driver.findElement(By.xpath("//input[@name='ticketLess']")).click();
		driver.findElement(By.name("billAddress1")).sendKeys(V.Address);
		driver.findElement(By.name("billCity")).sendKeys(V.City);
		driver.findElement(By.name("billState")).sendKeys(V.State);
		driver.findElement(By.name("billZip")).sendKeys(V.PostalCode);
		driver.findElement(By.name("billCountry")).sendKeys("PAKISTAN");
		driver.findElement(By.xpath("//input[@name='ticketLess']")).click();
		driver.findElement(By.name("delAddress1")).sendKeys(V.Address);
		driver.findElement(By.name("delCity")).sendKeys(V.City);
		driver.findElement(By.name("delState")).sendKeys(V.State);
		driver.findElement(By.name("delZip")).sendKeys(V.PostalCode);
		driver.findElement(By.name("delCountry")).sendKeys("UNITED STATES");
		driver.findElement(By.xpath("//input[@name='buyFlights']")).click();
		Thread.sleep(5000);
		V.WebSiteActualTitle = driver.getTitle();
		Assert.assertEquals(V.WebSiteActualTitle, V.FlightConfirmation);
	}
	
	@AfterClass
	public static void cleanup(){
		driver.quit();
	}
}
