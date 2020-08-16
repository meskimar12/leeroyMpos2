package se.leeroyMpos.qa.tests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.rcarz.jiraclient.BasicCredentials;
import net.rcarz.jiraclient.Field;
import net.rcarz.jiraclient.Issue;
import net.rcarz.jiraclient.JiraClient;
import net.rcarz.jiraclient.JiraException;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;
import org.testng.ITestResult;

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





public class LoginTest {
	
	LoginScreen loginScreen;
	MenuScreen menuScreen;
	BaseTest base;
	InputStream data;
	JSONObject loginUsers;
	TestUtils utils;
	CartSection cartSection;
	
	
	
	
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
	      
		
		 /* @AfterClass
		  public void afterClass() {
	
			  base.quitDriver();
			 
		  }*/
		  
		  @BeforeMethod
		  public void beforeMethod(Method m) {
			 loginScreen = new LoginScreen();
			 
			  System.out.println("" + "*****  Starting Test  " + m.getName() + " " + "********" +  "\n");
		  }
		  

		  
		
		  @AfterMethod
		  public void afterMethod(ITestResult result) throws JiraException {
			  
			  if(result.getStatus()==ITestResult.FAILURE) {
				  
				 BasicCredentials creds = new BasicCredentials("user","password"); 
				 JiraClient jira = new JiraClient("jira url",creds);
				 Issue issueName = jira.createIssue("Mpos", "BUG").field(Field.SUMMARY, result.getMethod().getMethodName()+ "is failed due to:)"
			 + result.getThrowable().toString()).field(Field.DESCRIPTION, "get the description").execute();
				  
				 System.out.println(issueName.getKey());
			  }
			  loginScreen = new LoginScreen();
		  }
		  
		  
			  @Test(priority=1)
			  public void invalidPinNumber(){
					   
					      loginScreen.enterPin(loginUsers.getJSONObject("invalidPin").getString("pin"));
						  loginScreen.tapUnlokBtn();
						  
						  
						  String actualErrTxt = loginScreen.getErrTxt();	  
						  String expectedErrTxt = base.getStrings().get( "err_incorrect_pin" );
						  
						  System.out.println(" Actual error txt -" + actualErrTxt + "" +  " expected error txt - " + expectedErrTxt);
						  
						  Assert.assertEquals(actualErrTxt, expectedErrTxt);
					  
			  }  
		      @Test(priority=2)
			  public void validPinNumber() {
						  
					 loginScreen.tapokBtn();
					 loginScreen.delete();
					 loginScreen.enterPin(loginUsers.getJSONObject("validPin").getString("pin"));
							  //loginScreen.tapUnlokBtn();
							  
					 menuScreen = loginScreen.tapUnlokBtn();
							  
							  
				     String actualDevicRgesterName = menuScreen.getName();	  
					 String expectedDevicRgesterName = base.getStrings().get("device_name");
							  
		             System.out.println("Actual Screen  - " + actualDevicRgesterName +  " Expected Screen - " + expectedDevicRgesterName);
							  
					Assert.assertEquals(actualDevicRgesterName, expectedDevicRgesterName);
							
						  
						  
					  }	 
				  
				  
		  	  
			  @Test(priority=3)
			   public void addToCart() {
				  
				  
				    try {
				    	
				    	menuScreen.addBtn();
				    }catch(Exception e) {
				    	
				    	Assert.assertTrue(false, " element is not foundExpected condition failed");
				    	
				    }
						 // menuScreen.foodBtn();
						  
						  
						 // menuScreen.editItem();
						/*  menuScreen.getItemName();
						  
		                 		menu		  
						  
						  String actualItemName = menuScreen.getItemName();	  
						  String expectedItemName = base.getStrings().get("item_name");
						  
						  System.out.println("Actual SelectedProduct  - " + actualItemName +  " Expected SelectedProduct - " + expectedItemName);
						  
						  Assert.assertEquals(actualItemName, expectedItemName);*/
				  
			  }

			  @Test(priority=3)
			   public void unlock() {
				  
				  
				  
				 menuScreen.tapunlock();
						   
						  
				String actualItemName = menuScreen.getLogin();	  
				String expectedItemName = base.getStrings().get("unlock");
						  
				System.out.println("Actual Screen  - " + actualItemName +  " Expected Screen - " + expectedItemName);
						  
			    Assert.assertEquals(actualItemName, expectedItemName);
				  
			  }
			  
		  
			  
			  
		  }
		  


