// pom is also known as object repository 
package com.crm.Actitime.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class home {
	
//1  decleration
	
	@FindBy (xpath = "//a[@class='content selected tt']")
	private WebElement time_Track;
	
	@FindBy (xpath = "//div[@id='container_tasks']")
	private WebElement tasklink;
	
	@FindBy (xpath = "//a[@class='content reports']")
	private WebElement  reportslink;
	
	@FindBy (xpath = "//a[@class='content users']")
	private WebElement  userslink;
	
	@FindBy (xpath = "//a[.='Logout']")
	private WebElement  logoutlink;
	
//2. initialisation
	
	public home(WebDriver driver) {       	 // constructor 
		PageFactory.initElements(driver, this);
		
	}
	
//3. utilisation
	
	public WebElement getTime_Track() {
		return time_Track;
	}

	public WebElement getTasklink() {
		return tasklink;
	}

	public WebElement getReportslink() {
		return reportslink;
	}

	public WebElement getUserslink() {
		return userslink;
	}

	public WebElement getLogoutlink() {
		return logoutlink;
	}

//business logic
	public void clickOnTasktab() {      // it is non static method to perform click action on tasklink.
		tasklink.click();
		
	}	
	
}
