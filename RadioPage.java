package week2.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RadioPage {

	public static void main(String[] args) {
		// To do all activities in Radio Page
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/radio.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// To select an answer for 'Are you enjoying the classes?'
		driver.findElement(By.id("yes")).click();
		// To get the value of selected radio button
		String defaultText = driver
				.findElement(
						By.xpath("//label[text()='Find default selected radio button']/following-sibling::label[2]"))
				.getText();
		System.out.println("Default Selected Radio Button is:- " + defaultText);
		// Select Age group if not selected
		WebElement ageGroup = driver
				.findElement(By.xpath("//label[contains(text(),'Select your age group')]/following-sibling::input[3]"));
		if (!ageGroup.isSelected())
			ageGroup.click();

	}

}
