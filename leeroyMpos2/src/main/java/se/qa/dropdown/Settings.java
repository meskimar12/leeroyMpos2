package se.qa.dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSTouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import se.leeroyMpos.qa.BaseTest;
import se.qa.main.MenuScreen;

public class Settings {
	
	
          BaseTest base;
	      MenuScreen menuScreen;
	
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCollectionView/XCUIElementTypeCell[8]") private MobileElement settings;
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"cancel\"]") private MobileElement cancel;
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[2]/XCUIElementTypeSwitch") private MobileElement toggle;
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Turn on/off online orders\"]") private MobileElement icon;
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Ok\"]") private MobileElement ok;
	

	
	//"//XCUIElementTypeOther[2]/XCUIElementTypeSwitch"

			public Settings() {
						base = new BaseTest();
						PageFactory.initElements(new AppiumFieldDecorator(base.getDriver()), this);
					}
			
			
			
			
			
			  public void dropdownSetting() {
				  
				  base.click(settings);
				  
			       }
			  
			  
			  
			  
			  public void SwitchButton() {
				  
				 base.click(ok);
				    
				 MobileElement element= toggle;
			
			     IOSTouchAction tap = new IOSTouchAction(base.getDriver());
						
				 tap.tap(TapOptions.tapOptions().withElement(ElementOption.element(element))).perform();
						    
					 
			        }
			  
			 
			  
			public String getValue() {
				
				return base.getAttribute(icon, "value");
				
			}
			  
			  
			public boolean isDisplayed() {
				try {
					if (icon.isDisplayed()){
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
			
			  
			  public void cancel() {
				  base.click(cancel);
				  
				  
			  }
}





