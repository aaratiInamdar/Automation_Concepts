package Adv_Selenium;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Handle_Slider {

	@Test
	public void handleSlider() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://testautomationpractice.blogspot.com/");
		Actions act = new Actions(driver);
		WebElement slider1 = driver
				.findElement(By.xpath("//span[@class='ui-slider-handle ui-corner-all ui-state-default']"));
		WebElement slider2 = driver
				.findElement(By.xpath("//span[@class=\"ui-slider-handle ui-corner-all ui-state-default\"][2]"));
		act.scrollToElement(slider1).perform();
		
//		 first approach  (if we have to move back then pass xases as  -100 pixels [minus amount]) 
//		act.dragAndDropBy(slider1, 70, 0).perform();
//		act.dragAndDropBy(slider2, 100, 0).perform();
		
//		second approach 
//		act.clickAndHold(slider1).moveByOffset(40, 0).perform();
//		act.clickAndHold(slider2).moveByOffset(60, 0).perform();
		
//		Third Approach
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'left:50%')", slider1);
		js.executeScript("arguments[0].setAttribute('style', 'left:90%')", slider2);
	}
}
