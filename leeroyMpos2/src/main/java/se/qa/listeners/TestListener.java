package se.qa.listeners;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import se.qa.utils.JiraPolicy;

public class TestListener implements ITestListener {
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		if(result.getThrowable()!= null){
			StringWriter stringWriter = new StringWriter();
			PrintWriter printWriter = new PrintWriter(stringWriter);
			result.getThrowable().printStackTrace(printWriter);
			System.out.println(stringWriter.toString());
			
			result.getMethod().getConstructorOrMethod().getMethod().getAnnotations();
			
		//	JiraPolicy jirapolicy =result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(JiraPolicy.class);
		//	boolean isAvailable = jirapolicy.logInTicketReady();
			
		//	if(isAvailable) {
		//		System.out.println("ticket is ready" + isAvailable);
				
				
		//	}
			
			
		}
		
	}
		

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	

}
