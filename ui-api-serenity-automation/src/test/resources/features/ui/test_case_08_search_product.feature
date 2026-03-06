@ui
Feature: Automation Exercise - UI - Search Product

  Scenario: User can search for products
    Given the user is browsing Automation Exercise
    When they open the home page
    And they navigate to products page
    Then the All Products page title should be visible
    When they search for a product
    Then the searched products section should be visible
    And the searched products should be displayed