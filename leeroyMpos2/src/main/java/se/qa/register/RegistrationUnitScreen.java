package se.qa.register;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import se.leeroyMpos.qa.BaseTest;


public class RegistrationUnitScreen {
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"Leeroy MPOS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField\n" + 
			"") private MobileElement secretKeyTxtFiled;
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Send\"]\n" + 
			"") private MobileElement sendBtn;
	@iOSXCUITFindBy(accessibility = "We are unable to process your request, please try after sometime.") private MobileElement errTxt;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Ok\"]") private MobileElement okBtn;
	BaseTest base;
	
	
	public RegistrationUnitScreen() {
		base = new BaseTest();
		PageFactory.initElements(new AppiumFieldDecorator(base.getDriver()), this);
	}



		public RegistrationUnitScreen enterSecretKey(String secretKey) {
			base.sendKeys(secretKeyTxtFiled, secretKey);
			base.getDriver().hideKeyboard();
			
			return this;
		}
		
		public RegistrationCompletedScreen tapSendBtn() {
			base.click(sendBtn);
			
			return  new RegistrationCompletedScreen();
		}

       public String getErrTxt() {
    	   return base.getAttribute(errTxt,"name");
       }
       
       public void tapokBtn() {
			base.click(okBtn);
			
			
		}
       
       public void delete() {
	       if (secretKeyTxtFiled != null) {
	    	   
	    	   secretKeyTxtFiled.clear();
	    	   
	    	}

       }
}
