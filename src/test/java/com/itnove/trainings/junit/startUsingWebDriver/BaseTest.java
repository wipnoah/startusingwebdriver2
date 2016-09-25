package com.itnove.trainings.junit.startUsingWebDriver;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


import java.io.IOException;
import java.net.URL;


/**
 * Created by guillem on 29/02/16.
 */
public class BaseTest {
    public RemoteWebDriver driver;

    @Before
    public void setUp() throws IOException {
        String browser = System.getProperty("browser");
        DesiredCapabilities capabilities;
        if(browser.equals("chrome"))   capabilities = DesiredCapabilities.chrome();
        else if(browser.equals("firefox"))   capabilities = DesiredCapabilities.firefox();
        else if(browser.equals("ie"))   capabilities = DesiredCapabilities.internetExplorer();
        else  capabilities = DesiredCapabilities.firefox();
        System.setProperty("webdriver.gecko.driver", "/root/junitmaven/src/main/resources/geckodriver");
        driver = new FirefoxDriver(capabilities);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
