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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class IELTSPageStep {

    WebDriver driver; // WebDriver instance
    WebDriverWait wait;

    @Given("user open the home page1")
    public void userOpenTheHomePage1() {
        System.out.println("IELTS page");
        String projectpath = System.getProperty("user.dir");
        System.setProperty("webdrive.chrome.driver", projectpath + "/src/test/resources/webdrivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        // Navigate to the home page
        driver.get("https://staging-abroadssr-v2.upgrad.dev/study-abroad/exam/ielts/overview/");

        String expectedUrl = "https://staging-abroadssr-v2.upgrad.dev/study-abroad/exam/ielts/overview/";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("User is not on the expected URL", expectedUrl, actualUrl);


        // Wait for the page title to verify the page has loaded
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        wait.until(ExpectedConditions.titleContains("IELTS Exam Details | IELTS Online Test | IELTS Full Form"));

    }

    @Given("verify page opened1")
    public void verifyPageOpened1() {
        // Verify the title of the page
        String pageTitle = driver.getTitle();
        String expectedTitle = "IELTS Exam Details | IELTS Online Test | IELTS Full Form";
        assertEquals("Page title does not match. Expected: " + expectedTitle + " but got: " + pageTitle, expectedTitle, pageTitle);
        System.out.println("Got page title");
    }


    @Then("verify delay popup is opend1")
    public void verifyDelayPopupIsOpend1() {
        // WebDriverWait wait = 10;

        try {
            // Initialize the WebDriverWait object if not already done
            wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust the timeout as needed

            // Wait for the popup to be visible using the provided XPath
            WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='__next']/div/div[4]/div/div/div[2]")));

            // Assert that the popup is displayed
            assert popup.isDisplayed() : "Popup is not displayed!";
            System.out.println("Popup is displayed successfully.");
        } catch (Exception e) {
            // Handle exceptions gracefully
            System.out.println("Failed to verify delay popup: " + e.getMessage());
            throw e; // Optionally re-throw the exception if the test should fail
        }

    }

    @Then("verify the text Unlock Your SAT Success: Explore Expert Articles & Tips Now!")
    public void verifyTheTextUnlockYourSATSuccessExploreExpertArticlesTipsNow() {
        // Locate the popup text element
        System.out.println("Find popup text element...");

        WebElement popupText = driver.findElement(By.xpath("//h2[@class='enquiryForm__heading-sidebar' and contains(text(),'Explore more about study abroad programs')]"));
        String expectedText = "Explore more about study abroad programs";
        String actualText = popupText.getText();
        assert actualText.equals(expectedText) : "Expected text: " + expectedText + ", but found: " + actualText;
    }

    @And("add email address1")
    public void addEmailAddress1() {
        findAndInteractWithActiveInputBox(); // same code can used it for finding elements in page and select active field on popup
    }

    public void findAndInteractWithActiveInputBox() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Create a WebDriverWait instance

        try {
            // Find all input text boxes matching the XPath or other locator
            List<WebElement> inputFields = driver.findElements(By.xpath("//input[@type='text' or @type='email']"));

            // Traverse through each input box
            for (WebElement inputBox : inputFields) {
                if (inputBox.isDisplayed() && inputBox.isEnabled() && isElementInViewport(driver, inputBox)) {
                    try {
                        // Wait until the input box is visible and enabled
                        wait.until(ExpectedConditions.visibilityOf(inputBox));
                        wait.until(ExpectedConditions.elementToBeClickable(inputBox));

                        // Interact with the input box by entering the email address
                        inputBox.sendKeys("sagar@yopmail.com");
                        System.out.println("Email address entered in active input box.");
                        break; // Exit the loop after interacting with the first valid input box
                    } catch (Exception innerEx) {
                        System.err.println("Error interacting with the input box: " + innerEx.getMessage());
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("An error occurred while searching for the active input box: " + e.getMessage());
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

}

//    public boolean isElementInViewport(WebDriver driver, WebElement element) {
//        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//        // JavaScript to check if an element is in the viewport
//        String script =
//                "var rect = arguments[0].getBoundingClientRect();" +
//                        "return (" +
//                        "rect.top >= 0 && " +
//                        "rect.left >= 0 && " +
//                        "rect.bottom <= (window.innerHeight || document.documentElement.clientHeight) && " +
//                        "rect.right <= (window.innerWidth || document.documentElement.clientWidth)" +
//                        ");";
//        return (Boolean) jsExecutor.executeScript(script, element);
//    }


//    {
//        // Enter email address in the form's input field
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
//        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
//        emailField.sendKeys("sagar@yopmail.com");
//        // System.out.println(emailField.getText());
//    }

