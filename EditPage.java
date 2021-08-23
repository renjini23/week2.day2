package week2.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditPage {

	public static void main(String[] args) {
		// To do all activities in Edit Page
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Edit.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// To enter the e-mail address
		driver.findElement(By.id("email")).sendKeys("renjini23@gmail.com");
		// To append a text and press keyboard Tab
		WebElement append = driver.findElement(
				By.xpath("//label[contains(text(),'Append a text and press keyboard tab')]/following::input"));
		// String text2 = text1.getAttribute("value");
		append.sendKeys("" + "a text", Keys.TAB);
		// To get the default text entered
		WebElement defaultValue = driver
				.findElement(By.xpath("//label[contains(text(),'Get default text entered')]/following::input"));
		System.out.print("Default text entered is:- ");
		System.out.print(defaultValue.getAttribute("value"));
		// To clear the text
		WebElement clearField = driver.findElement(By.xpath("//label[(text()='Clear the text')]/following::input"));
		clearField.clear();
		// To confirm that edit field is disabled
		WebElement disableField = driver
				.findElement(By.xpath("//label[(text()='Confirm that edit field is disabled')]/following::input"));
		System.out.println("");
		if (disableField.isEnabled()) {
			System.out.println("Edit field is enabled");
		} else {
			System.out.println("Edit field is disabled");
		}

	}

}
