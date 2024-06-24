package StepDefintions;


import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = {"src/test/resources/Feature"}, 
    glue = {"StepDefintions"},
        tags = "@logon_demo",
    monochrome=true,
    plugin= {"pretty","html:target/HtmlReport"}
    )

public class TestRunner {

}