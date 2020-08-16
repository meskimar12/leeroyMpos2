package se.leeroyMpos.qa.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import se.leeroyMpos.qa.BaseTest;
import se.qa.login.LoginScreen;
import se.qa.main.CartSection;
import se.qa.main.EditingProduct;
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
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class EditingProductsTest {
	
	LoginScreen loginScreen;
	BaseTest base;
	InputStream data;
	JSONObject loginUsers;
	TestUtils utils;
	CartSection cartSection;
	EditingProduct editingProduct;
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
		     loginUsers= new JSONObject(tokener);
		     }catch(Exception e) {
		   	  e.printStackTrace();
		   	  throw e;
		   	  
		     }finally {
		   	  if(data!=null) {
		   		  data.close();
		   	  }
		   	  
		     }
		     /*  @AfterClass
			  public void afterClass() {
		
				  base.quitDriver();
				 
			  }*/
			 }
			 
			  
			  @BeforeMethod
			  public void beforeMethod(Method m) {
				  editingProduct = new EditingProduct();
				  loginScreen = new LoginScreen();
				  menuScreen = new MenuScreen();
				  System.out.println("" + "***** Starting Test" + m.getName() + "********" +  "\n");
			  }
			  
		
			  
			
			  @AfterMethod
			  public void afterMethod() {
				  editingProduct = new EditingProduct();
			  }
			 
						  	 
			  
             // editing one product quantity
			  
		     @Test(priority=0)
			  public void editingQuanitity() throws InterruptedException{
		    	 
		    	 loginScreen.login(loginUsers.getJSONObject("validPin").getString("pin"));
				 
				  
		
				  menuScreen.addBtn(); 
				  editingProduct.editItem();
				
			      editingProduct.enterQuantity(loginUsers.getJSONObject("editQuantity").getString("quantity"));
				 
						  
					try {
						
						  String editedQuanitity = editingProduct.getqunitiy();	  
						  String expectedQuantity = base.getStrings().get("quanitity");
								  
			              System.out.println(" Edited Quantity -" + editedQuanitity + "" +  " expected quantity - " + expectedQuantity);
								  
						  Assert.assertEquals(editedQuanitity, expectedQuantity);
						
					}catch(Exception e) {
					
						System.out.println("Exception! quanityity does not match" );
					}
				 			  
			  
			  }	
		      
	           // Editing price of product 
				 @Test(priority=1)
				  public void editingPrice() throws InterruptedException {
					 
					     
					          menuScreen.openPriceProduct();
					  
					          editingProduct.editingPriceItem();;
						  
						      
						      editingProduct.enterPrice(loginUsers.getJSONObject("editPrice").getString("price"));
							 
							  
							  
							  String editedPrice = editingProduct.getPrice();	  
							  String expectedPrice = base.getStrings().get( "price" );
							  
							  System.out.println(" Edited price -" + editedPrice + "" +  " expected price - " + expectedPrice);
							  
							  Assert.assertEquals(editedPrice, expectedPrice);		  
				  
				  }	
			  
			  // editing quantity while selecting the same product twice. 
			  // Adding the product from the menu should  also increase the quantity
			  
			  
		        @Test(priority=2)
			  public void discountIsDisplayed() throws InterruptedException{
				  
				 menuScreen.addBtn();
				 
				 editingProduct.editingPriceItem();
				 
				 editingProduct.addDiscount();
				 
				 
					
					       
       		     Assert.assertTrue(editingProduct.isDisplayed(), "discount is applied" );
       		     
       		     System.out.println("Discount is applied");
					  
			  }
			  
			  
			  
			  
			 

			  
			  
			  
			  
			  
	  }
