//package StepsforHooks;
//
//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import io.cucumber.java.After;
//import io.cucumber.java.Before;
//import io.cucumber.java.*;
//import io.cucumber.java.en.*;
//import jdk.internal.org.jline.utils.Timeout;
//
//public class HooksDemosteps {
//	
//	WebDriver driver = null;
//	
//	
//	@Before("@smoke")
//	
//	public void browerSetup() {
//		System.out.println("inside browser ");
//		
//		System.setProperty("Webdriver.chrom.driver","src/test/resources/webdrivers/chromedriver");
//		driver = new ChromeDriver();
//		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS)	;
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
//		}
//	
//	@Before(value="@smoke",order=1)
//	public void setup2() {
//		System.out.println("inside browser setup 2");
//		
//	}
//	
//	
//	@After
//	
//	public void teardowm() {
//		System.out.println("inside teardown");
//		driver.close();
//		driver.quit();
//	}
//	
//	@BeforeStep
//	public void beforesteps() {
//		System.out.println("inside beforesteps");
//		
//	}
//	
//	
//	@AfterStep
//	public void aftersteps() {
//		System.out.println("inside aftersteps");
//		
//	}
//	
//	@Given("login page")
//	public void login_page() {
//		System.out.println("after ");
//	    // Write code here that turns the phrase above into concrete actions
//	    //throw new io.cucumber.java.PendingException();
//		System.out.println("fdgd");
//	}
//
//	@When("enter email and password")
//	public void enter_email_and_password() {
//	    // Write code here that turns the phrase above into concrete actions
//	    //throw new io.cucumber.java.PendingException();
//		System.out.println("fdgd");
//	}
//
//	@And("click submit")
//	public void click_submit() {
//	    // Write code here that turns the phrase above into concrete actions
//	   // throw new io.cucumber.java.PendingException();
//		System.out.println("fdgd");
//	}
//
//	@Then("navigate to result page")
//	public void navigate_to_result_page() {
//	    // Write code here that turns the phrase above into concrete actions
//	    //throw new io.cucumber.java.PendingException();
//		System.out.println("fdgd");
//		
//	}
//
//
//}
