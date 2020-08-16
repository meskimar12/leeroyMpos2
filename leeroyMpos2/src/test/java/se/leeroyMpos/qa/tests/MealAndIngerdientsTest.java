package se.leeroyMpos.qa.tests;

import org.testng.annotations.Test;

import se.leeroyMpos.qa.BaseTest;
import se.qa.login.LoginScreen;
import se.qa.main.CartSection;
import se.qa.main.EditingProduct;
import se.qa.main.FoodDisplayMenu;
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

public class MealAndIngerdientsTest {
	
	LoginScreen loginScreen;
	BaseTest base;
	InputStream data;
	JSONObject loginUsers;
	TestUtils utils;
	CartSection cartSection;
	EditingProduct editingProduct;
	MenuScreen menuScreen;
	FoodDisplayMenu foodDisplayMenu;
	
	
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
				  loginScreen = new LoginScreen();
				  menuScreen = new MenuScreen();
				  foodDisplayMenu= new FoodDisplayMenu();
				  System.out.println("" + "***** Starting Test" + m.getName() + "********" +  "\n");
			  }
			  
		
			  
			
			  @AfterMethod
			  public void afterMethod() {
				 
			  }
			  
		/*	 
		     Verify that 'Ingredients' tab is visible in Main product screen when product
		     has Option Group Expanded by Default and Recipe attached. Single Tap on Product in the cart
		 */
			  @Test(priority=0)
			  public void ingredientsIsDisplayed(){
				  
					 loginScreen.login(loginUsers.getJSONObject("validPin").getString("pin"));
					 
					 
					 foodDisplayMenu.productWithoption();
					 
					if(foodDisplayMenu.ingredientsIsDisplay()) {
						
						Assert.assertTrue(foodDisplayMenu.ingredientsIsDisplay());
						System.out.println("Ingredient tab is displayed");
						
					}else {
						System.out.println("Ingredient tab is  not displayed");
					}
						         
					 
					 
					
					}
						        
			 
			  /*   Verify that 'Ingredients'  can be (added)selected and is visible under the product in
				    the cart
				 */  
			  @Test(priority=1)
			  public void selectingIngridient() {
				  
			  }
			  
			  
			  /*   Verify that 'Ingredients'  can be (removed)deselected and is visible under the product in
			    the cart
			 */  
			  @Test(priority=2)
			  public void deselectingIngridientw() {
				  
			  }
			  
			  
			  /*	 
			     Verify that 'Meal' tab is visible in Main product screen when meal are configured in cloud. 
			     Single Tap on Meal will be add to the Cart
			 */
			  @Test(priority=3)
			  public void visblityOfMeal() {
				  
			  }
  
  
  
  // product SG2 
  
  //   only (//XCUIElementTypeStaticText[@name="SG2"])[2]
  // Kanelbulle2Kanelbulle2Kanelbulle2Kanelbulle2 accessibility id
  //XCUIElementTypeStaticText[@name="Kanelbulle2Kanelbulle2Kanelbulle2Kanelbulle2"]
  
   //XCUIElementTypeStaticText[@name="Kanelfyllning"] deselected item.
  
    //XCUIElementTypeStaticText[@name="Ingredients"] ingredients tab
  
  // (//XCUIElementTypeStaticText[@name="jakob test OG"])[2] option group
  
   //XCUIElementTypeButton[@name="Add 42 kr"]  add price



}

