package com.itnove.trainings.junit.startUsingWebDriver;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class GoogleTitleTest {

    public RemoteWebDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
//        System.setProperty("webdriver.gecko.driver",
//                "src" + File.separator + "main"
//                        + File.separator + "resources"
//                        + File.separator + "geckodriver-linux");
//        driver = new FirefoxDriver();
//        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//        System.setProperty("webdriver.chrome.driver", "src" + File.separator + "main"
//                + File.separator + "resources"
//                + File.separator + "chromedriver-linux");
//        driver = new ChromeDriver(capabilities);
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        //driver = new RemoteWebDriver(new
        //        URL("http://itnove:4394d787-3244-4c03-9490-3816f2bb683b@ondemand.saucelabs.com:80/wd/hub"),
        //        capabilities);
        driver = new RemoteWebDriver(new
                        URL("http://localhost:4444/wd/hub"),
                        capabilities);
    }

    @Test
    public void titleTest(){
        driver.navigate().to("http://www.google.com");
        assertTrue(driver.getTitle().toLowerCase().equals("google"));
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
