package Adv_Selenium;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class BrokenLinks_Short {

	public static void main(String[] args) {
		
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.onlinesbi.sbi/");
		 List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		
		System.out.println(allLinks.size());
		
		for (WebElement link : allLinks) {
			String urlOfLink = link.getAttribute("href");		
			try {
				URL url=new URL(urlOfLink);
				HttpURLConnection httpConn=(HttpURLConnection)url.openConnection();
				int statusCode = httpConn.getResponseCode();			
				if(statusCode>=400)
				{
					System.out.println(urlOfLink + "==>" + statusCode);
				}				
			}
			catch(Exception e){							
			}		
		}
	
		driver.quit();
	}
}
