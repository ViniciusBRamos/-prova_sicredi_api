package Runner;



import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/automacaoapi/desafio.feature",
		glue = "src/test/java/Runner/ControlSteps.java"
		
		)

public class Runner {

	
}
