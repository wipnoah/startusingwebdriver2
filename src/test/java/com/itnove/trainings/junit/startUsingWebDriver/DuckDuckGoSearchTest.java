package com.itnove.trainings.junit.startUsingWebDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DuckDuckGoSearchTest {
    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver",
                "src" + File.separator + "main"
                        + File.separator + "resources"
                        + File.separator + "geckodriver-linux");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testSearch() throws Exception {
        driver.get("https://duckduckgo.com/");
        driver.findElement(By.id("search_form_input_homepage")).click();
        driver.findElement(By.id("search_form_input_homepage")).clear();
        driver.findElement(By.id("search_form_input_homepage")).sendKeys("pizza hawaiana");
        driver.findElement(By.id("search_form_homepage")).submit();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}