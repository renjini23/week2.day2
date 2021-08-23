package week2.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {

	public static void main(String[] args) {
		// To create contact
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.linkText("Create Contact")).click();
		driver.findElement(By.id("firstNameField")).sendKeys("Abhilash");
		driver.findElement(By.id("lastNameField")).sendKeys("Rajendran");

		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("Abhi");
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("Raju");
		driver.findElement(By.id("createContactForm_departmentName")).sendKeys("Software");
		driver.findElement(By.id("createContactForm_description")).sendKeys("Trying Automation");
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("renjini23@gmail.com");
		WebElement state = driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
		Select drpState = new Select(state);
		drpState.selectByVisibleText("New York");
		driver.findElement(By.className("smallSubmit")).click();
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateContactForm_description")).clear();
		driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("Just adding some text");
		driver.findElement(By.xpath("//textarea[@id='updateContactForm_importantNote']/following::input")).click();
		System.out.println(driver.getTitle());

	}

}
