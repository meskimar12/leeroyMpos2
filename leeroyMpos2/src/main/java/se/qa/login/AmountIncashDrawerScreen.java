package se.qa.login;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import se.leeroyMpos.qa.BaseTest;

public class AmountIncashDrawerScreen {
	
	@iOSXCUITFindBy(accessibility = "test-Password") private MobileElement amountTxtFiled;
	@iOSXCUITFindBy(accessibility = "test-LOGIN") private MobileElement confirmBtn;
	@iOSXCUITFindBy(xpath = "test-LOGIN") private MobileElement amountIncashDrawerTXt;
	
	 BaseTest base;
	
	public AmountIncashDrawerScreen() {
		
	    base = new BaseTest();
		PageFactory.initElements(new AppiumFieldDecorator(base.getDriver()), this);
	}

	   
		public AmountIncashDrawerScreen enterCashamount(String amount) {
			base.sendKeys(amountTxtFiled, amount);
			
			return this;
		}
		
		public DailyInventoryScreen confirmBtn() {
			base.click(confirmBtn);
			
			return new DailyInventoryScreen();
		}
		public String getTitle() {
			   return base.getAttribute(amountIncashDrawerTXt,"text");
		   }
		

}
