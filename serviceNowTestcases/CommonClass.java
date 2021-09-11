package serviceNowTestcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonClass {
	
	public ChromeDriver driver;
	public WebElement mainFrame;
	
	@BeforeMethod
	public void loginServiceNow() {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	
	/*
	//To login into SerivceNow
	driver.get("https://developer.servicenow.com/dev.do");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
	//driver.findElement(By.xpath("//span[@class='dps-button-label']")).click();
	//driver.findElement(By.xpath("//span[text='Sign In']")).click();
	driver.findElement(By.xpath("//button[@class=dps-link -primary -md']")).click();
	driver.findElement(By.id("username")).sendKeys("sankarisaravanan08@gmail.com");	
	driver.findElement(By.id("usernameSubmitButton")).click();
	driver.findElement(By.id("password")).sendKeys("Sughanthan#8");
	driver.findElement(By.id("submitButton")).click();
	*/
	
	//To invoke the instance
	driver.get("https://dev55302.service-now.com");
	driver.manage().window().maximize();
	WebElement mainFrame = driver.findElement(By.id("gsft_main"));
	driver.switchTo().frame(mainFrame);
	driver.findElement(By.id("user_name")).sendKeys("admin");
	driver.findElement(By.id("user_password")).sendKeys("Sughanthan#8");
	driver.findElement(By.id("sysverb_login")).click();
	String pageTitle = driver.getTitle();
	System.out.println(pageTitle);	
    }
	
	@BeforeMethod
	public void openSearchIncident() throws InterruptedException {
		driver.findElement(By.id("filter")).clear();
		driver.findElement(By.id("filter")).sendKeys("incidents", Keys.ENTER);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[text()='Incidents'])[2]")).click();
		mainFrame = driver.findElement(By.id("gsft_main"));
		driver.switchTo().frame(mainFrame);		
	}
	
	@AfterMethod
	public void logoutServiceNow() {
		driver.switchTo().defaultContent();
		driver.findElement(By.id("user_info_dropdown")).click();
		driver.findElement(By.linkText("Logout")).click();
		driver.close();		
	}
}
