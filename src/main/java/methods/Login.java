package methods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class Login extends Driver{

	@FindBy(xpath="/html/body/div[2]/form/input[1]")
    private WebElement email;
	
	@FindBy(xpath="/html/body/div[2]/form/input[2]")
    private WebElement password;
	
	@FindBy(xpath="/html/body/div[2]/form/input[3]")
    private WebElement login;
	
	public Login(WebDriver driver) {
		super(driver);
}

	public void loginPage(String email, String password) {
		 driver.get("https://reizassignment.000webhostapp.com/login.php");
		 this.email.click();
		 this.email.sendKeys(email);
		 this.password.click();
		 this.password.sendKeys(password);
		 this.login.click();
	}
	
	public WebElement email() {
    	return email;
    }
	
	public WebElement password() {
    	return password;
    }
	
	public WebElement login() {
    	return login;
    }
}