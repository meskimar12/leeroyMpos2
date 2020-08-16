package se.qa.dropdown;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import se.leeroyMpos.qa.BaseTest;

public class DailyInventory {
	
	
BaseTest base;
	
	
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCollectionView/XCUIElementTypeCell[11]") private MobileElement inventory;
	
	


			public DailyInventory() {
						base = new BaseTest();
						PageFactory.initElements(new AppiumFieldDecorator(base.getDriver()), this);
					}
		    

 
				public void dailyInventory() {
					base.click(inventory);
					
				}

			}
