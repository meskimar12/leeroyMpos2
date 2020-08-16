package se.qa.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import se.leeroyMpos.qa.BaseTest;

public class FoodDisplayMenu {
	
	
	
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCollectionView[1]/XCUIElementTypeCell[3]") private MobileElement staffBtn;
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCollectionView[1]/XCUIElementTypeCell[3]") private MobileElement burritos;
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCollectionView[1]/XCUIElementTypeCell[3]") private MobileElement shraddha;
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCollectionView[1]/XCUIElementTypeCell[3]") private MobileElement granatäpplen;
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCollectionView[1]/XCUIElementTypeCell[3]") private MobileElement ingredients;
	
	// Product has Option Group Expanded by default.
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCollectionView[1]/XCUIElementTypeCell[10]") private MobileElement sg;
	
	// Product has Option Group (Shows option group before adding product).
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCollectionView[2]/XCUIElementTypeCell[5]") private MobileElement sg2;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCollectionView[2]/XCUIElementTypeCell[5]") private MobileElement errTxt;
	
	// Product with no option Group
	
	
	// Meal 
	
	
	//Bowls
	
	
	// Open Price Product
	
	
	// accessibility id 	Marked groups contain an invalid number of selected items.
	
	//XCUIElementTypeButton[@name="Ingredients"] ingredients button
	
	// (//XCUIElementTypeStaticText[@name="Välj storlek"])[2]  valji storlek



	
			BaseTest base;
			
			
			public FoodDisplayMenu() {
			    base = new BaseTest();
				PageFactory.initElements(new AppiumFieldDecorator(base.getDriver()), this);
			}

	
	          public void optionGroupExtended() {
	        	  
	          }
	          
	          
	          public void mandatoryOptionGroup() {
	        	  
	          }
	          
	          public void globalItem() {
	        	  
	          }
	          
	          public void mealMenu() {
	        	  
	          }
	          
	          public void builBowl() {
	        	  
	          }
	          
	          public void productWithoption() {
	        	  
	          }
	          
	          
	       // product that 
	      	public void  openPrice() {
	      		
	      	  }
	      	
	      	public String getErrTxt() {
	     	   return base.getAttribute(errTxt,"name");
	        }
	      	    
	      	public boolean ingredientsIsDisplay () {
				try {
					if (ingredients.isDisplayed()){
						  return  true;
					  }
					  else {
					
					return false;
					  }
					}catch(Exception e) {
						
						e.getMessage();
			        	  throw e;
					}
				  
			       }
	          
	
	public void selectFood(){
		
	List<MobileElement>order = new ArrayList<MobileElement>();
	order.add(staffBtn);
	order.add(burritos);
	order.add(granatäpplen);
	
	
	
		
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
