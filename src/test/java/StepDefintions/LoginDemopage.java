package StepDefintions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class LoginDemopage {
	WebDriver driver = null;
		// Write code here that turns the phrase above into concrete actions
		//throw new io.cucumber.java.PendingException();
		System.out.println("login page");
		String projectpath = System.getProperty("user.dir");
		System.setProperty("webdrive.chrome.driver",projectpath+"/src/test/resources/webdrivers/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

		driver.navigate().to("https://app.simplelogin.io/auth/login");
		Thread.sleep(2000);
	}

		driver.findElement(By.id("email")).sendKeys(email);
		Thread.sleep(2000);
		driver.findElement(By.id("password")).sendKeys(password);

		Thread.sleep(2000);
	}

	@Then("user navigate to home page")
	public void user_navigate_to_home_page() throws InterruptedException {
		Thread.sleep(2000);

		Thread.sleep(2000);
		driver.close();
		driver.quit();
	}
}
