package com.crm.Actitime.GenericLibrary;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.crm.Actitime.objectRepository.login;

public class baseClass {
	
	static {
		System.setProperty("Webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	
	ReadDataFromProperty r=new ReadDataFromProperty();  // Create object for class ReadDataFromProperty. to access non static method present inside it (global object) 
	public static WebDriver driver;  					// It is a global variable to use in all methods
	
	@BeforeSuite
	public void databaseconnection() {
		Reporter.log("database is connected",true);
	}
	@AfterSuite
	public void disconnection() {
		Reporter.log("database is disconnected",true);
	}
	@BeforeTest
	public void launcheBrouser() throws IOException {
		Reporter.log("brouser is launched",true);
	    driver=new ChromeDriver();                     //driver is global variable dont use webdriver agian here..
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		String url = r.readDataFrom_Property("url");  // readDataFrom_Property() ..it is a non static method present in ReadDataFromProperty class.
		driver.get(url);
		
	}
	@AfterTest
	public void closeBrouser() {
		Reporter.log("brouser is closed",true);
		driver.close();
	}
	@BeforeMethod
	public void loginmethod() throws IOException {
	
		String UN = r.readDataFrom_Property("username");
		String PW = r.readDataFrom_Property("password");
		
//		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(UN);
//		driver.findElement(By.xpath("//input[@class='textField pwdfield']")).sendKeys(PW);
//		driver.findElement(By.xpath("//div[.='Login ']")).click();
		
		login lp=new login(driver);   //code optimization
		lp.logintoActime(UN, PW); 
		
	}
	@AfterMethod
	public void logout() {
		driver.findElement(By.xpath("//a[.='Logout']")).click();
		
	}
}
