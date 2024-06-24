package StepDefintions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import pagefactory.LoginPage_PF;

public class LoginDemopage_PF {
	WebDriver driver = null;
	
	LoginPage_PF login;

	@Given("^browser open manually$")
	public void brower_open() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		
		System.out.println(" I am in login demaopage _pf");
		
		System.out.println("login page");
		String projectpath = System.getProperty("user.dir");
		System.setProperty("webdrive.chrome.driver",projectpath+"/src/test/resources/webdrivers/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@And("user on login age manually")
	public void user_on_login_age() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		driver.navigate().to("https://app.simplelogin.io/auth/login");
		Thread.sleep(2000);
		System.out.println("login page");
	}

	@When("user enter {string} and {string} manualy")
	public void user_enter_email_and_password(String email, String password2) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		System.out.println("login page");
		
		login = new LoginPage_PF(driver);
		
		//login.email(email);
		login.email(email);
		login.password(password2);
		
		//driver.findElement(By.id("email")).sendKeys(email);
		Thread.sleep(2000);
		//driver.findElement(By.id("password")).sendKeys(password2);
		System.out.println("login page555555");
		
	}
	@And("user click on submit manualy")
	public void user_click_on_submit() throws InterruptedException {
		System.out.println("login page9999");
		login.clickonsubmit();
		//driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div/div[2]/div/form/div[3]")).click();
		//driver.findElement(By.xpath("//*[text()=\"Log in\"]")).click();
		System.out.println("login page77777");
		//driver.findElement(By.cssSelector(""));
		Thread.sleep(2000);
	}
	

	@Then("user navigate to home page manualy")
	public void user_navigate_to_home_page() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		System.out.println("login pageoooooooooo");
		Thread.sleep(2000);
		
		login.clickonhelp();
		
		//driver.getPageSource().contains("Aliases");
		System.out.println("login page11111111");
		Thread.sleep(2000);
		driver.close();
		Thread.sleep(2000);
		driver.quit();
	}


}
