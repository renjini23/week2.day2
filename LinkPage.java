package week2.day2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LinkPage {

	public static void main(String[] args) throws InterruptedException {
		// To do all activities in Link Page
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Link.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// To go to Home Page
		driver.findElement(By.xpath("//a[text()='Go to Home Page']")).click();
		Thread.sleep(2000);
		driver.navigate().back();
		// To find where am I supposed to go without clicking me?
		String href = driver.findElement(By.linkText("Find where am supposed to go without clicking me?"))
				.getAttribute("href");
		System.out.println("I am supposed to go to the " + href + " page");
		// To verify if the link is broken
		driver.findElement(By.xpath("//a[text()='Verify am I broken?']")).click();
		String title = driver.getTitle();
		if (title.contains("Not Found")) {
			System.out.println("Given Link is broken");
		} else {
			System.out.println("Given Link is not broken");
		}
		driver.navigate().back();
		// To Go to Home Page (Interact with same link name)
		driver.findElement(By.linkText("Go to Home Page")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//h5[text()='HyperLink']/following-sibling::img")).click();
		// To find the number of links in the page
		List<WebElement> findElements = driver.findElements(By.tagName("a"));
		System.out.println("No of elements in this page are " + findElements.size());

	}

}
