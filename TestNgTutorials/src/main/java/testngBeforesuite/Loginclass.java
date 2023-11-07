package testngBeforesuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Loginclass {

	WebDriver driver = new ChromeDriver();

	@BeforeSuite
	public void LaunchBrowser() {
		driver.manage().window().maximize();
		driver.get("http://localhost:8080/login?from=%2F");
		System.out.println("Browser is Launched Successfully");
	}

	@Parameters({ "username", "password" })
	@Test()
	public void checkLogin(String username, String password) {

		driver.findElement(By.xpath("//*[@id=\'j_username\']")).sendKeys(username);
		driver.findElement(By.xpath("//*[@id=\'j_password\']")).sendKeys(password);
		driver.findElement(By.xpath("//*[@name=\'Submit\']")).click();
		driver.findElement(By.xpath("//*[@id=\'page-header\']/div[3]/a[2]/span")).click();
		System.out.println("The login process on Jenkins is completed");
	}
	
	@AfterSuite
	public void Closingbrowseroperations() {
		
		driver.quit();
		System.out.println("Browser operation is closed successfully");		
	}
}
