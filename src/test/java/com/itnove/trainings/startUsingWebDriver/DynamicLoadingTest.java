package com.itnove.trainings.startUsingWebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class DynamicLoadingTest extends BaseTest {
    @Test
    public void noSuchElementErrorTest() {
        driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
        driver.findElement(By.cssSelector("#start button")).click();
        assert driver.findElement(By.cssSelector("#finish")).getText().equals("Hello World!");
    }

    @Test
    public void webDriverWait8Test() {
        driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
        driver.findElement(By.cssSelector("#start button")).click();
        new WebDriverWait(driver, 8).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#finish")));
        assert driver.findElement(By.cssSelector("#finish")).getText().equals("Hello World!");
    }

    @Test
    public void webDriverWaitTimeOutErrorTest() {
        driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
        driver.findElement(By.cssSelector("#start button")).click();
        new WebDriverWait(driver, 2).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#finish")));
        assert driver.findElement(By.cssSelector("#finish")).getText().equals("Hello World!");
    }

    @Test
    public void cleanUpTest() {
        driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
        driver.findElement(By.cssSelector("#start button")).click();
        waitFor(By.cssSelector("#finish"));
        assert driver.findElement(By.cssSelector("#finish")).getText().equals("Hello World!");
    }

    public void waitFor(By locator) {
        new WebDriverWait(driver, 8).until(ExpectedConditions.presenceOfElementLocated(locator));
    }
}