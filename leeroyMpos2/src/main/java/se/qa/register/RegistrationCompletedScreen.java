package se.qa.register;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import se.leeroyMpos.qa.BaseTest;


public class RegistrationCompletedScreen {
	
	
			@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Continue\"]") private MobileElement continueBtn;
			@iOSXCUITFindBy(accessibility  = "Registration completed!") private MobileElement registrationCompleted;
			@iOSXCUITFindBy(accessibility = "Ok") private MobileElement okBtn;
			@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Select printer\"]") private MobileElement selectPrinter;
		//	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Skip\"]\n" + 
	//				"") private MobileElement skipBtn;
	
	
	BaseTest base;
	
	
	public RegistrationCompletedScreen() {
		base = new BaseTest();
		PageFactory.initElements(new AppiumFieldDecorator(base.getDriver()), this);
	}
	
	
	
		public String getName() {
			return base.getAttribute(registrationCompleted,"name");
			
			
		}
		

	
		public SelectPrinterScreen tapContinueBtn() {
			base.click(continueBtn);
			
			return  new SelectPrinterScreen();
		}

		
		public void tapBtn() {
			
			base.click(okBtn);
			
			
		}
		public String getScreenName() {
			return base.getAttribute(selectPrinter,"name");
			
			
		}
		

		

}
