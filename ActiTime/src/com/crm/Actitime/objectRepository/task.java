// pom is also known as object repository 
package com.crm.Actitime.objectRepository;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.Actitime.GenericLibrary.Readdatafromxlsx;

public class task {
	
	@FindBy (xpath = "//div[.='Add New']")
	private WebElement addNew;
	
	@FindBy (xpath = "//div[.='+ New Customer']")
	private WebElement  newCustomer;
	
	@FindBy (xpath = "(//input[@placeholder='Enter Customer Name'])[2]")
	private WebElement ECname;
	
	@FindBy (xpath = "//textarea[@placeholder='Enter Customer Description']")
	private WebElement description;
	
	@FindBy (xpath = "(//div[@class='dropdownButton'])[15]")
	private WebElement selCustomer;
	
	@FindBy (xpath = "(//div[@class='itemRow cpItemRow '])[2]")
	private WebElement ourCompany;
	
	@FindBy (xpath ="//div[.='Create Customer']")
	private WebElement Creatbtn;

	//initialisation
	public task(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

//utilisation
	
	public WebElement getAddNew() {
		return addNew;
	}

	public WebElement getNewCustomer() {
		return newCustomer;
	}

	public WebElement getECname() {
		return ECname;
	}

	public WebElement getDescription() {
		return description;
	}

	public WebElement getSelCustomer() {
		return selCustomer;
	}

	public WebElement getOurCompany() {
		return ourCompany;
	}

	public WebElement getCreatbtn() {
		return Creatbtn;
	}
	
//business logic
	public void  addNewb() throws EncryptedDocumentException, IOException, InterruptedException {
		addNew.click();
		newCustomer.click();
		
		Readdatafromxlsx rd=new Readdatafromxlsx(); 
		String ecn = rd.readDatafromExcel("Sheet1", 1, 1);
		ECname.sendKeys(ecn);
		String dcn=rd.readDatafromExcel("Sheet1", 1, 2);
		description.sendKeys(dcn);
		selCustomer.click();
		Thread.sleep(2000);
		ourCompany.click();
		Thread.sleep(2000);
		Creatbtn.click();
	}	
	
}
