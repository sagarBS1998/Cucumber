package StepDefintions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class LoginDemopage {
	WebDriver driver = null;

	@Given("^browser open$")
	public void browser_open() {
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

	@And("user on login page")
	public void user_on_login_page() throws InterruptedException {
		System.out.println("Navigating to the login page...");
		driver.navigate().to("https://app.simplelogin.io/auth/login");
		Thread.sleep(2000);
	}

	@When("user enter {string} and {string} using page factory")
	public void user_enter_and_using_page_factory(String email, String password) throws InterruptedException {
		System.out.println("Entering email and password...");
		driver.findElement(By.id("email")).sendKeys(email);
		Thread.sleep(2000);
		driver.findElement(By.id("password")).sendKeys(password);
	}

	@And("user click on submit using page factory")
	public void user_click_on_submit_using_page_factory() throws InterruptedException {
		System.out.println("Clicking the login button...");
		driver.findElement(By.xpath("//*[text()='Log in']")).click();
		Thread.sleep(2000);
	}

	@Then("user navigate to home page")
	public void user_navigate_to_home_page() throws InterruptedException {
		System.out.println("Verifying navigation to the home page...");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@href='#' and @class='dropdown-toggle' and text()='Help']")).click();
		System.out.println("Help dropdown clicked.");

		// Cleanup
		Thread.sleep(2000);
		driver.close();
		driver.quit();
	}
}
