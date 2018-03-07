package com.itnove.trainings.junit.startUsingWebDriver;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class GoogleTitleTest extends BaseTest {

    @Test
    public void titleTest(){
        driver.navigate().to("http://www.google.com");
        assertTrue(driver.getTitle().toLowerCase().equals("google"));
    }

}
