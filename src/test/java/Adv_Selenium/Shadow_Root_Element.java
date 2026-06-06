package Adv_Selenium;

import java.time.Duration;
import java.util.Set;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
public class Shadow_Root_Element {
	public static void main(String[] args) 
	{
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui/shadow?sublist=0");
		
		String parentID = driver.getWindowHandle();
		
//		SearchContext shadowHost = driver.findElement(By.xpath("(//form/div)[1]")).getShadowRoot();	
//		shadowHost.findElement(By.cssSelector("input[placeholder='Enter your username']")).sendKeys("aarati");
		
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://www.amazon.in/ref=nav_logo");
		
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://www.flipkart.in");
		
		Set<String> allID = driver.getWindowHandles();
		allID.remove(parentID);
		
		for (String window : allID) {
			driver.switchTo().window(window);
			
			String title = driver.getTitle();
//			System.out.println(title);
			
			if(title.contains("Amazon"))
			{
				System.out.println("Hyie Amazon");	
			System.out.println(driver.getTitle());
				break;
				
			}
			else {
				System.out.println(driver.getTitle());
			}
		}
//		driver.close();
//		driver.quit();
	}
}