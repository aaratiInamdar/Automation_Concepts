package Basic_Selenium;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {
	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver = new ChromeDriver();
		System.out.println("<-----------START------------>");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.amazon.in/");
		driver.findElement(By.xpath("//button[text()='Continue shopping']")).click();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("mobiles", Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"//span[text()='Get It Today']/ancestor::span[@data-csa-c-type=\"element\"]//i[@class=\"a-icon a-icon-checkbox\"]"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"//span[text()='Samsung']/ancestor::span[@data-csa-c-type=\"element\"]//i[@class=\"a-icon a-icon-checkbox\"]"))
				.click();
		driver.navigate().back();
		driver.navigate().back();
		List<WebElement> Options = driver.findElements(By.xpath("//a[@class='nav-a  ']"));
		for (WebElement opt : Options) {

			System.out.println(opt.getText());
		}
		System.out.println("<--------------FINISHED---------->");		
	}
}
