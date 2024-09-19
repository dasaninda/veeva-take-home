package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPage {
    WebDriver driver;

    By searchBox = By.id("search-input"); // Change this as per the actual locator
    By searchButton = By.id("search-button"); // Change this as per the actual locator
    By resultItems = By.cssSelector(".result-item"); // Change this as per the actual locator
    By noResultsMessage = By.id("no-results"); // Change this as per the actual locator
    By suggestionsList = By.id("suggestions"); // Change this as per the actual locator
    By nextPageButton = By.id("next-page"); // Change this as per the actual locator

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterSearchTerm(String term) {
        driver.findElement(searchBox).sendKeys(term);
    }

    public void clickSearch() {
        driver.findElement(searchButton).click();
    }

    public List<WebElement> getSearchResults() {
        return driver.findElements(resultItems);
    }

    public String getNoResultsMessage() {
        return driver.findElement(noResultsMessage).getText();
    }

    public List<WebElement> getSearchSuggestions() {
        return driver.findElements(suggestionsList);
    }

    public void clickNextPage() {
        driver.findElement(nextPageButton).click();
    }
}
