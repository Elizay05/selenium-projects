@ui
Feature: Automation Exercise - UI - Verify Product Detail page

  Scenario: User can open product detail page from products page
    Given the user is browsing Automation Exercise
    When they open the home page
    And they navigate to products page
    Then the products page should be visible
    And the products list should be visible
    When they open the first product
    Then they should see the product details
