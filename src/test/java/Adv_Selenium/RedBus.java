package Adv_Selenium;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class RedBus {	
	@Test
	public void redBus()
	{	 
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.redbus.in/");
		driver.findElement(By.xpath("//input[@id=\"srcinput\"]")).sendKeys("Mumbai");
		driver.findElement(By.xpath("//div[@aria-label=\"Mumbai\"]")).click();
		
		driver.findElement(By.xpath("//input[@id=\"destinput\"]")).sendKeys("Delhi");
		driver.findElement(By.xpath("//div[@aria-label=\"Delhi\"]")).click();
		
		driver.findElement(By.xpath("//div[@class=\"dateInputWrapper___74d4df dateHighlight___6cd98b\"]")).click();
		driver.findElement(By.xpath("//i[@aria-label=\"Next month, June 2026\"]")).click();		
		driver.findElement(By.xpath("//div[@class=\"mainDatesWrap___feda92\"]/descendant::span[text()='17']")).click();
		driver.findElement(By.xpath("//button[@aria-label=\"Search buses\"]")).click();
		
		driver.findElement(By.xpath("//div[text()='REDIGO BUS']")).click();
		driver.findElement(By.xpath("(//button[@aria-label=\"Close\"])[position()=2]")).click();
		WebElement allSeats = driver.findElement(By.xpath("//span[@role=\"button\"]"));
		
	}
}
