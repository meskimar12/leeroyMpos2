package se.qa.payment;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import se.leeroyMpos.qa.BaseTest;

public class PaymentScreen {
	
	
	
		BaseTest base;
		
		
		@iOSXCUITFindBy(xpath = "") private MobileElement cashButton;
		@iOSXCUITFindBy(xpath = "") private MobileElement cardButton;
		@iOSXCUITFindBy(xpath = "") private MobileElement swishButton;
		@iOSXCUITFindBy(xpath = "") private MobileElement externalTermnalButton;
		@iOSXCUITFindBy(xpath = "") private MobileElement retain24Button;
		
		
		
		public PaymentScreen() {
		    base = new BaseTest();
			PageFactory.initElements(new AppiumFieldDecorator(base.getDriver()), this);
		}
	

		
		
		 public void payWithCard() {
			 
		 }
		 
		 public void payWithCash() {
			 
		 }
		 
		 public void payWithSwish() {
			 
			 
		 }
		 
		 public void payWithExtranalTerminal() {
			 
		 }
		 
		 public void payWithRetain24() {
			 
		 }
		 
}
