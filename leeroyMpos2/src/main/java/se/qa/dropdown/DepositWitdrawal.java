package se.qa.dropdown;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import se.leeroyMpos.qa.BaseTest;

public class DepositWitdrawal {
	
	
	

	BaseTest base;
	
	
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCollectionView/XCUIElementTypeCell[10]") private MobileElement depositWitdrawal;
	
	
	//XCUIElementTypeStaticText[@name="Enter PIN code to continue"]  pincodepad
	//XCUIElementTypeButton[@name="Ok"] ok
	//XCUIElementTypeButton[@name="Cancel"] cancel
	//XCUIElementTypeStaticText[@name="C"] cancelling the number entered


	
	           

	


			public DepositWitdrawal() {
						base = new BaseTest();
						PageFactory.initElements(new AppiumFieldDecorator(base.getDriver()), this);
					}
				
			
		
		 
			public void depositWithDrawal() {
				base.click(depositWitdrawal);
				
				
			}
			
			
			
			
			
			
		}
