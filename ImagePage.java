package week2.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImagePage {

	public static void main(String[] args) throws InterruptedException {
		//  To do all activities in Image Page
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Image.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//To click on the image to go to Home Page
		driver.findElement(By.xpath("//label[text()='Click on this image to go home page']/following::img")).click();
		Thread.sleep(2000);
		driver.navigate().back();
		//Am I a broken image? - Not Done
		// Click me using keyboard or mouse
		WebElement keyClick = driver.findElement(By.xpath("//label[text()='Click me using Keyboard or Mouse']/following-sibling::img"));
		keyClick.click();
		Thread.sleep(2000);
		driver.navigate().back();
	}

}
