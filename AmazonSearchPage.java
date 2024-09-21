package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AmazonSearchPage {
    WebDriver driver;

    // Locators for the search page
    By searchBox = By.id("twotabsearchtextbox");
    By searchButton = By.id("nav-search-submit-button");
    By resultItems = By.cssSelector(".s-main-slot .s-result-item");
    By noResultsMessage = By.xpath("//span[contains(text(),'No results for')]");
    By suggestionsList = By.cssSelector(".s-suggestion-container");
    By nextPageButton = By.cssSelector("a.s-pagination-next");

    public AmazonSearchPage(WebDriver driver) {
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
