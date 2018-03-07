package com.itnove.trainings.junit.startUsingWebDriver;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class InterrogationOptionsTest {

    public WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.gecko.driver",
                "src" + File.separator + "main"
                        + File.separator + "resources"
                        + File.separator + "geckodriver-linux");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void InterrogationActions(){
        driver.navigate().to("http://www.google.com");
        System.out.println(driver.getPageSource());
        System.out.println("Title " +driver.getTitle());
        System.out.println("URL " +driver.getCurrentUrl());
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
