package se.qa.main;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import se.leeroyMpos.qa.BaseTest;
import se.qa.login.LoginScreen;

public class MenuScreen {
	
	BaseTest base;
	
	
	@iOSXCUITFindBy(accessibility  = "SG 1") private MobileElement devicRgesterName;
	@iOSXCUITFindBy(xpath  = "//XCUIElementTypeButton[@name=\"menu\"]") private MobileElement dropDown;
	@iOSXCUITFindBy(accessibility  = "unlock") private MobileElement unlock;
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCollectionView[1]/XCUIElementTypeCell[3]") private MobileElement staffBtn;
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCollectionView[2]/XCUIElementTypeCell[3]") private MobileElement addBtn;
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Log in\"]") private MobileElement logOut;
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Bananpaj\"])[2]") private MobileElement menu;
	public MenuScreen() {
	    base = new BaseTest();
		PageFactory.initElements(new AppiumFieldDecorator(base.getDriver()), this);
	}
	
	public String getName() {
		return base.getAttribute(devicRgesterName,"name");
		
		
	}
	
	public LoginScreen tapunlock() {
		
		base.click(unlock);
		
		return new LoginScreen();
		
	}
	
	
	public void foodBtn()  {
		
	    base.click(staffBtn);
		
		//return  new FoodDisplayMenu();
	}
	public void addBtn() {
		
		
		  base.click(addBtn);;
		
	}
	
	public String getItemName() {
		return base.getAttribute(menu, "name");
	}
	
 
 
public String getLogin() {
	 
	 return base.getAttribute(logOut, "name");
 }
	

}
