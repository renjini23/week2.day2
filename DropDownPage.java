package week2.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownPage {

	public static void main(String[] args) {
		// To do all activities in DropDown Page
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Dropdown.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Select training program using Index
		WebElement findTraining = driver.findElement(By.id("dropdown1"));
		Select drpTraining = new Select(findTraining);
		drpTraining.selectByIndex(1);
		// Select training program using Text
		WebElement findText = driver
				.findElement(By.xpath("//option[text()='Select training program using Text']/parent::select"));
		Select drpText = new Select(findText);
		drpText.selectByVisibleText("Appium");
		// Select training program using Value
		WebElement findValue = driver.findElement(By.id("dropdown3"));
		Select drpValue = new Select(findValue);
		drpValue.selectByValue("4");
		// Get the number of drop-down options
		WebElement findOptions = driver
				.findElement(By.xpath("//option[text()='Get the number of dropdown options']/.."));
		Select noOfOptions = new Select(findOptions);
		System.out.println("No of Options in the drop-down is:- " + noOfOptions.getOptions().size());
		// Use sendKeys to select
		WebElement keySelect = driver
				.findElement(By.xpath("//option[text()='You can also use sendKeys to select']/.."));
		keySelect.sendKeys("UFT/QTP");
		// To select a value using mouse click - Not Done

	}

}
