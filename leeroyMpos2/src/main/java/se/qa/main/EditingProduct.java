package se.qa.main;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSTouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import se.leeroyMpos.qa.BaseTest;

public class EditingProduct {
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Jakob Item staffname\"])[2]") private MobileElement selectedProduct;
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther/XCUIElementTypeTextField[1]") private MobileElement txtFieldQty;
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"2\"]") private MobileElement qunatity;
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"21,00*\"]") private MobileElement price;
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Apply\"]") private MobileElement apply;
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCollectionView[1]/XCUIElementTypeCell[10]") private MobileElement option;
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCollectionView[2]/XCUIElementTypeCell[9]") private MobileElement bistro;
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeOther[2]") private MobileElement optionMan;
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Bistro\"])[2]") private MobileElement editItem;
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther/XCUIElementTypeTextField[2]") private MobileElement txtFiledPrice;
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"SG3 - staff facing\"])[2]") private MobileElement editPrice;
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"15% \"]") private MobileElement discount;
	
	
	  BaseTest base;
	
	  
	
			public EditingProduct() {
				
				base = new BaseTest();
				PageFactory.initElements(new AppiumFieldDecorator(base.getDriver()), this);
				
			}
	
	
	      
	
	       
				
	      // editing Product Screen
	       
			public void editItem() {
				  MobileElement ele= editItem;
				    IOSTouchAction touch = new IOSTouchAction(base.getDriver());
				    touch.longPress(LongPressOptions.longPressOptions()
				    		.withElement(ElementOption.element(ele))).release().perform();
			  }
		
			public void editingPriceItem() {
				  MobileElement ele= editPrice;
				    IOSTouchAction touch = new IOSTouchAction(base.getDriver());
				    touch.longPress(LongPressOptions.longPressOptions()
				    		.withElement(ElementOption.element(ele))).release().perform();
			  }
			
			
		
		 // edit quantity of a product
			
	
			public void enterQuantity(String quantity) {
				txtFieldQty.click();
				txtFieldQty.clear();
				base.sendKeys(txtFieldQty, quantity);
				base.getDriver().hideKeyboard();
				base.click(apply);
			}
			
		 // edit price of a product
	

			
			public void enterPrice(String price) {
				
				txtFiledPrice.click();
				txtFiledPrice.clear();
				base.sendKeys(txtFiledPrice, price);
				base.getDriver().hideKeyboard();
				base.click(apply);
			}

        
			
			public String getqunitiy() {
		    	   return base.getAttribute(qunatity,"name");
		       }
			public String getPrice() {
		    	   return base.getAttribute(price,"name");
		       }
				
		
			
			public void addDiscount() {
				
				
				RemoteWebElement parent = (RemoteWebElement)base.getDriver().findElement(By.className("XCUIElementTypeTable"));
			    String parentID = parent.getId();
			    HashMap<String, String> scrollObject = new HashMap<String, String>();
			    scrollObject.put("element", parentID);
			    scrollObject.put("direction", "down");
			    base.getDriver().executeScript("mobile:scroll", scrollObject);
			    
			    base.getDriver().findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"5% rabatt på valfri kaka\"]")).click();
				//base.click(diselected);
			    
			    base.click(apply);
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
}



