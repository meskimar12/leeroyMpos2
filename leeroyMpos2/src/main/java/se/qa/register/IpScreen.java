package se.qa.register;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import se.leeroyMpos.qa.BaseTest;


public class IpScreen  {
	
	
@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Continue\"]") private MobileElement continueBtn;
@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"IP address of your device\"]") private MobileElement ipScreen;
	
	BaseTest base;
	
	
	public IpScreen() {
		base = new BaseTest();
		PageFactory.initElements(new AppiumFieldDecorator(base.getDriver()), this);
	}


		
		public AllDoneScreen tapContinueBtn() {
			base.click(continueBtn);
			
			return  new AllDoneScreen ();
		}
		
		public String getName() {
			
			return base.getAttribute(ipScreen,"name");
		}

}
