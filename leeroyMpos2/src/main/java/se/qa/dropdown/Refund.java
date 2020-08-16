package se.qa.dropdown;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import se.leeroyMpos.qa.BaseTest;

public class Refund {
	
	
		BaseTest base;
		
		
		
		@iOSXCUITFindBy(xpath = "//XCUIElementTypeCollectionView/XCUIElementTypeCell[5]") private MobileElement refund;
		@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"close\"]") private MobileElement close;
		@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Refund mode\"]") private MobileElement refundMode;
		@iOSXCUITFindBy(xpath = "//XCUIElementTypeCollectionView[2]/XCUIElementTypeCell[1]") private MobileElement coca;
		@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"discount\"]") private MobileElement discount;
		@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"25% \"]") private MobileElement diselected;
		
		//XCUIElementTypeStaticText[@name="Refund mode"]
		
	
		public Refund() {
					base = new BaseTest();
					PageFactory.initElements(new AppiumFieldDecorator(base.getDriver()), this);
				}
			    
				
				
		
			
	           // to be deleted when add to cart is done
		
		        public void addItem() {
		        	base.click(coca);
		        	
		        }
		
		       
				  public void refundTap() {
					  
					  base.click(refund);
				  }
				
				
				
				public boolean isEnabled() {
					try {
						if (refundMode.isEnabled()){
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
				
				public void selectDiscount() {
					base.click(discount);
					
					RemoteWebElement parent = (RemoteWebElement)base.getDriver().findElement(By.className("XCUIElementTypeTable"));
				    String parentID = parent.getId();
				    HashMap<String, String> scrollObject = new HashMap<String, String>();
				    scrollObject.put("element", parentID);
				    scrollObject.put("direction", "down");
				    base.getDriver().executeScript("mobile:scroll", scrollObject);
				    
				    base.getDriver().findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"3% rabatt\"]")).click();
					//base.click(diselected);
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
				
				
				
				public void closeRefund() {
					base.click(close);
				}
     
				  
				 
		}
