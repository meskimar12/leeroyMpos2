package se.leeroyMpos.qa.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import se.leeroyMpos.qa.BaseTest;
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
import org.testng.annotations.AfterClass;

				public class CartSectionTest {
					
					BaseTest base;
					InputStream data;
					JSONObject loginUsers;
					TestUtils utils;
					CartSection cartSection;
					MenuScreen menuScreen;
					
					
					
					
					
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
				     
					
					  @AfterClass
					  public void afterClass() {
				
						  base.quitDriver();
						 
					  }
					  
					  @BeforeMethod
					  public void beforeMethod(Method m) {
						  cartSection = new CartSection();
						  menuScreen = new MenuScreen();
						 
						  System.out.println("" + "***** Starting Test" + m.getName() + "********" +  "\n");
					  }
					
					  @AfterMethod
					  public void afterMethod() {
						  cartSection = new CartSection();
				  
				 
				  
			        }
					  
					  @Test(priority=0)
					   public void addToCart() throws InterruptedException {
						  
						  try {
						    	
						    	menuScreen.addBtn();
						    }catch(Exception e) {
						    	
						    	Assert.assertTrue(false, " element is not foundExpected condition failed");
						    	
						    }
					  }
					  
					  @Test(priority=1)
					   public void addcomment(){
						  	
					  }
					  
					  
					  @Test(priority=2)
					   public void discountIsDisplayed(){
						  	
							       
		       		     Assert.assertTrue(cartSection.isDisplayed(), "discount is applied" );
		       		     
		       		     System.out.println("Discount is applied");
							  
					  }
					  
					  @Test(priority=3)
					   public void diningType() {
						  
						  
						  Assert.assertTrue(cartSection.isSelected());
						  
					     }
	  
	 		  
	
					  @Test(priority=4)
					   public void itemCleardFromCart(){
						  	
							       
		       		     
							  
					  }
					  
					  
					  
					  
					 
			}
