package week2.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ButtonPage {

	public static void main(String[] args) throws InterruptedException {
		// To do all activities in Button Page
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Button.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Click button to navigate to Home page and back to Button Page
		driver.findElement(By.id("home")).click();
		Thread.sleep(2000);
		driver.navigate().back();
		// To find the position of Button
		Point location = driver.findElement(By.xpath("//button[text()='Get Position']")).getLocation();
		System.out.println("Position of the Button is " + location);
		// Could not get the color of the button
		// driver.findElement(By.xpath("//button[text()='What color am I?']")).
		// To find the height and width of the button
		Dimension size = driver.findElement(By.xpath("//button[text()='What is my size?']")).getSize();
		System.out.println("Size of the Button is " + size);

	}

}
