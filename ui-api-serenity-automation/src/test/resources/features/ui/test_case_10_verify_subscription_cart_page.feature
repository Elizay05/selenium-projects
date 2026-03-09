@ui
Feature: Automation Exercise - UI - Verify Subscription in cart page

  Scenario: User can subscribe from cart page
    Given the user is browsing Automation Exercise
    When they open the home page
    And they navigate to cart page
    Then the cart page should be visible
    And they scroll to the footer
    Then the subscription section should be visible
    When they subscribe with an email
    Then a subscription success message should be displayed