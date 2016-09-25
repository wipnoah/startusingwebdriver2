package com.itnove.trainings.junit.startUsingWebDriver.pages.searchPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by guillem on 01/03/16.
 */
public class SearchPage {

    private WebDriver driver;

    @FindBy(name = "q")
    public WebElement searchBox;

    @FindBy(name = "btnG")
    public WebElement searchButton;

    public SearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void searchKeyword(String keyword) {
        searchBox.clear();
        searchBox.sendKeys(keyword);
        searchButton.click();
    }
}
