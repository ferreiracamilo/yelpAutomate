package cucumberOptions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import pages.BasePage;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue="stepDefinitions",
        publish = true,
        monochrome = true,
        tags = "@do" //In order to specify which scenario to be executed meantime are tested to check out if everything is working out
)

public class TestRunner {
    @AfterClass
    public static void cleanDriver(){
        BasePage.closeBrowser();
    }
}
