package Basic_Selenium;

import java.io.File;
import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
public class Alerts {
public static void main(String[] args) throws InterruptedException {
	WebDriver driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.get("https://demoapps.qspiders.com/ui?scenario=1");
	driver.findElement(By.xpath("//Section[text()='Popups']")).click();
	driver.findElement(By.xpath("//Section[text()='Javascript']")).click();
	driver.findElement(By.xpath("(//input[@type=\"checkbox\"])[position()=1]")).click();
	driver.findElement(By.id("deleteButton")).click();
	Thread.sleep(2000);
	driver.switchTo().alert().accept();
//	driver.switchTo().alert().dismiss();
	System.out.println("---------Confirmation Alert Is Done -----------");
}
	
//	  PROMPT ALERT 
@Test
public void promtAlert() throws InterruptedException
{
	WebDriver driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.get("https://demoapps.qspiders.com/ui?scenario=1");
	driver.findElement(By.xpath("//Section[text()='Popups']")).click();
	driver.findElement(By.xpath("//Section[text()='Javascript']")).click();
	driver.findElement(By.linkText("Prompt")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//input[@type=\"checkbox\"])[position()=1]")).click();
	driver.findElement(By.id("deleteButton")).click();
//	Alert alert = driver.switchTo().alert();
	Alert alert= driver.switchTo().alert();
	alert.sendKeys("Alertttttt");
	Thread.sleep(2000);
	alert.accept();
	System.out.println("---------PROMPT Alert Is Done -----------");
}

//      Hidden Division Alert /form
@Test
public void hiddenDivision() throws InterruptedException
{
	WebDriver driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.get("https://demoapps.qspiders.com/ui?scenario=1");
	driver.findElement(By.xpath("//Section[text()='Popups']")).click();
	driver.findElement(By.xpath("//Section[text()='Hidden division']")).click();
	driver.findElement(By.xpath("//button[text()='Add Customer']")).click();
	driver.findElement(By.id("customerName")).sendKeys("Selenium");
	driver.findElement(By.id("customerEmail")).sendKeys("Java@gmail.com");
	Thread.sleep(2000);
	driver.findElement(By.id("hiddendiv")).click();	
	System.out.println("---------Hidden Division Alert Is Done -----------");
}

//   New Window
@Test 
public void newWindowAlert()
{
	WebDriver driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.get("https://demoapps.qspiders.com/ui?scenario=1");
	driver.findElement(By.xpath("//Section[text()='Popups']")).click();
	driver.findElement(By.xpath("//Section[text()='Browser Windows']")).click();
	String parent = driver.getWindowHandle();
	driver.findElement(By.xpath("//button[text()='view more']")).click();
	Set<String> child = driver.getWindowHandles();
	child.remove(parent);
	for (String oneW : child) {
	driver.switchTo().window(oneW);
	driver.findElement(By.xpath("//button[text()='Add to Cart']")).click();
	System.out.println("---------New Window Is Done -----------");
}	
}

//      NEW TAB 
@Test
public void newTabOpened() throws InterruptedException
{
	WebDriver driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.get("https://demoapps.qspiders.com/ui?scenario=1");
	driver.findElement(By.xpath("//Section[text()='Popups']")).click();
	driver.findElement(By.xpath("//Section[text()='Browser Windows']")).click();
	driver.findElement(By.linkText("New Tab")).click();
	String parentTAB = driver.getWindowHandle();
	Thread.sleep(1500);
	driver.findElement(By.xpath("//button[text()='view more']")).click();
Set<String> allTABS = driver.getWindowHandles();
allTABS.remove(parentTAB);
for (String tab : allTABS) {
	driver.switchTo().window(tab);
	driver.findElement(By.xpath("//button[text()='Add to Cart']")).click();
	System.out.println("---------New Tab  Is Done -----------");
}	
}

//   AUTHENTICATION POPUP
@Test
public void authenticationPOPUP() throws InterruptedException
{
	WebDriver driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.get("https://admin:admin@demoapps.qspiders.com/ui?scenario=1");
	driver.findElement(By.xpath("//Section[text()='Popups']")).click();
	driver.findElement(By.xpath("//section[text()='Authentication']")).click();
	driver.findElement(By.linkText("Login")).click();
	Thread.sleep(1500);
//	///////////////////////////////////////////////////////
}

//   FILE UPLOAD POPUP
@Test
public void fileUploadPOPUP()
{
	WebDriver driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.get("https://demoapps.qspiders.com/ui?scenario=1");
	driver.findElement(By.xpath("//Section[text()='Popups']")).click();
	driver.findElement(By.xpath("//section[text()='File Uploads']")).click();
//	 File file=new File("C:\\Users\\Arati Bajarang Inamd\\Downloads\\pic.jpg");
	WebElement fileINPUT = driver.findElement(By.xpath("//input[@type='file']"));
	fileINPUT.sendKeys("C:\\Users\\Arati Bajarang Inamd\\OneDrive\\Desktop\\Trainer\\Exceptions_In_Selenium.docx\"");
	///////////////////////////////////////////////////////////////////////////////
}

//  NOTIFICATION POPUP 
@Test
public void notificationPOPUP()
{
	ChromeOptions opt=new ChromeOptions();
	opt.addArguments("--disable-notifications");
	WebDriver driver= new ChromeDriver(opt);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.get("https://demoapps.qspiders.com/ui?scenario=1");
	driver.findElement(By.xpath("//Section[text()='Popups']")).click();
	driver.findElement(By.xpath("//section[text()='Notifications']")).click();
	driver.findElement(By.id("browNotButton")).click();	
	System.out.println("---------Notification POPUP Is Done -----------");
}

}
