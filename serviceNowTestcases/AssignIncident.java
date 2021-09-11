package serviceNowTestcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class AssignIncident extends CommonClass {

	@Test
	public void runAssignIncident() throws InterruptedException {
		System.out.println("Assign Incident");
		String incidentNum="INC0010018";
		System.out.println("Title of current WebPage : "+driver.getTitle());
		driver.findElement(By.xpath("//input[@placeholder='Search']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(incidentNum, Keys.ENTER);
		Thread.sleep(1000);
		String searchResult = driver.findElement(By.xpath("//a[contains(text(),'"+incidentNum+"')]")).getText();
		driver.findElement(By.xpath("//a[contains(text(),'"+incidentNum+"')]")).click();
		driver.findElement(By.id("sys_display.incident.assignment_group")).clear();
		driver.findElement(By.id("sys_display.incident.assignment_group")).sendKeys("So");
		Thread.sleep(1000);
		driver.findElement(By.id("sys_display.incident.assignment_group")).sendKeys(Keys.TAB);
		WebElement workNotes = driver.findElement(By.id("activity-stream-textarea"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", workNotes);
		//driver.executeScript(js, workNotes);
		workNotes.sendKeys("Assignment through Automation");
		driver.findElement(By.id("sysverb_update")).click();

		//Verify the Assigned Group
		driver.findElement(By.xpath("//input[@placeholder='Search']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(incidentNum, Keys.ENTER);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[contains(text(),'"+incidentNum+"')]")).click();
		Thread.sleep(2000);
		String assignGroup = driver.findElement(By.id("sys_display.incident.assignment_group")).getAttribute("value");
		System.out.println("Group Assigned to : "+assignGroup);		
		if(assignGroup.equals("Software"))
			System.out.println("Group Assignment is successful");
		else
			System.out.println("Group Assignment is Unsuccessful");
	}

}
