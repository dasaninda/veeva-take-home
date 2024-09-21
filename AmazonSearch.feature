Feature: Amazon Search Functionality

  Scenario: Search with a valid term
    Given I am on the Amazon homepage
    When I search for "laptop"
    Then I should see results related to "laptop"

  Scenario: Search with an invalid term
    Given I am on the Amazon homepage
    When I search for "asdkjasdkj"
    Then I should see a message "No results found" or see zero results

  Scenario: Search suggestions
    Given I am on the Amazon homepage
    When I start typing "iph"
    Then I should see suggestions containing "iPhone"

  Scenario: Search results pagination
    Given I am on the Amazon homepage
    When I search for "monitor"
    And I navigate to the next page of results
    Then I should see different results on the second page
