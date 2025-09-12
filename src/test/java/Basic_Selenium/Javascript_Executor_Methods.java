package Basic_Selenium;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Javascript_Executor_Methods {
	WebDriver driver;

	public void baseMethod() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://byjus.com/");
	}

	@Test
	public void clickOn() {
		baseMethod();
		WebElement checkBtn = driver.findElement(By.linkText("Check now"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", checkBtn);
	}

	@Test
	public void sendkeysAct() {
		baseMethod();
		WebElement inputBox = driver.findElement(By.xpath("//input[@data-placeholder=\"Name\"]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].value='AARATI';", inputBox);

//		This method will give you text of that element which is already present in that element
		String value = (String) js.executeScript("return arguments[0].value;", inputBox);
		System.out.println(value);

//		it will  text present inside the element
		WebElement firstName = driver.findElement(By.xpath("//span[.='Enter Name of your Child']"));
		String text = (String) js.executeScript("return arguments[0].innerText;", firstName);
		System.out.println(text);
	}

	@Test
	public void scrollToElement() {
		baseMethod();
//		it can scroll to any element present on the page
		WebElement link = driver.findElement(By.xpath("//button[contains(.,'1000s of reviews by happy students')]"));
//		WebElement link = driver.findElement(By.xpath("//p[contains(.,'Conceptual clarity ')]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", link);

//		 it will Scroll down by  500px that is in y axes
		js.executeScript("window.scrollBy(0, 500);");

//		it will scroll to top of the page
		js.executeScript("window.scrollTo(0, 0);");
	}

	@Test
	public void scrollTillEndOfPage() {
		baseMethod();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

	}

	@Test
	public void highlight_Element() {
		baseMethod();
		WebElement onlineBtn = driver.findElement(By.xpath("//input[@id=\"ftc-online\"]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='15px solid red'", onlineBtn);

	}

	@Test
	public void navigateToURL() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.location = 'https://chatgpt.com';");

	}

	@Test
	public void refreshThePAGE() {
		baseMethod();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("history.go(0);");
	}

	@Test
	public void getTileOFPAGE() {
		baseMethod();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String title = (String) js.executeScript("return document.title;");
		System.out.println(title);

		String url = (String) js.executeScript("return document.URL;");
		System.out.println(url);
	}

	@Test
	public void open_New_WindowTab() {
		baseMethod();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// it will open new tab or window
		js.executeScript("window.open('https://example.com', '_blank');");
	}
}
