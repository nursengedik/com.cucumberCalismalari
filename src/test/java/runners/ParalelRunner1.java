package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber-reports1.html",
                "json:target/json-reports/cucumber1.json",
                "junit:target/xml-report/cucumber1.xml"
        },
        features = "src/test/resources/features",
        glue = "stepdefinitions",
        tags = "@smoke",

        dryRun = false
)

public class ParalelRunner1 {//Runner class'ının özelliği methodyn içine yazacağımız kodlar değil
                            //class'ın başına ekleyeceğimiz iki notasyondur


}
