package com.sparta.wl.week5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;

public class HNPastPage {
    private WebDriver driver;
    private By pagetop = By.className("pagetop");

    public HNPastPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isDateYesterday() {
        String dateCheck = driver.findElement(By.className("pagetop")).getText();
        LocalDate yesterday = LocalDate.now().minusDays(1);
        return dateCheck.contains(yesterday.toString());
    }

    public boolean isNumberOfItemEquals30() {
        int count = driver.findElements(By.className("athing")).size();
        return count == 30;
    }

    public boolean isNumberOfItemAlwaysEquals30() {
        boolean equals30 = true;
        boolean isMoreExist = driver.findElements(By.className("morelink")).size() > 0;
        while (isMoreExist) {
            if (driver.findElements(By.className("athing")).size() != 30) {
                equals30 = false;
            }
            driver.findElement(By.className("morelink")).click();
            isMoreExist = driver.findElements(By.className("morelink")).size() > 0;
        }
        return equals30;
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }
}
