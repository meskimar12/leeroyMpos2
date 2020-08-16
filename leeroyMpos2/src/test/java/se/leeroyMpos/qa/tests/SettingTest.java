package se.leeroyMpos.qa.tests;

import org.testng.annotations.Test;

import se.leeroyMpos.qa.BaseTest;
import se.qa.dropdown.Settings;
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

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;

public class SettingTest {
	LoginScreen loginScreen;
	MenuScreen menuScreen;
	BaseTest base;
	InputStream data;
	JSONObject loginUsers;
	TestUtils utils;
	Settings settings;
	
	//HashMap<String, String>strings;

	
	
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
	      
		
		/*  @AfterClass
		  public void afterClass() {
	
			  base.quitDriver();
			 
		  }*/
		  
		  @BeforeMethod
		  public void beforeMethod(Method m) {
			 settings = new Settings();
			 loginScreen = new LoginScreen();
			  menuScreen = new MenuScreen();
			 
			  System.out.println("" + "***** Starting Test" + m.getName() + "********" +  "\n");
		  }
		  

		  
		
		  @AfterMethod
		  public void afterMethod() {
			  
			  settings = new Settings();
		  }
		  
		  
			  @Test(priority=0)
			  public void disableOnlineOrder() throws InterruptedException{
				  
				  loginScreen.login(loginUsers.getJSONObject("validPin").getString("pin"));
				 
				  menuScreen.dropDownMenu();
				    
				  settings.dropdownSetting();
				  
				  settings.SwitchButton();;
				  
				//  settings.cancel();
				  
				 
	        	   
       		     Assert.assertTrue(settings.isDisplayed(), "the icon is displayed");
					  
				
			    
				  
			  		}
			  
			/*  @Test(priority=2)
			  public void enabledOnlineOrder(){
					   
					     
				  
				  
						  
				  System.out.println("Mobile icon is nots displayed on MenuScreen");  
			  }*/
			  
			  
		}