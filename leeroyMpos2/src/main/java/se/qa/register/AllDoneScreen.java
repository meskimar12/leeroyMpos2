package se.qa.register;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import se.leeroyMpos.qa.BaseTest;
import se.qa.login.LoginScreen;

public class AllDoneScreen {
	
	
@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Log in\"]") private MobileElement loginBtn;
@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"All done!\"]") private MobileElement allDaoneScreen;

	
	BaseTest base;
	
	
	public AllDoneScreen() {
		base = new BaseTest();
		PageFactory.initElements(new AppiumFieldDecorator(base.getDriver()), this);
	}


	

		
		public LoginScreen tapLoginBtn() {
			base.click(loginBtn);
			
			return  new LoginScreen ();
		}
		
		
		public String getName() {
			
			return base.getAttribute(allDaoneScreen,"name");
		}


}
