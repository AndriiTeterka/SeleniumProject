package CartTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class RemoveFunc {
	public WebDriver driver;

	@BeforeSuite
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://taqc-opencart.epizy.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test(priority = 2)
	public void removeTest() throws Exception {
		driver.findElement(By.xpath("//a[@title='Shopping Cart']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@data-original-title='Remove']")).click();
		Thread.sleep(2000);
		String expected = "Your shopping cart is empty!";
		String actual = driver.findElement(By.xpath("//div[@id='content']/p")).getText();
		Assert.assertEquals(actual, expected, "My_Error");
		driver.findElement(By.xpath("//img[@title='Your Store']")).click();
		Thread.sleep(2000);

	}

}
