package week2.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class RedBus {

	public static void main(String[] args) throws InterruptedException {
		// To Book a bus in redbus

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement source = driver.findElement(By.id("src"));
		source.clear();
		source.sendKeys("Chennai");
		Thread.sleep(2000);
		source.sendKeys(Keys.ENTER);
		source.sendKeys(Keys.TAB);
		WebElement dest = driver.findElement(By.id("dest"));
		dest.sendKeys("Bangalore");
		Thread.sleep(2000);
		dest.sendKeys(Keys.ENTER);
		dest.sendKeys(Keys.TAB);
		WebElement date = driver.findElement(By.id("onward_cal"));
		date.click();
		driver.findElement(By.xpath("//td[@class='current day']")).click();
		date.sendKeys(Keys.TAB);
		driver.findElement(By.id("search_btn")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='close']/i")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='close-primo']/i")).click();
		String noOfBuses = driver.findElement(By.xpath("//span[@class='f-bold busFound']")).getText();
		System.out.println("Total no of buses from Chennai to Bangalore is :- " + noOfBuses);
		driver.executeScript("window.scrollBy(0,300)");
		WebElement sleeper = driver.findElement(By.xpath("//input[@id='bt_SLEEPER']/../label[2]"));
		sleeper.click();
		Thread.sleep(5000);
		String noOfSleepers = driver.findElement(By.xpath("//span[@class='f-bold busFound']")).getText();
		System.out.println("No Of Sleeper Buses :- " + noOfSleepers);
		driver.executeScript("window.scrollBy(0,300)");
		sleeper.click();
		WebElement ac = driver.findElement(By.xpath("//input[@id='bt_AC']/../label[2]"));
		ac.click();
		Thread.sleep(2000);
		String noOfAc = driver.findElement(By.xpath("//span[@class='f-bold busFound']")).getText();
		System.out.println("No Of AC Buses :- " + noOfAc);
		driver.executeScript("window.scrollBy(0,300)");
		ac.click();
		Thread.sleep(2000);
		driver.executeScript("window.scrollBy(0,300)");
		WebElement nonAc = driver.findElement(By.xpath("//input[@id='bt_NONAC']/../label[2]"));
		nonAc.click();
		Thread.sleep(2000);
		String noOfNonAc = driver.findElement(By.xpath("//span[@class='f-bold busFound']")).getText();
		System.out.println("No Of Non-AC Buses :- " + noOfNonAc);
		driver.close();
	}

}
