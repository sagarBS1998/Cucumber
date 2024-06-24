package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;
	By txt_email =By.id("email");
	By txt_password = By.id("password");
	By btn_submit = By.xpath("//*[text()=\"Log in\"]");
	//By btn_navi = contains("Aliases");
	
	public LoginPage(WebDriver driver) throws Exception {
		this.driver = driver;
//		if(!driver.getTitle().equals("Alias|SimpleLogin")) {
//			throw new Exception("this not the page"+driver.getCurrentUrl());
//		}
	}
	
	public void enteremail(String email1) {
		driver.findElement(txt_email).sendKeys(email1);
		
	}
	public void enterpassword(String password1) {
		driver.findElement(txt_password).sendKeys(password1);
		
	}
	public void clicksubmit() {
		driver.findElement(btn_submit).click();
		
	}


}
