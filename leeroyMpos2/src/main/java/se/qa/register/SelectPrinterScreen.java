package se.qa.register;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import se.leeroyMpos.qa.BaseTest;

public class SelectPrinterScreen {
	
	 
	
			@iOSXCUITFindBy(accessibility = "Empty list") private MobileElement select;
			@iOSXCUITFindBy(accessibility = "Ok") private MobileElement okBtn;
			@iOSXCUITFindBy(accessibility = "Couldn't find any printers.") private MobileElement errTxt;
			@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Select printer\"]") private MobileElement selectPrinter;
			@iOSXCUITFindBy(accessibility = "refresh") private MobileElement refreshBtn;
			@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Skip\"]\n" + 
					"") private MobileElement skipBtn;
	
   
	
	   BaseTest base;
	
	
	
			public SelectPrinterScreen() {
				base = new BaseTest();
				PageFactory.initElements(new AppiumFieldDecorator(base.getDriver()), this);
			
			}
	
			
	
	/*	public void printer () {
			
	      List<MobileElement> printer = base.getDriver().findElements(By.xpath("//XCUIElementTypeStaticText[@name=\\\"Select printer\\\"]"));
	        if (!printer.isEmpty()) {
	        	
	               printer.contains(select);                 //select found printer 
	            
	        }else {
	        	base.click(okBtn);
	        	base.click(skipBtn);
	        }
			
	        
		}*/
			public void tapBtn() {
		
				base.click(okBtn);
				
				
			}
			
			public void select() {
				base.click(select);
				
			}
			
			public IpScreen tapSkipBtn() {
				base.click(skipBtn);
				
				return  new IpScreen();
			}
	
	       public String getErrTxt() {
	    	   return base.getAttribute(errTxt,"name");
	       }
	
	
			public String getName() {
				
				return base.getAttribute(selectPrinter,"name");
			}


}
