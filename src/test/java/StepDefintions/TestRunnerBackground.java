package StepDefintions;


import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = {"src/test/resources/Feature/BackgroundDemo/"}, 
    glue = {"StepsBackgroundDemo"},
    monochrome=true,
    plugin= {"pretty","junit:target/junitreport/report.xml","json:target/junitreport/HtmlReports",
    		"html:target/junitreport/HtmlReports"}
    )


public class TestRunnerBackground {

}




//  //tagname[@attribute="value"]