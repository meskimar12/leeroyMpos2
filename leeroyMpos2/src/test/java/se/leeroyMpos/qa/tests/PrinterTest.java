package se.leeroyMpos.qa.tests;

import org.testng.annotations.Test;

import se.leeroyMpos.qa.BaseTest;
import se.qa.register.IpScreen;
import se.qa.register.SelectPrinterScreen;
import se.qa.utils.TestUtils;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.InputStream;
import java.lang.reflect.Method;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class PrinterTest {
	

	
	BaseTest base;
	InputStream data;
	JSONObject loginUsers;
	TestUtils utils;
	SelectPrinterScreen selectPrinterScreen;
	IpScreen ipScreen;
	
	
	@Parameters({"applicationName","platformVersion","deviceName"})
	  @BeforeClass
	  public void startup(String applicationName,	String platformVersion,
			  String deviceName)throws Exception{
    base = new BaseTest();
    base.initializeDriver(applicationName, platformVersion, deviceName);
    try {
    String dataFileName = "data/loginUsers.json";
    data = getClass().getClassLoader().getResourceAsStream(dataFileName);
    JSONTokener tokener = new JSONTokener(data);
    loginUsers = new JSONObject(tokener);
    }catch(Exception e) {
  	  e.printStackTrace();
  	  throw e;
  	  
    }finally {
  	  if(data!=null) {
  		  data.close();
  	  }
  	  
    }
	  }
    
	
	  @AfterClass
	  public void afterClass() {

		  base.quitDriver();
		 
	  }
	  
	  @BeforeMethod
	  public void beforeMethod(Method m) {
		  selectPrinterScreen = new SelectPrinterScreen();
		 
		  System.out.println("" + "***** Starting Test" + m.getName() + "********" +  "\n");
	  }
	  
	  
	
	  @AfterMethod
	  public void afterMethod() {
		  selectPrinterScreen = new SelectPrinterScreen();
	  }
	  
	  
	  @Test
	  public void SelectPrinter()  {
	  
		//  Thread.sleep(4000);
		  
		  
		 //selectPrinterScreen.tapSkipBtn();
		 
		 selectPrinterScreen.tapBtn();
		  
		  
		  ipScreen = selectPrinterScreen.tapSkipBtn();
		  
		  String actualScreen = ipScreen.getName();
		  String expectedScreen = base.getStrings().get("ip_check");
		  
		  System.out.println("Actual Screen  - " + actualScreen +  " Expected Screen - " + expectedScreen);
		  
		  Assert.assertEquals(actualScreen, expectedScreen);
		  
	  }

}
