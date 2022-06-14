package bdd.stepdefs;
import com.sparta.wl.week5.HNHomepage;
import com.sparta.wl.week5.HNPastPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.time.LocalDate;

public class MyStepdefs {
    private WebDriver driver;
    private HNHomepage homepage;
    private HNPastPage pastPage;
    private static ChromeOptions options;
    private static ChromeDriverService services;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        options = new ChromeOptions();
        options.addArguments("headless");
        services = new ChromeDriverService.Builder().usingDriverExecutable(new File("src/test/resources/chromedriver.exe")).usingAnyFreePort().build();
        driver = new ChromeDriver(options);
    }

    @Given("I am on the homepage")
    public void iAmOnTheHomepage() {
        homepage = new HNHomepage(driver);
    }

    @When("I click the pasts link")
    public void iClickThePastsLink() {
        pastPage = homepage.goToPastPage();
    }

    @Then("I will go to the past page")
    public void iWillGoToThePastPage() {
        Assertions.assertEquals("https://news.ycombinator.com/front", pastPage.getUrl());
    }

    @Then("I will see the yesterday date")
    public void iWillSeeTheYesterdayDate() {
        driver.findElement(By.linkText("past")).click();
        String dateCheck = driver.findElement(By.className("pagetop")).getText();
        LocalDate yesterday = LocalDate.now().minusDays(1);
        boolean correctDate = dateCheck.contains(yesterday.toString());
        Assertions.assertTrue(correctDate);
    }

    @After
    public void teardown() {
        driver.close();
        driver.quit();
        services.stop();
    }
}
