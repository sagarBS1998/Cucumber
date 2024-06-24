package StepDefintions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleSearchpage {
	WebDriver driver = null;
	@Given("open browser")
	public void open_browser() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		String projectpath = System.getProperty("user.dir");
		System.setProperty("webdrive.chrome.driver",projectpath+"/src/test/resources/webdrivers/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		System.out.println("sdfsdfwef");
	}

	@And("user on google page")
	public void user_on_google_page() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		driver.navigate().to("https:google.com");
		Thread.sleep(2000);
		
		
		
		
		System.out.println("sdfsdfwef");
	}

	@When("user enter text")
	public void user_enter_text() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
		driver.findElement(By.name("q")).sendKeys("Automation step by step");
		System.out.println("sdfsdfwef");
		Thread.sleep(2000);
	}

	@And("hit enter")
	public void hit_enter() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	    System.out.println("sdfsdfwef");
	    driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	    Thread.sleep(2000);
	}

	@Then("user navigated search result page")
	public void user_navigated_search_result_page() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		System.out.println("sdfsdfwef1111111111");
		driver.getPageSource().contains("online cources");
		System.out.println("sdfsdfwef12222222");
		Thread.sleep(4000);
		driver.close();
		driver.quit();
		
	}

}
