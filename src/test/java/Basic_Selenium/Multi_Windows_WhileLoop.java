package Basic_Selenium;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Multi_Windows_WhileLoop {

	@Test
	public void checkMultiWindow()
	{	
		String partialURL="meesho";
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");		
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://www.flipkart.com/");		
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://www.meesho.com/");
		driver.switchTo().newWindow(WindowType.TAB);

		driver.get("https://www.goibibo.com/");
		driver.switchTo().newWindow(WindowType.TAB);

		driver.get("https://www.makemytrip.com/");
		Set<String> windowsId = driver.getWindowHandles();
		
		Iterator<String> id= windowsId.iterator();
		while(id.hasNext())
		{
			String wID = id.next();
			driver.switchTo().window(wID);
			String actURL=driver.getCurrentUrl();
			if(actURL.contains(partialURL))
			{
				break;
			}
		}
		
	}
}
