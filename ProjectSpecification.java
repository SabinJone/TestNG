package dayy;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class ProjectSpecification {
public ChromeDriver driver;
	@BeforeMethod
	
	public void precondition() {
	
	//1. Launch the browser
	ChromeOptions options= new ChromeOptions();
	options.addArguments("--disable-notifications");
	 driver= new ChromeDriver(options);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
	//2. Load the URL
	driver.get("https://login.salesforce.com/");
	
	//3.Enter the username as dilip@testleaf.com
	driver.findElement(By.id("username")).sendKeys("dilip@testleaf.com");
	
	//4.Enter the password as leaf@2024
	driver.findElement(By.xpath("//input[@id='password']")).sendKeys("leaf@2024");
	
	//5.Click on the Login button.
	driver.findElement(By.xpath("//input[@id='Login']")).click();
	

}
	
	@AfterMethod
	public void postcondition() {
	driver.close();
}
}
