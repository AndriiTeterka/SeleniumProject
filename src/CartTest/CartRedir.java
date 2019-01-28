package CartTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CartRedir {
	public WebDriver driver;

	@BeforeSuite
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://taqc-opencart.epizy.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@BeforeTest
	public void cartAdd() {
		driver.findElement(By.xpath("//button[@onclick=\"cart.add('40');\"]")).click();
	}

	@Test(priority = 1)
	public void cartLink() throws Exception {
		driver.findElement(By.xpath("//a[@title='Shopping Cart']")).click();
		
	}

	@Test(priority = 2)
	public void alertCartLink() throws Exception {
		driver.findElement(By.xpath("//img[@title='Your Store']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@onclick=\"cart.add('40');\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(), 'shopping cart')]"));
	}

	@Test(priority = 3)
	public void cartLiііnk() throws Exception {
		driver.findElement(By.xpath("//img[@title='Your Store']")).click();
		driver.findElement(By.xpath("//button[@onclick=\"cart.add('40');\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@title='Shopping Cart']")).click();
	}

	@AfterSuite
	public void turnOff() {
		driver.quit();
	}
}
