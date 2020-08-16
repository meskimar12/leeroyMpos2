package se.qa.login;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import se.leeroyMpos.qa.BaseTest;
import se.qa.main.MenuScreen;

public class LoginScreen {
	
    
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"Leeroy MPOS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeSecureTextField\n" + 
			"") private MobileElement pinTxtFiled;
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Unlock\"]") private MobileElement unlockBtn;
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Incorrect Pin\"]") private MobileElement errTxt;
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Ok\"]") private MobileElement okBtn;
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Log in\"]") private MobileElement loginScreen;
	
	BaseTest base;
	

	public LoginScreen() {
	    base = new BaseTest();
		PageFactory.initElements(new AppiumFieldDecorator(base.getDriver()), this);
	}

    
	   public LoginScreen enterPin(String pin) {
		   base.sendKeys(pinTxtFiled, pin);
		   base.getDriver().hideKeyboard();
		   
		   
		return this;
	  }
	   
		public MenuScreen tapUnlokBtn() {
			base.click(unlockBtn);
			
			return  new MenuScreen();
		}
		
		
		public void tapokBtn() {
			base.click(okBtn);
			
			
		}

       public String getErrTxt() {
    	   return base.getAttribute(errTxt,"name");
       }
   
       
       public void delete() {
	       if (pinTxtFiled != null) {
	    	   
	    	   pinTxtFiled.clear();
	    	   
	    	}
  }
       
       public String getName() {
    	   return base.getAttribute(loginScreen,"name");
       }
       
       public MenuScreen login( String pin) {
    	   enterPin(pin);
    	   return tapUnlokBtn();
    	   
       }
       
   
       }
	  
		