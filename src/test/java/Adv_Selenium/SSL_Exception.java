package Adv_Selenium;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSL_Exception {

	public static void main(String[] args) {
		ChromeOptions var=new ChromeOptions();
		var.setAcceptInsecureCerts(true);
		WebDriver driver= new ChromeDriver(var);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://expired.badssl.com/");
		
	}
}
