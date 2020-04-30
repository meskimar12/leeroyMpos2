package se.qa.main;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import se.leeroyMpos.qa.BaseTest;

public class CartSection {
	
	
	
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Bananpaj\"])[2]") private MobileElement menu;
	
	BaseTest base;
	
	public CartSection() {
	    base = new BaseTest();
		PageFactory.initElements(new AppiumFieldDecorator(base.getDriver()), this);
	}
	
	



	public String getItemName() {
		return base.getAttribute(menu, "name");
	}

}
