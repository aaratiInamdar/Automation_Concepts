package Adv_Selenium;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Handle_Calender_Popup {
	WebDriver driver;
	public void baseMethod() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Test
	public void singleCalenderPopup() throws InterruptedException {
		baseMethod();
		driver.get("https://www.redbus.in/");

//		we can handle this calender by using directly text()
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[@class=\"dateLabel___a92fe6 selected___4b9e19\"]")).click();
		driver.findElement(By.xpath("//span[.='31']")).click();
	}

	@Test
	public void handleSingleCalenderPopup_using_IRCTC_usingDynamicVariable_AndLoop() {
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(opt);

		String month = "October";
		int date = 16;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.findElement(By.xpath("//button[.='OK']")).click();
		driver.findElement(By.xpath("//span[@class=\"ng-tns-c59-10 ui-calendar\"]")).click();

//		if we want to select date afetr5-6months then we can use this approach
		for (;;) {
			try {
				WebElement month_Date = driver.findElement(By.xpath("//span[.='" + month
						+ "']/ancestor::div[contains(@class,'ui-datepicker')]//a[text()='" + date + "']"));
				month_Date.click();
				break;
			} catch (Exception e) {
				driver.findElement(By.xpath("//span[contains(@class,\"ui-datepicker-next\")]")).click();
			}
		}
	}

	@Test
	public void handleDoubleCalenderPopup() {
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.goibibo.com/");
		driver.findElement(By.xpath("//span[@role=\"presentation\"]")).click();
		driver.findElement(By.xpath("//span[.='Departure']")).click();

//		we can take the help of the xpath by axex
		driver.findElement(By.xpath("//div[.='September 2025']/parent::div[@class=\"DayPicker-Month\"]//p[.='27']"))
				.click();
	}

	@Test
	public void handleDoubleCalenderPopup_using_MMT() {

		String month = "September 2025";
		int date = 30;
//		making dynamic variables i.e if we eant to select date after 4-5 months then will use this approach
		baseMethod();
		driver.get("https://www.makemytrip.com/");
		driver.findElement(By.xpath("//span[@data-cy=\"closeModal\"]")).click();
		driver.findElement(By.xpath("//span[text()='Departure']")).click();
		driver.findElement(By
				.xpath("//div[.='" + month + "']/ancestor::div[@class=\"DayPicker-Month\"]//p[text()='" + date + "']"))
				.click();

	}

	@Test
	public void handleDoubleCalenderPopup_using_KSRTC() {
//		String month = "September 2025";
//		int date = 30;
		baseMethod();
		driver.get("https://ksrtc.in/");
		driver.findElement(By.xpath("//label[@for=\"departDate\"]")).click();
		driver.findElement(By.xpath("//span[.='Next']")).click();
//		 this is application issue .since buses are not available so that arrow is not working	
		
	}
}
