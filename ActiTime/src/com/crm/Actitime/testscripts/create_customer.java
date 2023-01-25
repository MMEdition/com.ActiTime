package com.crm.Actitime.testscripts;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.Actitime.GenericLibrary.baseClass;
import com.crm.Actitime.GenericLibrary.listner_implimentation;
import com.crm.Actitime.objectRepository.home;
import com.crm.Actitime.objectRepository.task;
@Listeners(listner_implimentation.class)     //annotation for take screenshot
public class create_customer extends baseClass {

	@Test
	public void createCustomer() throws EncryptedDocumentException, IOException, InterruptedException  {
		
		home h=new home(driver);
		h.getTasklink().click();
		
		task t=new task(driver);
		t.addNewb();
		
	}	
}
