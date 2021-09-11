package serviceNowTestcases;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class CreateIncident extends CommonClass{
	
	@Test
	public void runCreateIncident() throws InterruptedException {
		System.out.println("Create Incident Method");
		System.out.println("Title of current WebPage : "+driver.getTitle());
		/*Thread.sleep(1000);
		driver.findElement(By.id("filter")).clear();
		driver.findElement(By.id("filter")).sendKeys("incidents", Keys.ENTER);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[text()='Incidents']")).click();
		WebElement mainFrame = driver.findElement(By.id("gsft_main"));
		driver.switchTo().frame(mainFrame);*/
		driver.findElement(By.id("sysverb_new")).click();
		
		//To Create Incident
		String incidentNum = driver.findElement(By.id("incident.number")).getAttribute("value");
		driver.findElement(By.id("sys_display.incident.caller_id")).sendKeys("sys");
		Thread.sleep(1000);
		driver.findElement(By.id("sys_display.incident.caller_id")).sendKeys(Keys.TAB);
		driver.findElement(By.id("incident.short_description")).sendKeys("Incident creation through Selenium Test Automation Tool");
		driver.findElement(By.id("incident.comments")).sendKeys("Incident creation through Selenium Test Automation Tool");
		//driver.findElement(By.id("sysverb_insert_bottom")).click();
		driver.findElement(By.id("sysverb_insert")).click();
		Thread.sleep(1000);
		System.out.println(incidentNum);
		driver.findElement(By.xpath("//input[@placeholder='Search']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(incidentNum, Keys.ENTER);
		//Thread.sleep(3000);
		//driver.findElement(By.xpath("//span[@class='input-group-addon input-group-select']/following::input")).sendKeys(incidentNum);
		String searchResult = driver.findElement(By.xpath("//a[contains(text(),'"+incidentNum+"')]")).getText();
		if(incidentNum.equals(searchResult))
			System.out.println("Incident created Successfully: "+searchResult);
		else
			System.out.println("Incident creation is UnSuccessful: "+searchResult);
	}
}
