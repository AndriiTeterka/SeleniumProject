package CartTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EquivalPart {
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
	public void cartEntry() {
		driver.findElement(By.xpath("//button[@onclick=\"cart.add('40');\"]")).click();
		driver.findElement(By.xpath("//a[@title='Shopping Cart']")).click();
	}

	@Test(priority = 1)
	public void Numbers() throws Exception {
		driver.findElement(By.xpath("//input[@type='text' and starts-with(@name, 'quantity')]")).click();
		driver.findElement(By.xpath("//input[@type='text' and starts-with(@name, 'quantity')]")).clear();
		driver.findElement(By.xpath("//input[@type='text' and starts-with(@name, 'quantity')]"))
				.sendKeys("4" + Keys.ENTER);
		Thread.sleep(2000);
		String expMessage = "Success: You have modified your shopping cart!";
		boolean expected = expMessage.contains("Success");
		String actMessage = driver
				.findElement(By.xpath("//div[@class='alert alert-success' and contains(text(), 'Success')]")).getText();
		boolean actual = actMessage.contains("Success");
		Assert.assertEquals(actual, expected, "My_Error");
	}

	@Test(priority = 2)
	public void Letters() throws Exception {
		driver.findElement(By.xpath("//input[@type='text' and starts-with(@name, 'quantity')]")).click();
		driver.findElement(By.xpath("//input[@type='text' and starts-with(@name, 'quantity')]")).clear();
		driver.findElement(By.xpath("//input[@type='text' and starts-with(@name, 'quantity')]"))
				.sendKeys("abcd" + Keys.ENTER);
		Thread.sleep(2000);
		WebElement alertMsg = driver.findElement(By.xpath("//div[@class='alert alert-danger']"));
		Assert.assertEquals(true, alertMsg);
	}

	@Test(priority = 3)
	public void Symbols() throws Exception {
		driver.findElement(By.xpath("//img[@title='Your Store']")).click();
		driver.findElement(By.xpath("//button[@onclick=\"cart.add('40');\"]")).click();
		driver.findElement(By.xpath("//a[@title='Shopping Cart']")).click();
		driver.findElement(By.xpath("//input[@type='text' and starts-with(@name, 'quantity')]")).click();
		driver.findElement(By.xpath("//input[@type='text' and starts-with(@name, 'quantity')]")).clear();
		driver.findElement(By.xpath("//input[@type='text' and starts-with(@name, 'quantity')]"))
				.sendKeys("!@#$%^&*" + Keys.ENTER);
		Thread.sleep(2000);
		WebElement alertMsg = driver.findElement(By.xpath("//div[@class='alert alert-danger']"));
		Assert.assertEquals(true, alertMsg);
	}

	@AfterSuite
	public void turnOff() {
		driver.quit();
	}

}