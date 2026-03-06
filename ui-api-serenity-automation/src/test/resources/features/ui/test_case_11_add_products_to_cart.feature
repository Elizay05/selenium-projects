@ui
Feature: Automation Exercise - UI - Add products to cart

  Scenario: User can add multiple products to the cart
    Given the user is browsing Automation Exercise
    When they open the home page
    And they navigate to products page
    When they add the first product to the cart
    And they continue shopping
    And they add the second product to the cart
    And they continue shopping
    And they navigate to cart page
    Then both products should be visible in the cart
    And their prices, quantity and total should be correct