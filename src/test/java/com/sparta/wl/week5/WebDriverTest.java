package com.sparta.wl.week5;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class WebDriverTest {
    private static WebDriver driver;
    private static ChromeOptions options;
    private static ChromeDriverService services;

    @BeforeAll
    static void setupAll() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        options = new ChromeOptions();
        options.addArguments("headless");
        services = new ChromeDriverService.Builder().usingDriverExecutable(new File("src/test/resources/chromedriver.exe")).usingAnyFreePort().build();
    }

    @BeforeEach
    void setup() {
        driver = new ChromeDriver(options);
        //driver = new ChromeDriver(options);
        driver.get("https://news.ycombinator.com/");
    }

    @Test
    @DisplayName("Check that the past link works")
    void checkThatThePastLinkWorks() {
        driver.findElement(By.linkText("past")).click();
        Assertions.assertEquals("https://news.ycombinator.com/front", driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Check that we can search for Java")
    void checkThatWeCanSearchForJava() {
        driver.findElement(By.name("q")).sendKeys("Java", Keys.ENTER);
        //Assertions.assertEquals("https://hn.algolia.com/?q=Java", driver.getCurrentUrl());
        String result = driver.findElement(By.className("SearchInput")).getAttribute("value");
        Assertions.assertEquals("Java", result);
    }

    @Test
    @DisplayName("Check the date must be yesterday date")
    void checkTheDateMustBeYesterdayDate() {
        driver.findElement(By.linkText("past")).click();
        String dateCheck = driver.findElement(By.className("pagetop")).getText();
        LocalDate yesterday = LocalDate.now().minusDays(1);
        boolean correctDate = dateCheck.contains(yesterday.toString());
    }

    @Nested
    @DisplayName("Test number of item")
    class testNumberOfItem {
        @Test
        @DisplayName("Check number of item = 30")
        void checkNumberOfItemEquals30() {
            driver.findElement(By.linkText("past")).click();
            int count = driver.findElements(By.className("athing")).size();
            Assertions.assertEquals(30, count);
        }

        @ParameterizedTest
        @MethodSource("testListNumberOfItem")
        @DisplayName("Check number of item always = 30")
        void checkNumberOfItemAlwaysEquals30(int numberOfItem) {
            Assertions.assertEquals(30, numberOfItem);
        }

        static List<Integer> testListNumberOfItem() {
            List<Integer> numberOfItemList = new ArrayList<>();
            driver = new ChromeDriver(options);
            //driver = new ChromeDriver();
            driver.get("https://news.ycombinator.com/");
            driver.findElement(By.linkText("past")).click();
            boolean isMoreExist = driver.findElements(By.className("morelink")).size() > 0;
            while (isMoreExist) {
                int count = driver.findElements(By.className("athing")).size();
                numberOfItemList.add(count);
                driver.findElement(By.className("morelink")).click();
                isMoreExist = driver.findElements(By.className("morelink")).size() > 0;
            }
            return numberOfItemList;
        }
    }

    @AfterEach
    void teardown() {
        driver.close();
    }

    @AfterAll
    static void teatdownAll() {
        driver.quit();
        services.stop();
    }
}
