@ui
Feature: Automation Exercise - UI - Verify Subscription in home page

  Scenario: User can subscribe from the home page
    Given the user is browsing Automation Exercise
    When they open the home page
    And they scroll to the footer
    Then the subscription section should be visible
    When they subscribe with an email
    Then a subscription success message should be displayed