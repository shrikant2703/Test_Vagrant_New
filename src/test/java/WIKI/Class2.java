package WIKI;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

 
public class Class2 
{
	WebDriver driver;
	
  @BeforeMethod
  public void lounchBrowser()
  {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  driver.get("https://en.wikipedia.org/wiki/Main_Page");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
	  
	  driver.findElement(By.name("search")).sendKeys("Pushpa: The Rise");
	  driver.findElement(By.name("go")).click();
	  WebElement date = driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div[1]/table[1]/tbody/tr[12]/td"));
	  String date1 = date.getText();
	  System.out.println("Release date is "+date1);
	  Assert.assertEquals(date1, "17 December 2021");
  }
  
  @Test
  public void test1()
  {
	  WebElement date = driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div[1]/table[1]/tbody/tr[12]/td"));
	  String date1 = date.getText();
	  System.out.println("Release date is "+date1);
	  Assert.assertEquals(date1, "17 December 2021");
  }
  
  @Test
  public void test2()
  {
	  WebElement country = driver.findElement(By.xpath("//td[text()='India']"));
	 String country1 = country.getText();
	 System.out.println("Release Country is "+country1);
	 Assert.assertEquals(country1, "India");
  }
  
  @AfterMethod
  public void closebrowser()
  {
	  driver.close();
  }
  
  

}

