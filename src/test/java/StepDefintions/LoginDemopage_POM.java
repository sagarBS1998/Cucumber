//package StepDefintions;
//
//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import pages.LoginPage;
//
//public class LoginDemopage_POM {
//	LoginPage login;
//	WebDriver driver = null;
//	@Given("brower open")
//	public void brower_open() {
//	    // Write code here that turns the phrase above into concrete actions
//	    //throw new io.cucumber.java.PendingException();
//		
//		System.out.println("===== in POM file======");
//		System.out.println("login page");
//		String projectpath = System.getProperty("user.dir");
//		System.setProperty("webdrive.chrome.driver",projectpath+"/src/test/resources/webdrivers/chromedriver");
//		driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
//		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
//		driver.manage().window().maximize();
//	}
//
//	@And("user on login age")
//	public void user_on_login_age() throws InterruptedException {
//	    // Write code here that turns the phrase above into concrete actions
//	    //throw new io.cucumber.java.PendingException();
//		
//		driver.navigate().to("https://app.simplelogin.io/auth/login");
//		Thread.sleep(2000);
//		System.out.println("login page");
//	}
//
//	@When("^user enter (.*) and (.*)$")
//	public void user_enter_email_and_password(String email, String password) throws Exception {
//	    // Write code here that turns the phrase above into concrete actions
//	    //throw new io.cucumber.java.PendingException();
//		System.out.println("login page");
//		
//		login= new LoginPage(driver);
//		login.enteremail(email);
//		login.enterpassword(password);
//		
//		
//		//driver.findElement(By.id("email")).sendKeys(email);  //Not a POM line
//		Thread.sleep(2000);
//		//driver.findElement(By.id("password")).sendKeys(password);  //Not a POM line
//		System.out.println("login page555555");
//		
//	}
//	@And("user click on submit")
//	public void user_click_on_submit() throws InterruptedException {
//		System.out.println("login page9999");
//		
//		login.clicksubmit();
//		
//	
//		//driver.findElement(By.xpath("//*[text()=\"Log in\"]")).click();  //Not a POM line
//		System.out.println("login page77777");
//
//		Thread.sleep(2000);
//	}
//	
//
//	@Then("user navigate to home page")
//	public void user_navigate_to_home_page() throws InterruptedException {
//	    // Write code here that turns the phrase above into concrete actions
//	    //throw new io.cucumber.java.PendingException();
//		System.out.println("login pageoooooooooo");
//		Thread.sleep(2000);
//		driver.getPageSource().contains("Aliases");  //how to write this in LogenPage.java
//		System.out.println("login page11111111");
//		Thread.sleep(2000);
//		driver.close();
//		Thread.sleep(2000);
//		driver.quit();
//	}
//
//
//}