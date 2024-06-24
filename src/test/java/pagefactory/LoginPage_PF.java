package pagefactory;

import java.sql.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage_PF {
	
	WebDriver driver;
	
	@FindBy(xpath="//input[@class='form-control' and @id='email' and @name='email' and @type='email' and @required]")
	WebElement txt_email1;
	
	@FindBy(name="password")
	WebElement txt_password1;
	
	@FindBy(xpath="//*[text()=\"Log in\"]")
	WebElement btn_submit1;
	
	@FindBy(xpath="//a[@href='#' and @class='dropdown-toggle' and @data-toggle='dropdown' and text()='Help']")
	WebElement btn_help;
	
	public LoginPage_PF(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void email(	CharSequence email) {
		txt_email1.click();
	
		txt_email1.sendKeys(email);
	}

	public void password(String password) {
		txt_password1.sendKeys(password);
		
	}
	public void clickonsubmit(){
		btn_submit1.click();
	}
	public void clickonhelp(){
		btn_help.click();
	}

}
