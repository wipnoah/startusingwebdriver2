package com.itnove.trainings.junit.startUsingWebDriver;

import com.itnove.trainings.junit.startUsingWebDriver.pages.searchPage.ResultsPage;
import com.itnove.trainings.junit.startUsingWebDriver.pages.searchPage.SearchPage;
import org.junit.Assert;
import org.junit.Test;


/**
 * Unit test for simple App.
 */
public class AppTest extends BaseTest {

    @Test
    public void testApp() throws InterruptedException {
        driver.navigate().to("http://compendiumdev.co.uk/selenium/search.php");
        SearchPage searchPage = new SearchPage(driver);
        searchPage.searchKeyword("business center");
        ResultsPage resultsPage = new ResultsPage(driver);
        Assert.assertTrue(resultsPage.isResultsListPresent());
        resultsPage.clickOnFirstResult();
        Assert.assertTrue(!driver.getCurrentUrl().contains("compendiumdev"));
    }
}
