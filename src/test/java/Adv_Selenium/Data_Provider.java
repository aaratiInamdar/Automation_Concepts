package Adv_Selenium;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Data_Provider {

//	@Test(dataProvider = "getData" , invocationCount = 2)
	@Test(priority = 1 , groups = "amazon")
	public void test()
	{
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.amazon.in/");
//		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(data);	
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone 15" , Keys.ENTER);		
	}
	
	@DataProvider
	public Object[][] getData()
	{	
		Object[][] obj=new Object[4][2];
		obj[0][0]="iphone";
		obj[0][1]="watch";
		obj[1][0]="laptop";
		obj[1][1]="";
		obj[2][0]="mobiles";
		obj[2][1]="";
		obj[3][0]="toy";
		obj[3][1]="";	
		return obj;
	}
	
//	@Test(dependsOnMethods = "test" )
	@Test(priority = 0 ,groups = "amazon")
	public void test2()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone 15", Keys.ENTER);		
		driver.findElement(By.xpath("//span[text()='Apple iPhone 15 (128 GB) - Black']/ancestor::div[@class=\"puisg-col-inner\"]//button[@name=\"submit.addToCart\"]")).click();
	}
	
	@Test(groups = "flip")
	public void test3()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.name("q")).sendKeys("ladies watch" , Keys.ENTER);
	}
	
	@Test(groups = "flip")
	public void test4()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.linkText("Cart")).click();
	}
}
