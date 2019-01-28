package CartTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
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

	@Test(priority = 1)
	public void cartLink() throws Exception {
		driver.findElement(By.xpath("//button[@onclick=\"cart.add('40');\"]")).click();
		driver.findElement(By.xpath("//a[@title='Shopping Cart']")).click();
		String expected = "Shopping Cart  (10.00kg)";
		String actual = driver.findElement(By.xpath("//div[@class='col-sm-12']/h1")).getText();
		Assert.assertEquals(actual, expected, "My_Error");
		driver.findElement(By.xpath("//button[@data-original-title='Remove']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@title='Your Store']")).click();
	}

	@Test(priority = 2)
	public void alertCartLink() throws Exception {
		driver.findElement(By.xpath("//button[@onclick=\"cart.add('40');\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(), 'shopping cart')]")).click();
		String expected = "Shopping Cart  (10.00kg)";
		String actual = driver.findElement(By.xpath("//div[@class='col-sm-12']/h1")).getText();
		Assert.assertEquals(actual, expected, "My_Error");
		driver.findElement(By.xpath("//button[@data-original-title='Remove']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@title='Your Store']")).click();
	}

	@Test(priority = 3)
	public void cartLiііnk() throws Exception {
		driver.findElement(By.xpath("//button[@onclick=\"cart.add('40');\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@id='cart-total']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//p[@class='text-right']/a[1]/strong")).click();
		Thread.sleep(2000);
		String expected = "Shopping Cart  (10.00kg)";
		String actual = driver.findElement(By.xpath("//div[@class='col-sm-12']/h1")).getText();
		Assert.assertEquals(actual, expected, "My_Error");
		driver.findElement(By.xpath("//button[@data-original-title='Remove']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@title='Your Store']")).click();
	}

	@AfterSuite
	public void turnOff() {
		driver.quit();
	}
}
