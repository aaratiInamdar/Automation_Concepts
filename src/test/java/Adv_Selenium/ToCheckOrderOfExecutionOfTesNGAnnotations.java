package Adv_Selenium;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Generic.BaseClass;
import Generic.ListenerImpl;

@Listeners(Generic.ListenerImpl.class)
public class ToCheckOrderOfExecutionOfTesNGAnnotations extends BaseClass {

	@Test
	public void checkOrderOfExecution()
	{
		System.out.println("Hii_This is my Sample Class");
	}
}
