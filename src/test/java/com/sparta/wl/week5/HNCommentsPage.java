package com.sparta.wl.week5;

import org.openqa.selenium.WebDriver;

public class HNCommentsPage {
    private WebDriver driver;

    public HNCommentsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }
}
