package se.leeroyMpos.qa.tests;

import org.testng.annotations.Test;

import se.leeroyMpos.qa.BaseTest;
import se.qa.login.LoginScreen;
import se.qa.register.AllDoneScreen;
import se.qa.register.IpScreen;
import se.qa.register.RegistrationCompletedScreen;
import se.qa.register.RegistrationUnitScreen;
import se.qa.register.SelectPrinterScreen;
import se.qa.utils.TestUtils;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.InputStream;
import java.lang.reflect.Method;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;


public class RegisterTest {
	RegistrationUnitScreen registrationUnitScreen;
	RegistrationCompletedScreen registrationCompletedScreen;
	BaseTest base;
	InputStream data;
	JSONObject loginUsers;
	TestUtils utils;
	SelectPrinterScreen selectPrinterScreen;
	AllDoneScreen allDoneScreen;
	IpScreen ipScreen;
	LoginScreen loginScreen;
   
	

	
	
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
			  registrationUnitScreen = new RegistrationUnitScreen();
			  selectPrinterScreen = new SelectPrinterScreen();
			  allDoneScreen = new AllDoneScreen();
			  ipScreen = new IpScreen();
			  
			  System.out.println("" + "***** Starting Test" + m.getName() + "********"  +   "\n");
		       }
		
		  @AfterMethod
		  public void afterMethod() {
			  registrationUnitScreen = new RegistrationUnitScreen();
			 //base.getDriver().resetApp();
			  
		      }
		  
		  /*	 
		     Verify that Registering Device Given the user has  Installed MPOS App and has InvalidSecretKey 
		 */
		  @Test(priority=1)
			  public void invalidSecretKey(){
					   
			  registrationUnitScreen.enterSecretKey(loginUsers.getJSONObject("invalidSecretKey").getString("key"));
			  registrationUnitScreen.tapSendBtn();
				 
				  
				  String actualErrTxt = registrationUnitScreen.getErrTxt();	  
				  String expectedErrTxt = base.getStrings().get( "err_registration" );
				  
		         System.out.println(" Actual error txt -" + actualErrTxt + "" +  " expected error txt - " + expectedErrTxt);
		         
		         Assert.assertEquals(actualErrTxt, expectedErrTxt);
				  
			  
			  }
			  
		  /*	 
		     Verify that Registering Device Given the user has  Installed MPOS App and has validSecretKey 
		 */
		  @Test(priority=2)
		  public void validSecretKey() {
			  
			  registrationUnitScreen.tapokBtn();
			  registrationUnitScreen.delete();
			  registrationUnitScreen.enterSecretKey(loginUsers.getJSONObject("validSecretKey").getString("key"));
			  //loginScreen.tapUnlokBtn(); 
			  registrationCompletedScreen = registrationUnitScreen.tapSendBtn();
			  
				  String actualMessage = registrationCompletedScreen.getName();	  
				  String expectedMessage = base.getStrings().get("succes_message");
				  
				  System.out.println("Actual Screen  - " + actualMessage +  " Expected Screen - " + expectedMessage);
				  
				  Assert.assertEquals(actualMessage, expectedMessage);
			  
		      }
		  

	      @Test(priority=3)
		  public void CompleteRegistration() throws InterruptedException   {
			   		  
			   registrationCompletedScreen.tapContinueBtn();
			   
			   Thread.sleep(1000);
			   registrationCompletedScreen.tapBtn();  
       
			  
			  String actualScreen = registrationCompletedScreen.getScreenName();
			  String expectedScreen = base.getStrings().get("select_ printer");
			  
			  System.out.println("Actual Screen  - " + actualScreen +  " Expected Screen - " + expectedScreen);
			  
			  Assert.assertEquals(actualScreen, expectedScreen);
			  
		  }
		 		 
			 @Test(priority=4)
			  public void SelectPrinter() throws InterruptedException {
			  
			 //selectPrinterScreen.tapBtn();
			  
			  
			  ipScreen = selectPrinterScreen.tapSkipBtn();
			  
			  String actualScreen = ipScreen.getName();
			  String expectedScreen = base.getStrings().get("ip_check");
			  
			  System.out.println("Actual Screen  - " + actualScreen +  "\n" + " Expected Screen - " + expectedScreen);
			  
			  Assert.assertEquals(actualScreen, expectedScreen);
			  
				  
			  }
			 @Test(priority=5)
			  public void ipCheck() {
				  
				  
				  allDoneScreen = ipScreen.tapContinueBtn();
				  
				  String actualScreen = allDoneScreen.getName();
				  String expectedScreen = base.getStrings().get("allDone");
				  
				  System.out.println("Actual Screen  - " + actualScreen +  " Expected Screen - " + expectedScreen);
				  
				  Assert.assertEquals(actualScreen, expectedScreen);
				  
			  }
			  @Test(priority=6)
			  public void allDone() {
				  
				  
		           loginScreen = allDoneScreen.tapLoginBtn();
				  
				  String actualScreen = loginScreen.getName();
				  String expectedScreen = base.getStrings().get("login");
				  
				  System.out.println("Actual Screen  - " + actualScreen +  " Expected Screen - " + expectedScreen);
				  
				  Assert.assertEquals(actualScreen, expectedScreen);
				  
	
	
	}
}