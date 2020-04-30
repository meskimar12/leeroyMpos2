package se.leeroyMpos.qa;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import se.qa.utils.TestUtils;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Properties;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BaseTest {
	
	protected static AppiumDriver<MobileElement> driver;
	protected static  Properties props;
	protected static  HashMap<String, String>strings = new HashMap<String,String>();
	InputStream inputStream;
	InputStream stringsis;
	TestUtils utils;
    
	
	public BaseTest() {
		
	}
	public void setDriver(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
	}
	
	public  AppiumDriver<MobileElement> getDriver() {
		return driver;
	}
	
	public HashMap<String, String> getStrings() {
		return strings; 
	}
	
  
  public  void initializeDriver(String applicationName,String platformVersion,String deviceName) throws Exception{
	  try {
		  props = new Properties();
		  String propFileName = "config.properties";
		  String xmlFileName = "strings/strings.xml";
		  
		  
		  inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
		  props.load(inputStream);
		  
		  stringsis = getClass().getClassLoader().getResourceAsStream(xmlFileName);
		  utils = new TestUtils();
		  strings = utils.parseStringXML(stringsis);
		  
		DesiredCapabilities caps = new  DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.CLEAR_SYSTEM_FILES, true);
		caps.setCapability(MobileCapabilityType.APPLICATION_NAME, applicationName);
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION,platformVersion);
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME , props.getProperty("automationName"));
		caps.setCapability(MobileCapabilityType.UDID, props.getProperty("UDID"));
		caps.setCapability(IOSMobileCapabilityType.BUNDLE_ID,props.getProperty("bundleId"));
		
		
		
		
		//caps.setCapability(MobileCapabilityType.APP, "");
		//URL appUrl = getClass().getClassLoader().getResource(props.getProperty("androidAppLocation"));
		//caps.setCapability("app", appUrl);
		
		//AppiumDriver<MobileElement> driver = new IOSDriver<MobileElement>(new URL(props.getProperty("AppiumURL")),caps);
		  URL url = new URL(props.getProperty("AppiumURL"));
		
		driver = new IOSDriver<MobileElement>(url,caps);
	//	String sessionID = driver.getSessionDetails().toString();
		
	  
		  
	  }catch(Exception e) {
		  e.printStackTrace();
		  throw e;
	  }finally {
		  if(inputStream != null) {
			  inputStream.close();
		  }
		  if(stringsis != null) {
			  stringsis.close();
			  
		  }
	  }
  }
	  
	  public void waitForVisibility(MobileElement e) {
		  WebDriverWait wait = new WebDriverWait(driver,TestUtils.WAIT);
		 wait.until(ExpectedConditions.visibilityOf(e));
		  
	       }
	  
	  public void click(MobileElement e) {
		  waitForVisibility(e);
		  e.click();
	       }
	  public void sendKeys(MobileElement e, String txt) {
		  waitForVisibility(e);
		  e.sendKeys(txt);
		  
	       }
	  
	  public String getAttribute(MobileElement e, String attribute) {
		 waitForVisibility(e);
		 return  e.getAttribute(attribute);
	     }
	  
	  
	public void quitDriver() {
		  driver.quit();
	    }
 
}
