package tests;
import methods.*;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class LoginTests {

	public WebDriver driver;
	public Login login;


	@Test(priority=1)
	public void WrongDetails() throws InterruptedException {
	login = new Login(driver);
	login.loginPage("a.pocius@yahoo.com", "123456");
    Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/form/p[2]")).getText(), "Wrong email"); 
	}
	
	@Test(priority=2)
	public void WrongEmail() throws InterruptedException {
	login = new Login(driver);
	login.loginPage("a.pocius@yahoo.com", "Labas123");
    Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/form/p[2]")).getText(), "Wrong email"); 
	}
	
	@Test(priority=3)
	public void WrongPassword() throws InterruptedException {
	login = new Login(driver);
	login.loginPage("vaidas.pocius@yahoo.com", "123456");
    Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "Wrong password"); 
	}
	
	@Test(priority=4)
	public void SuccessfulLogin() throws InterruptedException {
	login = new Login(driver);
	login.loginPage("vaidas.pocius@yahoo.com", "Labas123");
    Assert.assertEquals(driver.findElement(By.tagName("h1")).getText(), "Hello vaidas.pocius@yahoo.com"); 
	}

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

//	@AfterClass
//	public void afterClass() {
//     	driver.quit();
//	}
}
