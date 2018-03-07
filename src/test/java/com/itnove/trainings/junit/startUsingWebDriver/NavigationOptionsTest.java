package com.itnove.trainings.junit.startUsingWebDriver;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class NavigationOptionsTest {

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
    public void NavigationActions(){
        driver.navigate().to("http://www.google.com");
        driver.navigate().to("http://www.duckduckgo.com");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
