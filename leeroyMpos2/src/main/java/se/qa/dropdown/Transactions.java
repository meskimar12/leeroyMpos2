package se.qa.dropdown;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import se.leeroyMpos.qa.BaseTest;

public class Transactions {
	
	
	
	BaseTest base;
	
	
	
		@iOSXCUITFindBy(xpath = "//XCUIElementTypeCollectionView/XCUIElementTypeCell[1]") private MobileElement transaction;
		@iOSXCUITFindBy(xpath = "//XCUIElementTypeSearchField[@name=\"Search\"]") private MobileElement searchBox;
		@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"63\"]") private MobileElement orderNumber;
		@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Print\"]") private MobileElement print;
		@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Copy count exceeded limit\"]") private MobileElement error;
		
		@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"cancel\"]") private MobileElement cancel;

		
		public Transactions() {
					base = new BaseTest();
					PageFactory.initElements(new AppiumFieldDecorator(base.getDriver()), this);
				}
			    

	 
		public void transaction() {
			base.click(transaction);
			
		}
		
		
		public void searchOrder(String txt) {
			
			base.sendKeys(searchBox, txt);
			
		}
	
		
		

		
	
}
