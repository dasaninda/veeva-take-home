package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import pageObjects.AmazonSearchPage;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;

import static org.junit.Assert.*;

public class AmazonSearchSteps {
    WebDriver driver;
    AmazonSearchPage searchPage;

    @Given("I am on the Amazon homepage")
    public void i_am_on_the_amazon_homepage() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.amazon.ca");
        searchPage = new AmazonSearchPage(driver);
    }

    @When("I search for {string}")
    public void i_search_for(String term) {
        searchPage.enterSearchTerm(term);
        searchPage.clickSearch();
    }

    @Then("I should see results related to {string}")
    public void i_should_see_results_related_to(String term) {
        List<WebElement> results = searchPage.getSearchResults();
        assertFalse("No results found!", results.isEmpty());
        for (WebElement result : results) {
            assertTrue(result.getText().toLowerCase().contains(term.toLowerCase()));
        }
        driver.quit();
    }

    @Then("I should see a message {string}")
    public void i_should_see_a_message(String message) {
        String noResultsText = searchPage.getNoResultsMessage();
        assertTrue(noResultsText.contains(message));
        driver.quit();
    }

    @When("I start typing {string}")
    public void i_start_typing(String partialTerm) {
        searchPage.enterSearchTerm(partialTerm);
    }

    @Then("I should see suggestions containing {string}")
    public void i_should_see_suggestions_containing(String term) {
        List<WebElement> suggestions = searchPage.getSearchSuggestions();
        assertFalse("No suggestions found!", suggestions.isEmpty());
        for (WebElement suggestion : suggestions) {
            assertTrue(suggestion.getText().toLowerCase().contains(term.toLowerCase()));
        }
        driver.quit();
    }

    @When("I navigate to the next page of results")
    public void i_navigate_to_the_next_page_of_results() {
        searchPage.clickNextPage();
    }

    @Then("I should see different results on the second page")
    public void i_should_see_different_results_on_the_second_page() {
        List<WebElement> results = searchPage.getSearchResults();
        assertFalse("No results found on the second page!", results.isEmpty());
        driver.quit();
    }
}
