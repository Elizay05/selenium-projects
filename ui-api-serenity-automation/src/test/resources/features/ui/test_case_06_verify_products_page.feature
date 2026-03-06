@ui
Feature: Automation Exercise - UI - Verify All Products page

  Scenario: User can open the All Products page from home
    Given the user is browsing Automation Exercise
    When they open the home page
    And they navigate to products page
    Then the All Products page title should be visible
    And the products list should be visible