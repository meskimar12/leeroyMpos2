package se.qa.login;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import se.leeroyMpos.qa.BaseTest;
import se.qa.main.MenuScreen;

public class DailyInventoryScreen extends BaseTest{
	
	@iOSXCUITFindBy(accessibility = "test-Apply") private MobileElement applyBtn;
	@iOSXCUITFindBy(accessibility = "test-Cancel") private MobileElement cancelBtn;
	
	
	
	public DailyInventoryScreen applyBtn() {
		click(applyBtn);
		
		return new DailyInventoryScreen();
	}
	
	public MenuScreen cancelBtn() {
		click(cancelBtn);
		
		return new MenuScreen();
	}
	

}
