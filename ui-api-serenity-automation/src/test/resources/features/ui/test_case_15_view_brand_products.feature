@ui
Feature: Automation Exercise - UI - View brand products

  Scenario: User can view and navigate between brand products
    Given the user is browsing Automation Exercise
    When they open the home page
    And they navigate to products page
    Then brands should be visible on the left sidebar
    When they open the "Polo" brand
    Then the brand page for "Polo" should be visible
    When they open the "H&M" brand
    Then the brand page for "H&M" should be visible