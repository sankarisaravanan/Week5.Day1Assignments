package serviceNowTestcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class UpdateIncident extends CommonClass {

	@Test
	public void runUpdateIncident() throws InterruptedException {
		String incidentNum="INC0010018";
		System.out.println("Update Incident");
		System.out.println("Title of current WebPage : "+driver.getTitle());
		driver.findElement(By.xpath("//input[@placeholder='Search']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(incidentNum, Keys.ENTER);
		String searchResult = driver.findElement(By.xpath("//a[contains(text(),'"+incidentNum+"')]")).getText();
		driver.findElement(By.xpath("//a[contains(text(),'"+incidentNum+"')]")).click();
		Thread.sleep(1000);
		/*WebElement option1 = driver.findElement(By.id("incident.urgency"));
		Select urgencyOpt = new Select(option1);
		urgencyOpt.selectByValue("1");*/
		WebElement urgencyDropdown = driver.findElement(By.id("incident.urgency"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", urgencyDropdown);
		driver.findElement(By.id("incident.urgency")).click();
		driver.findElement(By.xpath("(//option[@value=1])[2]")).click();
				
		WebElement option2 = driver.findElement(By.id("incident.state"));
		Select stateOpt = new Select(option2);
		stateOpt.selectByValue("2");
		
		//driver.findElement(By.xpath("(//option[@value=2])[2]")).click();
		driver.findElement(By.id("sysverb_update")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[@placeholder='Search']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(incidentNum, Keys.ENTER);
		driver.findElement(By.xpath("//a[contains(text(),'"+incidentNum+"')]")).click();
		Thread.sleep(2000);
		String urgencyIndex = driver.findElement(By.id("incident.urgency")).getAttribute("selectedIndex");
		String stateIndex = driver.findElement(By.id("incident.state")).getAttribute("selectedIndex");
		if(urgencyIndex.equals("0") && stateIndex.equals("1"))
			System.out.println("Urgency & State are updated successfully with '1-High' & 'In Progress' values respectively");
		else
			System.out.println("Urgency & State are not updated properly");
		/*String state1 = stateOpt.getFirstSelectedOption().getText();
		System.out.println(state1);*/
		
		/*WebElement option11 = driver.findElement(By.id("incident.state"));
		Select stateOpt1 = new Select(option11);
		String state = stateOpt1.getFirstSelectedOption().getText();
		System.out.println(state);*/
		
		
	}

}
