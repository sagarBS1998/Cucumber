package StepDefintions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.network.Network;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




import java.time.Duration;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class HomePageStep {
    WebDriver driver;
    DevTools devTools;



    @Given("user open the home page")
    public void userOpenTheHomePage() {
        System.out.println("Home page");
        String projectpath = System.getProperty("user.dir");
        System.setProperty("webdrive.chrome.driver",projectpath+"/src/test/resources/webdrivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);
        driver.manage().window().maximize();

        // Navigate to the home page
        driver.get("https://staging-abroadssr-v2.upgrad.dev/study-abroad/");

        String expectedUrl = "https://staging-abroadssr-v2.upgrad.dev/study-abroad/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals("User is not on the expected URL", expectedUrl, actualUrl);


        // Wait for the page title to verify the page has loaded
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.titleContains("One-stop Destination for your entire Study Abroad Journey"));

    }

    @Given("verify page opened")
    public void verifyPageOpened() {
        // Verify the title of the page
        String pageTitle = driver.getTitle();
        String expectedTitle = "One-stop Destination for your entire Study Abroad Journey | upGrad Abroad";
        assertEquals("Page title does not match. Expected: " + expectedTitle + " but got: " + pageTitle, expectedTitle, pageTitle);
        System.out.println("Got page title");
    }

    @Then("identify the form title")
    public void identifyTheFormTitle() {
        // Wait for the form title to load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement formTitleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[normalize-space()='International Degree Now in Your Budget']")));

        // Verify the form title
        String expectedTitle = "International Degree Now in Your Budget";
        String actualTitle = formTitleElement.getText().trim();
        assertEquals("Form title mismatch.", expectedTitle, actualTitle);
        System.out.println(actualTitle);

    }

    @And("Add full name")
    public void addFullName() {
        // Enter full name in the form's input field
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
        nameField.sendKeys("sagar bs");
       // System.out.println(nameField);
    }

    @And("add email address")
    public void addEmailAddress() {
        // Enter email address in the form's input field
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        emailField.sendKeys("sagar@yopmail.com");
       // System.out.println(emailField.getText());
    }

    @And("add phone number")
    public void addPhoneNumber() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement Phone = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mobile")));
        Phone.sendKeys("9999999997");
        //System.out.println(Phone.getText());
        // driver.close();
        //driver.quit();


    }

    //---------------------------------------------------------------



    @And("click on Book your free counseling CTA")
    public void clickOnBookYourFreeCounselingCTA() {
        iSearchForTheActiveButtonOnPopupAndClickIt();
    }

    public void iSearchForTheActiveButtonOnPopupAndClickIt() {
        boolean isButtonClicked = false;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Create a WebDriverWait instance

        try {
            // Find all buttons matching the XPath
            List<WebElement> buttons = driver.findElements(By.xpath("//button[normalize-space()='Book Your Free Counseling']"));

            // Traverse through each button
            for (WebElement button : buttons) {
                if (button.isDisplayed() && button.isEnabled() && isElementInViewport(driver, button)) {
                    try {
                        // Wait until the button is clickable
                        wait.until(ExpectedConditions.elementToBeClickable(button));

                        // Click the button
                        button.click(); // Use regular click method
                        System.out.println("Active button clicked.");
                        isButtonClicked = true; // Mark as clicked
                        break; // Exit the loop after clicking the button
                    } catch (Exception innerEx) {
                        System.err.println("Error clicking the button: " + innerEx.getMessage());
                    }
                }
            }

            if (!isButtonClicked) {
                System.out.println("No active button found or clickable in popup.");
            }
        } catch (Exception e) {
            System.err.println("An error occurred while searching for the active button: " + e.getMessage());
        }
    }

    public boolean isElementInViewport(WebDriver driver, WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        // JavaScript to check if an element is in the viewport
        String script =
                "var rect = arguments[0].getBoundingClientRect();" +
                        "return (" +
                        "rect.top >= 0 && " +
                        "rect.left >= 0 && " +
                        "rect.bottom <= (window.innerHeight || document.documentElement.clientHeight) && " +
                        "rect.right <= (window.innerWidth || document.documentElement.clientWidth)" +
                        ");";
        return (Boolean) jsExecutor.executeScript(script, element);
    }



//---------------------------------------------------------------

    // working code replaced with above code Parth "isElementInViewport" condtion


//    @And("click on Book your free counseling CTA")
//    public void clickOnBookYourFreeCounselingCTA()
//    {
//        iSearchForTheActiveButtonOnPopupAndClickIt();
//    }
//    public void iSearchForTheActiveButtonOnPopupAndClickIt(){
//    {
//            boolean isButtonClicked = false;
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Create a WebDriverWait instance
//            int retryCount = 0; // Retry counter
//            int maxRetries = 1; // Maximum retries to prevent infinite loop
//
//            while (!isButtonClicked && retryCount < maxRetries) {
//                try {
//                    // Find all buttons matching the XPath
//                    List<WebElement> buttons = driver.findElements(By.xpath("//button[normalize-space()='Book Your Free Counseling']"));
//
//                    // Traverse through each button
//                    for (WebElement button : buttons) {
//                        if (button.isDisplayed() && button.isEnabled()) { // Ensure the button is visible and active
//                            try {
//                                // Wait until the button is clickable
//                                wait.until(ExpectedConditions.elementToBeClickable(button));
//
//                                // Click the button
//                                button.click(); // Use regular click method
//                                System.out.println("Active button clicked.");
//                                isButtonClicked = true; // Mark as clicked
//                                break; // Exit the loop after clicking the button
//                            } catch (Exception innerEx) {
//                                System.err.println("Error clicking the button: " + innerEx.getMessage());
//                            }
//                        }
//                    }
//
//                    if (!isButtonClicked) {
//                        System.out.println("No active button found or clickable in popup. Retrying...");
//                    }
//                } catch (Exception e) {
//                    System.err.println("An error occurred while searching for the active button: " + e.getMessage());
//                }
//
//                // Retry mechanism
//                if (!isButtonClicked) {
//                    retryCount++;
//                    if (retryCount < maxRetries) {
//                        try {
//                            Thread.sleep(2000); // Optional: Add a short delay before retrying
//                        } catch (InterruptedException e) {
//                            Thread.currentThread().interrupt(); // Restore the interrupted status
//                            System.err.println("Thread interrupted: " + e.getMessage());
//                        }
//                    } else {
//                        System.err.println("Max retries reached. Could not find or click the active button.");
//                    }
//                }
//            }
//        }
//    }



    @And("enter OTP")
    public void enterOTP() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
//        WebElement OTP = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("//div[@class=' verify__input']//input[@tabindex=\"1\"]")));
//        OTP.sendKeys("1");
        // Loop through the four tabindex values
        for (int i = 1; i <= 4; i++) {
            // Dynamically build the XPath for each input field based on tabindex
            String xpath = "//div[@class='enquiryModule__modal-overlay enquiryModule__form__popup']//input["+i+"]";

            // Wait until the element is visible
            WebElement otpInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));

            // Send the corresponding digit from "1234"
            otpInput.sendKeys(String.valueOf(i));
        }
        System.out.println("OTP entered");



    }

    @Then("find Enter your details to recommend you the best universities & programs! popup")
    public void findEnterYourDetailsToRecommendYouTheBestUniversitiesProgramsPopup() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement form2TitleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Enter your details to recommend you the best unive')]")));

        // Verify the form title
        String expectedTitle = "Enter your details to recommend you the best universities & programs!";
        String actualTitle = form2TitleElement.getText().trim();
        assertEquals("Form title mismatch.", expectedTitle, actualTitle);
        System.out.println(actualTitle);




    }

    @And("select country want to study?")
    public void selectCountryWantToStudy() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement country = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//label[normalize-space()='Germany']")));
        country.click();

    }

    @And("select type of degree want to do")
    public void selectTypeOfDegreeWantToDo() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement degree = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//label[normalize-space()='Masters']")));
        degree.click();
    }

    @And("select nearest upgrad city export")
    public void selectNearestUpgradCityExport() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement upgradcity = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//label[normalize-space()='Delhi/NCR']")));
        upgradcity.click();
    }

    @And("click on next CTA")
    public void clickOnNextCTA() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement Nextcta = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[normalize-space()='Next']")));
        Nextcta.click();
    }

    @Then("find A few more details to customize your study abroad journey! popup")
    public void findAFewMoreDetailsToCustomizeYourStudyAbroadJourneyPopup() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement form3TitleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'A few more details to customize your study abroad ')]")));

        // Verify the form title
        String expectedTitle = "A few more details to customize your study abroad journey!";
        String actualTitle = form3TitleElement.getText().trim();
        assertEquals("Form title mismatch.", expectedTitle, actualTitle);
        System.out.println(actualTitle);
    }

    @And("want to complete bachelors")
    public void wanttocompletebachelors() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement bachelors = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//label[normalize-space()='Yes']")));
        bachelors.click();
    }

    @And("which stream you want")
    public void whichStreamYouWant() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement stream = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//label[normalize-space()='Computer Science']")));
        stream.click();
    }

    @And("have you given any exams yet")
    public void haveYouGivenAnyExamsYet() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        WebElement exams = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//label[normalize-space()='Booked']")));
        exams.click();
        Thread.sleep(2000);
        driver.close();
        driver.quit();
    }


    //---------------------------CDP session creation ------------------------

//    @Given("user open the home page")
//    public void userOpenTheHomePage() {
//        System.out.println("Home page with CDP");
//        String projectpath = System.getProperty("user.dir");
//        System.setProperty("webdrive.chrome.driver",projectpath+"/src/test/resources/webdrivers/chromedriver");
//
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
//        driver = new ChromeDriver(options);
//
//        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
//        driver.manage().window().maximize();
//        System.out.println("Home page with CDP11");
//
//        // Set up DevTools session
//        devTools = ((ChromeDriver) driver).getDevTools();
//        devTools.createSession();
//        System.out.println("Home page with CDP22");
//
//        // Enable network interception
//        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
//
//        // Log all network requests
//        devTools.addListener(Network.requestWillBeSent(), request -> {
//            System.out.println("Request URL: " + request.getRequest().getUrl());
//        });
//
//        // Navigate to the home page
//        driver.get("https://staging-abroadssr-v2.upgrad.dev/study-abroad/");
//
//        String expectedUrl = "https://staging-abroadssr-v2.upgrad.dev/study-abroad/";
//        String actualUrl = driver.getCurrentUrl();
//        Assert.assertEquals("User is not on the expected URL", expectedUrl, actualUrl);
//
//        // Wait for the page title to verify the page has loaded
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//        wait.until(ExpectedConditions.titleContains("One-stop Destination for your entire Study Abroad Journey"));
//    }
}