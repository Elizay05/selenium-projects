@ui
Feature: Automation Exercise - UI - Remove products from cart

  Scenario: User can remove products from cart
    Given the user is browsing Automation Exercise
    When they open the home page
    And they navigate to products page
    Then the products page should be visible
    When they add the following products to the cart
      | Winter Top |
      | Men Tshirt |
      | Sleeveless Dress |
    And they navigate to cart page
    Then the cart page should be visible
    When they remove the following products from the cart
      | Men Tshirt |
      | Sleeveless Dress |
    And the cart should contain the following products
      | Product              | Price | Qty | Total |
      | Winter Top           | 600   | 1   | 600   |