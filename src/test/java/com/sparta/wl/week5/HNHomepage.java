package com.sparta.wl.week5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HNHomepage {
    private WebDriver driver;
    By comments = new By.ByLinkText("comments");
    By past = new By.ByLinkText("past");

    public HNHomepage(WebDriver driver) {
        this.driver = driver;
        driver.get("https://news.ycombinator.com/");
    }

    public HNCommentsPage goToCommentsPage() {
        driver.findElement(comments).click();
        return new HNCommentsPage(driver);
    }

    public HNPastPage goToPastPage() {
        driver.findElement(past).click();
        return new HNPastPage(driver);
    }

    public void goToHomepage() {
        driver.get("https://news.ycombinator.com/");
    }
}
