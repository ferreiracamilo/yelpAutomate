package cucumberOptions;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import pages.BasePage;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue="stepDefinitions",
        plugin = { "pretty" }, //activate the report generation
        monochrome = true, //monochrome set true to assure there won't be special symbols hard to read within the report
        tags="@do" //In order to specify which scenario to be executed meantime are tested to check out if everything is working out
)

public class TestRunner {
    @AfterClass
    public static void cleanDriver(){
        BasePage.closeBrowser();
    }
}
