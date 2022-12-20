package IMDB;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Class1 
{
	
	WebDriver driver;
    @BeforeClass
	public void lounchBrowser()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.imdb.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Pushpa: The rise");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		driver.findElement(By.xpath("//img[@alt='Allu Arjun in Pushpa: The Rise - Part 1 (2021)'][1]")).click();
	}

	@Test
	public void test1()
	{
		WebElement date = driver.findElement(By.xpath("//a[text()='December 17, 2021 (United States)']"));
			String date1 = date.getText();
			System.out.println("release date is "+date1);
			Assert.assertEquals(date1, "December 17, 2021 (United States)");
	}

	@Test
	public void test2()
	{
	    WebElement country = driver.findElement(By.xpath("//a[text()='India']"));
            String country1 = country.getText();
			System.out.println("Release country is "+country1);
			Assert.assertEquals(country1, "India");
	}

    @AfterClass
	public void closeBrowser()
	{
		driver.close();
	}
}



