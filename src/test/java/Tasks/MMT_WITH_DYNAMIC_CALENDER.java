package Tasks;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MMT_WITH_DYNAMIC_CALENDER {

	@Test
	public void handleDynamicCalender() {
		
		String month = "May 2026";
		int date = 25;
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.get("https://www.makemytrip.com/");
		driver.findElement(By.xpath("//span[@data-cy=\"closeModal\"]")).click();

		WebElement fromField1 = driver.findElement(By.xpath("//span[text()='From']"));
		fromField1.click();

		driver.findElement(By.xpath("//input[@placeholder=\"From\"]")).sendKeys("mumbai");
		driver.findElement(By.xpath(
				"//p[@class=\"font12 greyText appendBottom3\" and text()='Chhatrapati Shivaji International Airport']"))
				.click();

		driver.findElement(By.xpath("//span[text()='Departure']")).click();
		for (;;) {
			try {
				WebElement dateToBeSelect = driver.findElement(By.xpath("//div[.='" + month
						+ "']/ancestor::div[@class=\"DayPicker-Month\"]//p[text()='" + date + "']"));
				dateToBeSelect.click();
				break;
			} catch (Exception e) {
				driver.findElement(By.xpath("//span[@aria-label=\"Next Month\"]")).click();
			}
		}
//		driver.findElement(By.linkText("Search")).click();
	}
}
