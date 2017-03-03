package com.itnove.trainings.junit.startUsingWebDriver;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;


/**
 * Created by guillem on 29/02/16.
 */
public class BaseTest {
    public RemoteWebDriver driver;

    @Before
    public void setUp() throws IOException {
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        System.setProperty("webdriver.gecko.driver", "src" + File.separator + "main" + File.separator + "resources" + File.separator + "geckodriver");
        driver = new FirefoxDriver(capabilities);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
