package TestRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/Feature"},
        glue = {"StepDefintions"},
        monochrome=true,
        tags = "@Home1",
        plugin= {"pretty","html:target/HtmlReport"}
)
public class HomePagerunner {

}
