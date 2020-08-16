package se.qa.main;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSTouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import se.leeroyMpos.qa.BaseTest;
import se.qa.login.LoginScreen;

public class MenuScreen {
	
	BaseTest base;
	
	
	//Option Group with mandatory type
	@iOSXCUITFindBy(accessibility  = "SG 1") private MobileElement devicRgesterName;
	@iOSXCUITFindBy(xpath  = "//XCUIElementTypeButton[@name=\"menu\"]") private MobileElement dropDown;
	@iOSXCUITFindBy(accessibility  = "unlock") private MobileElement unlock;
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Log in\"]") private MobileElement logOut;
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCollectionView[1]/XCUIElementTypeCell[3]") private MobileElement staffBtn;
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCollectionView[2]/XCUIElementTypeCell[3]") private MobileElement addBtn;
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Bananpaj\"])[2]") private MobileElement menu;
	
	
	  @iOSXCUITFindBy(accessibility = "Add 25 kr") private MobileElement add;
	
	  @iOSXCUITFindBy(xpath = "//XCUIElementTypeCollectionView[1]/XCUIElementTypeCell[10]") private MobileElement option;
	  @iOSXCUITFindBy(xpath = "//XCUIElementTypeCollectionView[2]/XCUIElementTypeCell[9]") private MobileElement bistro;
	  @iOSXCUITFindBy(xpath = "//XCUIElementTypeCollectionView[2]/XCUIElementTypeCell[7]") private MobileElement SG3;
	           
	         
				public MenuScreen() {
				    base = new BaseTest();
					PageFactory.initElements(new AppiumFieldDecorator(base.getDriver()), this);
				}
				
				
				
				public void tapItem() {
					  MobileElement ele= add;
					    IOSTouchAction touch = new IOSTouchAction(base.getDriver());
					    touch.tap(TapOptions.tapOptions().withPosition(PointOption.point(600, 757)))
					    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(250))).perform();
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
				
				// product with open price 
				public void openPriceProduct()  {
			
					 base.click(option);
					 base.click(SG3);
					
				}
			
				
				
				public void addBtn() throws InterruptedException {
					
				 base.click(option);
				 base.click(bistro);
					
				}
				
				
				public String getItemName() {
					return base.getAttribute(menu, "name");
				}
				
			 
			 
			  public String getLogin() {
				 
				 return base.getAttribute(logOut, "name");
			 }
			  
			   public void editItem() {
				  MobileElement ele= menu;
				    IOSTouchAction touch = new IOSTouchAction(base.getDriver());
				    touch.longPress(LongPressOptions.longPressOptions()
				    		.withElement(ElementOption.element(ele))).release().perform();
			  }
			
			   public void dropDownMenu() {
				   base.click(dropDown);
			   }
			
			}
