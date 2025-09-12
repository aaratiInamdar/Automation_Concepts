package Generic;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImpl implements ITestListener , ISuiteListener {

	@Override
	public void onStart(ISuite suite) 
	{
		System.out.println("onStart executed on suite level");
	}

	@Override
	public void onFinish(ISuite suite)
	{
		System.out.println("onFinish executed on suite level");
	}

	@Override
	public void onTestStart(ITestResult result) 
	{
		System.out.println("onTestStart executed on test level");
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		System.out.println("onTestSuccess executed");
	}

	@Override
	public void onTestFailure(ITestResult result)
	{
		System.out.println("onTestFailure executed");
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		System.out.println("onTestSkipped executed");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result)
	{
		System.out.println("onTestFailedButWithinSuccessPercentage executed");
		
//		if we want to execute this method then we can use one helper attribute which is "successPercentage"  with that we have to give our percentage of test success
//	    if that tc is gets passed by that amount of percentage then it will give result as tc is pass otherwise it will give as fail
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) 
	{
		System.out.println("onTestFailedWithTimeout executed");
	}

	@Override
	public void onStart(ITestContext context)
	{
		System.out.println("onStart executed on test level");
	}

	@Override
	public void onFinish(ITestContext context)
	{
		System.out.println("onFinish executed on test level");
	}	
}
