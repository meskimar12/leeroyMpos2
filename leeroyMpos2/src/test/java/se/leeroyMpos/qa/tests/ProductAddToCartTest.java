package se.leeroyMpos.qa.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.beust.jcommander.Strings;

import se.leeroyMpos.qa.BaseTest;
import se.qa.login.LoginScreen;
import se.qa.main.CartSection;
import se.qa.main.MenuScreen;
import se.qa.utils.TestUtils;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class ProductAddToCartTest {
	LoginScreen loginScreen;
	MenuScreen menuScreen;
	BaseTest base;
	InputStream data;
	JSONObject loginUsers;
	TestUtils utils;
	CartSection cartSection;
	JSONObject order;
	
	
	
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
           order = new JSONObject(tokener);
          }catch(Exception e) {
        	  e.printStackTrace();
        	  throw e;
        	  
          }finally {
        	  if(data!=null) {
        		  data.close();
        	  }
        	  
          }
		  }
	      
		
		/*  @AfterClass
		  public void afterClass() {
	
			  base.quitDriver();
			 
		  }*/
		  
		  @BeforeMethod
		  public void beforeMethod(Method m) {
			  loginScreen = new LoginScreen();
			  menuScreen =  new MenuScreen();
			  System.out.println("" + "*****  Starting Test  " + m.getName() + " " + "********" +  "\n");
		  }
		  
		  
		  
		  @AfterMethod
		  public void afterMethod() {
			  loginScreen = new LoginScreen();
			  
		  }
		  
		  @Test(priority=0)
		  public void addToCart() throws InterruptedException{
			  
			   SoftAssert softAssert = new SoftAssert();
			  
			  loginScreen.login(loginUsers.getJSONObject("validPin").getString("pin"));
			  
			  menuScreen.addBtn();
			  
			  String ProductName = menuScreen.getItemName();
			  softAssert.assertEquals( ProductName,  base.getStrings().get("k"));
			  
			  String Quantity = menuScreen.getItemName();
			  softAssert.assertEquals( Quantity,  base.getStrings().get("k"));
			  
			  String Price = menuScreen.getItemName();
			  softAssert.assertEquals( Price,  base.getStrings().get("k"));
			  
			  
			  
			 
			  
			/* Map<String, String> map = new HashMap<>();
			 map.put(menuScreen.addBtn(), "menuScreen.addPrice()");
			 map.put("menuScreen.addBtn()", "");
			 map.put("menuScreen.addBtn()", ""); 
			 
			 Map<String, String> expected = new HashMap<>();
			 expected.put("menuScreen.addBtn()", "");
			 expected.put("menuScreen.addBtn()", "");
			 expected.put("menuScreen.addBtn()", ""); 
			
			 
			softAssert.assertEquals(map, expected);*/
			 
		       
		  }
		  
		
		  
		  
}
