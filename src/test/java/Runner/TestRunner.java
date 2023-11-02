package Runner;

import org.junit.runner.RunWith; 

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith (Cucumber.class)
@CucumberOptions(
<<<<<<< HEAD
		features = {"src/test/java/features"},
=======
		features = {"src/test/java/Postfeature"},
>>>>>>> 9f6c65e73c14bd36f3edc078d8d5bc7e1cf487e8
		glue = {"stepDefinitions"},
		plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
		
		monochrome = true, dryRun = false, publish = true)

public class TestRunner {
	
	
}

