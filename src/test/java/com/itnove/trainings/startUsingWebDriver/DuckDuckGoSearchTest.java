package com.itnove.trainings.startUsingWebDriver;


import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class DuckDuckGoSearchTest extends BaseLocalRemoteWebDriverTest {
    @Test
    public void testSearch() {
        driver.get("https://duckduckgo.com/");
        driver.findElement(By.id("search_form_input_homepage")).click();
        driver.findElement(By.id("search_form_input_homepage")).clear();
        driver.findElement(By.id("search_form_input_homepage")).sendKeys("pizza hawaiana");
        driver.findElement(By.id("search_form_homepage")).submit();
    }

}