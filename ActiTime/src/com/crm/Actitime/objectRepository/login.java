// pom is also known as object repository 
package com.crm.Actitime.objectRepository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.Actitime.GenericLibrary.ReadDataFromProperty;

public class login {

//decleration	
	@FindBy(id="username")
	private WebElement untbx;
	
	@FindBy(name="pwd")
	private WebElement pwdx;
	
	@FindBy (xpath = "//div[.='Login ']")
	private WebElement lgnbtn;
	
//initialisation	
	public login(WebDriver driver) {           // parameterised constructor
		PageFactory.initElements(driver, this);  
		
	}

//utilisation
	public WebElement getUntbx() {       //getters method
		return untbx;
	}


	public WebElement getPwdx() {
		return pwdx;
	}


	public WebElement getLgnbtn() {
		return lgnbtn;
	}

//business logic
	public void logintoActime(String UN,String PW) throws IOException {     // non static method ...//we create parameterised method 
		
		//create object for  ReadDataFromProperty class to access non static method .
		ReadDataFromProperty r=new ReadDataFromProperty(); 
		untbx.sendKeys(UN);
		pwdx.sendKeys(PW);
		lgnbtn.click();
		
	}	
}
