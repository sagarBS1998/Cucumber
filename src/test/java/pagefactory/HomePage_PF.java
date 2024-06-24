package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage_PF {
	WebDriver driver;
	@FindBy(xpath="//*[text()='Help']")
	WebElement btn_help;

public HomePage_PF(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
}
}