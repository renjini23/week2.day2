package week2.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {
		// To Edit a Lead
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		// Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Name and ID']")).click();
		driver.findElement(By.xpath("(//label[text()='Lead ID:']/parent::div)/following::div/div/input"))
				.sendKeys("Renjini");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		String pageTitle = driver.getTitle();
		if (pageTitle.contains("View Lead"))
			System.out.println("We are in View Leads Page");
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("VirtusaPolaris");
		driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
		String companyName = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		String[] companyFirst = companyName.split(" ");
		if (companyName.contains("VirtusaPolaris"))
			System.out.println("Yes,We Edited the Lead Company to " + companyFirst[0]);
		else
			System.out.println("No , We haven't edited the Lead");
		driver.close();

	}

}
