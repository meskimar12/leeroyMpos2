package se.qa.main;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSTouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import se.leeroyMpos.qa.BaseTest;

public class CartSection {
	
	
	
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Bananpaj\"])[2]") private MobileElement menu;
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"clear\"]") private MobileElement clear;
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"discount\"]") private MobileElement discount;
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Take away\"]") private MobileElement takeAway;
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Eat in\"]") private MobileElement eatIn;
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"5% rabatt\"]") private MobileElement addDiscount;
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Charge\"]") private MobileElement charge;
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Card\"]") private MobileElement card;
	@iOSXCUITFindBy(iOSNsPredicate = "//XCUIElementTypeButton[@name=\"Card\"]") private MobileElement scroolmethod;
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Card\"]") private MobileElement value;
	
	
	//value to be changed 
	//XCUIElementTypeButton[@name="Cancel"]
	//XCUIElementTypeButton[@name="Ok"]
	
	//XCUIElementTypeStaticText[@name="Total:"]
	//XCUIElementTypeStaticText[@name="Discount:"]
	
			BaseTest base;
			
			public CartSection() {
			    base = new BaseTest();
				PageFactory.initElements(new AppiumFieldDecorator(base.getDriver()), this);
			}
			
			
		
		          
		
			public String getItemName() {
				return base.getAttribute(menu, "name");
			}
			
			
		
			
			//  editing quantity/price/discount of an item
			public void edit() {
				
				MobileElement ele= base.getDriver().findElement(By.xpath("(//XCUIElementTypeStaticText[@name=\"Bananpaj\"])[2]"));
			    IOSTouchAction touch = new IOSTouchAction(base.getDriver());
			    touch.longPress(LongPressOptions.longPressOptions()
			    		.withElement(ElementOption.element(ele))).release().perform();
				
			         }
			
			
			
			// add whole discount to the items add to the cart
			public void addDiscountToProduct() {
				
				base.iOSScroll();
				base.click(addDiscount);
				
			       }
			
			public boolean isDisplayed() {
				try {
					if (discount.isDisplayed()){
						  return  true;
					  }
					  else {
					
					return false;
					  }
					}catch(Exception e) {
						
						e.getMessage();
			        	  throw e;
					}
				  
			       }
			
			
			// Select Dining Type Eat In/ Take Away  
			
			public boolean isSelected() {
				try {
					if (eatIn.isSelected()){
						  return  true;
					  }
					  else {
					
					return false;
					  }
					}catch(Exception e) {
						
						e.getMessage();
			        	  throw e;
					}
				  
			       }
			
			  // Identifying Members both through scan and  Identification number
			  public void identifyeMembers() {
				  
			  }
			  
			  // Paying with card direct from the cart
			  public void payWithCard() {
				  
			  }
			  
			
				// Remove All Items from the  cart 
				public void removeCartItem() {
					base.click(clear);
					
				}
				
				// Add or remove Product in the cart
				public void swipAction() {
					
				}
				
				// 
				
				public String getValue() {
					return base.getAttribute(value, "name");
					
				}
	
	
}
