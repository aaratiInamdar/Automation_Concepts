package Basic_Selenium;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class OpenMultiWindows {

	WebDriver driver=new ChromeDriver();
	
	@Test
    public void windows()
    {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		
    	driver.get("https://www.flipkart.com/");  
    	String flipcartId = driver.getWindowHandle();	
    	driver.switchTo().newWindow(WindowType.WINDOW);
  	
    	driver.get("https://www.amazon.in/");  
    	driver.switchTo().newWindow(WindowType.WINDOW);
    	
    	driver.get("https://www.myntra.com/");
    	driver.switchTo().newWindow(WindowType.WINDOW);
    	
    	driver.get("https://www.shopsy.in/");
    	String shopsyId = driver.getWindowHandle();
      
	    driver.switchTo().window(flipcartId);
	    driver.findElement(By.name("q")).sendKeys("IPhone15",Keys.ENTER);
	    String  prize = driver.findElement(By.xpath("//div[@class='yKfJKb row' and contains(.,'Apple iPhone 15 (Blue, 128 GB)')]//div[@class='Nx9bqj _4b5DiR']")).getText();
	    String prize1 = prize.substring(1).replace(",", "");
	    double prizeInt1= Double.parseDouble(prize1);
	   	System.out.println(prizeInt1);
       
       driver.switchTo().window(shopsyId);
       driver.findElement(By.name("q")).sendKeys("IPhone15",Keys.ENTER);
//       String prizeShopsy = driver.findElement(By.xpath("//div[@class='css-175oi2r r-13awgt0' and contains(.,'Apple iPhone 15 (Pink, 128 GB)')]//div[text()='₹64,400']")).getText();
       String prizeShopsy= driver.findElement(By.xpath("//div[@class=\"css-175oi2r r-13awgt0\" and contains(.,'Apple iPhone 15 (Pink, 128 GB)')]//div[contains(@class,' r-1rsjblm r-13hce6t')]")).getText();
       String prizeShopsy1 = prizeShopsy.substring(1).replace(",", "");
       double prizeShopsy2= Double.parseDouble(prizeShopsy1);
       System.out.println(prizeShopsy2);
       if(prizeInt1 > prizeShopsy2)
       {
    	   System.out.println("Prize of flipcart iPhone is more ");
       }
       else if (prizeInt1 == prizeShopsy2) {
    	   System.out.println("Prize of shopsy iPhone and flipcart iPhone is equal ");
       }
       else
       {
    	   System.out.println("Prize of shopsy iPhone is more ");
       }
    	
       driver.close();    
    }
}
