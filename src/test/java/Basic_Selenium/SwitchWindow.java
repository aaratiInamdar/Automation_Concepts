package Basic_Selenium;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchWindow {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.flipkart.in/");
		driver.findElement(By.name("q")).sendKeys("iphone 17",Keys.ENTER);
		String parentWID = driver.getWindowHandle();
		driver.findElement(By.xpath("//div[text()='Apple iPhone 17 (Lavender, 256 GB)']")).click();
		Set<String> allWID = driver.getWindowHandles();
	 allWID.remove(parentWID);
		WebElement element = driver.findElement(By.xpath("//span[text()='Filters']"));
		System.out.println(element.getText());
	for (String wID : allWID) {
		driver.switchTo().window(wID);
	}
	Thread.sleep(1000);
		System.out.println(driver.findElement(By.xpath("//button[text()='NOTIFY ME']")).getText());
		
	}
}
