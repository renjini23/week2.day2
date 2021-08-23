package week2.day2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckboxPage {

	public static void main(String[] args) {
		// To do all activities in Checkbox Page
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/checkbox.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// To select the languages that I know
		driver.findElement(By.xpath("//div[text()='Java']/input")).click();
		driver.findElement(By.xpath("//div[text()='SQL']/input")).click();
		// To confirm if Selenium is checked
		boolean selected = driver.findElement(By.xpath("//div[text()='Selenium']/input")).isSelected();
		if (selected)
			System.out.println("Yes,Selenium is selected");
		else
			System.out.println("No,Selenium is not selected");
		// To deselect the checked value
		WebElement deSelect = driver.findElement(By.xpath("//div[text()='I am Selected']/input"));
		deSelect.click();
		// To select all the checkboxes
		List<WebElement> checkBoxes = driver
				.findElements(By.xpath("//label[text()='Select all below checkboxes ']/following::input"));
		for (int i = 0; i <= checkBoxes.size() - 1; i++)
			checkBoxes.get(i).click();

	}

}
