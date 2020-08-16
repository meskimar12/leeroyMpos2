package se.leeroyMpos.qa.tests;

import org.testng.annotations.Test;

import se.leeroyMpos.qa.BaseTest;
import se.qa.dropdown.Refund;
import se.qa.dropdown.Settings;
import se.qa.login.LoginScreen;
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
import org.testng.annotations.AfterClass;

public class RefundTest {

	
	LoginScreen loginScreen;
	MenuScreen menuScreen;
	BaseTest base;
	InputStream data;
	JSONObject loginUsers;
	TestUtils utils;
	Settings settings;
	Refund refund;
	

	
	
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
			  refund = new Refund();
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
			  public void refundModeIsEnabled(){
				  
				 loginScreen.login(loginUsers.getJSONObject("validPin").getString("pin"));
				 
				 refund.addItem(); 
				 menuScreen.dropDownMenu();
				 refund.refundTap();
				 refund.isEnabled();
				 
				 
				 
				if(refund.isEnabled()) {
					
					Assert.assertTrue(refund.isEnabled());
					System.out.println("Refund Mode is Enabled");
					
				}else {
					System.out.println("Refund Mode is  not Enabled");
				}
					        
				  
			  		}
			  
			  
			  
			  @Test(priority=1)
			  public void discountIsDisplayed(){
				  
				 refund.closeRefund();
				 
				 refund.selectDiscount();
				 
				 
					
					       
       		     Assert.assertTrue(refund.isDisplayed(), "discount is applied" );
       		     
       		     System.out.println("Discount is applied");
					  
			  }
			  
			  
			  
			  
			  
			/*  @Test(priority=2)
			  public void enabledOnlineOrder(){
					   
					     
				  
				  
						  
				  System.out.println("Mobile icon is nots displayed on MenuScreen");  
			  }*/
			  
			  
		}


