package cucumberOptions;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		// path of feature file
		features = { "C:\\work-stuff\\workspace\\com.irtc\\src\\test\\java\\com\\cucumber\\LoginFeature.feature" },
		
		glue = "com.StepDefinations", 
		plugin = { "pretty", "json:target/cucumber-reports/reports.json",
				"junit:target/cucumber-reports/Cucumber.xml",
	            "html:target/cucumber-reports/reports2.html" }, 
		monochrome = true,
		dryRun = false

)
public class TestRunner {

}
