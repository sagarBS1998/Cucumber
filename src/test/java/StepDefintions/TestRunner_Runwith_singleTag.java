package StepDefintions;


import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/FeatureFilewithTags", 
    glue = {"StepDefintion"},
    tags = "@smoke or @smoking"
    )

public class TestRunner_Runwith_singleTag {

}