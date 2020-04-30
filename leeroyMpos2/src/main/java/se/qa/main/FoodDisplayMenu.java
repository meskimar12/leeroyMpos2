package se.qa.main;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import se.leeroyMpos.qa.BaseTest;

public class FoodDisplayMenu {
	
	
	BaseTest base;
	
	
	public FoodDisplayMenu() {
	    base = new BaseTest();
		PageFactory.initElements(new AppiumFieldDecorator(base.getDriver()), this);
	}

	
	
	public void selectFood(){
		
	List<MobileElement>food = base.getDriver().findElements(By.xpath("//XCUIElementTypeApplication[@name=\"Leeroy MPOS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeCollectionView[1]"));
	
	Random random = new Random();
	
	int randomValue = random.nextInt(food.size());
	
	food.get(randomValue).click();
	
		
	}
	
	public void addFoodcart() {
		
		List<MobileElement>foods = base.getDriver().findElements(By.xpath("//XCUIElementTypeApplication[@name=\"Leeroy MPOS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeCollectionView[1]"));
		
		Random random = new Random();
		
		int randomValue = random.nextInt(foods.size());
		
		foods.get(randomValue).click();
		
		
		
	}
	
	
	
	
	
	
	
	
	

}
