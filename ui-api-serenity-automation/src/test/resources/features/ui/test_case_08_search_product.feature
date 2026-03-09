@ui
Feature: Automation Exercise - UI - Search Product

  Scenario: User can search for products
    Given the user is browsing Automation Exercise
    When they open the home page
    And they navigate to products page
    Then the products page should be visible
    When they search for "Saree"
    Then the searched products section should be visible
    And all products related to "Saree" should be visible