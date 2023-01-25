
//generic library is a package which will be having all generic librararies and all the methods

package com.crm.Actitime.GenericLibrary;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromProperty {
	
	 public String readDataFrom_Property(String key) throws IOException {
		 
		FileInputStream file =new FileInputStream("./TestData/commonData.property"); 
		Properties p=new Properties();
		p.load(file);
		String value = p.getProperty(key);
		return value;
	
	 }

}
