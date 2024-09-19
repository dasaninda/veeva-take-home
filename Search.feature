Feature: Search Functionality

  Scenario: Search with valid term
    Given I am on the search page
    When I search for "Java programming"
    Then I should see results related to "Java programming"

  Scenario: Search with an invalid term
    Given I am on the search page
    When I search for "asdkjasdkj"
    Then I should see a message "No results found"

  Scenario: Search suggestions
    Given I am on the search page
    When I start typing "Jav"
    Then I should see suggestions containing "Java"

  Scenario: Search results pagination
    Given I am on the search page
    When I search for "Selenium"
    And I navigate to the next page of results
    Then I should see different results on the second page
