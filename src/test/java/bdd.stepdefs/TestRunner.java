package bdd.stepdefs;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features"},plugin = {"pretty", "html:target/testReport.html", "json:target/jsonReport.json"}, publish = true, tags = "@pastsTest")
public class TestRunner {

}
