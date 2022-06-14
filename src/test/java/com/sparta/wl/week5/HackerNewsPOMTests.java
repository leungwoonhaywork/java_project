package com.sparta.wl.week5;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HackerNewsPOMTests {
    private static WebDriver driver;
    private HNHomepage homepage;

    @BeforeAll
    static void setupAll() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
    }

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        homepage = new HNHomepage(driver);
    }

    @Test
    @DisplayName("Check the past page has yesterday's date")
    void checkThePastHasYesterdaySDate() {
        Assertions.assertTrue(homepage.goToPastPage().isDateYesterday());
    }

}
