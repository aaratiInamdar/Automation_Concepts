package Adv_Selenium;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Shadow_Root_Element {
	public static void main(String[] args) 
	{
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoapps.qspiders.com/ui/shadow?sublist=0");
		SearchContext shadowHost = driver.findElement(By.xpath("(//form/div)[1]")).getShadowRoot();
		shadowHost.findElement(By.cssSelector("input[placeholder='Enter your username']")).sendKeys("aarati");
	}
}